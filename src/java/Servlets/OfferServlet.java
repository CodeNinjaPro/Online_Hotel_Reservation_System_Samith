package Servlets;

import Models.Offer;
import Controllers.OfferController;
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

@WebServlet(name = "OfferServlet", urlPatterns = {"/OfferServlet"})

public class OfferServlet extends HttpServlet {

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
                double amount = Double.parseDouble(request.getParameter("amount"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Offer obj = new Offer();
                obj.setDescription(description);
                obj.setType(type);
                obj.setAmount(amount);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    OfferController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int offer_id = Integer.parseInt(request.getParameter("offer_id"));
                String description = request.getParameter("description");
                String type = request.getParameter("type");
                double amount = Double.parseDouble(request.getParameter("amount"));
                String status = request.getParameter("status");
                String date_time = request.getParameter("date_time");
                Offer obj = new Offer();
                obj.setOffer_id(offer_id);
                obj.setDescription(description);
                obj.setType(type);
                obj.setAmount(amount);
                obj.setStatus(status);
                obj.setDate_time(date_time);
                try {
                    OfferController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int offer_id = Integer.parseInt(request.getParameter("offer_id"));
                Offer obj = new Offer();
                obj.setOffer_id(offer_id);
                try {
                    OfferController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Offer> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = OfferController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getOffer_id() + "_" + list.get(i).getDescription() + "_" + list.get(i).getType() + "_" + list.get(i).getAmount() + "_" + list.get(i).getStatus() + "_" + list.get(i).getDate_time() + "_";
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
