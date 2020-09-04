package Servlets;

import Models.Finance_details;
import Controllers.Finance_detailsController;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Finance_detailsServlet", urlPatterns = {"/Finance_detailsServlet"})

public class Finance_detailsServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                String description = request.getParameter("description");
                String type = request.getParameter("type");
                String status = request.getParameter("status");
                Finance_details obj = new Finance_details();
                obj.setDescription(description);
                obj.setType(type);
                obj.setStatus(status);
                obj.setDate_time(current_date);
                try {
                    Finance_detailsController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int finance_details_id = Integer.parseInt(request.getParameter("finance_details_id"));
                String description = request.getParameter("description");
                String type = request.getParameter("type");
                String status = request.getParameter("status");
                Finance_details obj = new Finance_details();
                obj.setFinance_details_id(finance_details_id);
                obj.setDescription(description);
                obj.setType(type);
                obj.setStatus(status);
                obj.setDate_time(current_date);
                try {
                    Finance_detailsController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int finance_details_id = Integer.parseInt(request.getParameter("finance_details_id"));
                Finance_details obj = new Finance_details();
                obj.setFinance_details_id(finance_details_id);
                try {
                    Finance_detailsController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Finance_details> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = Finance_detailsController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getFinance_details_id() + "_" + list.get(i).getDescription() + "_" + list.get(i).getType() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
                        stringList.add(s);
                    }
                    String b = String.join("~", stringList);
                    response.getWriter().println(b);
                } catch (Exception ex) {
                    //Error
                }

            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
