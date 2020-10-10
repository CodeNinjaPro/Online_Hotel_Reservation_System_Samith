package Servlets;

import Models.Salary_plan;
import Controllers.Salary_planController;
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

@WebServlet(name = "Salary_planServlet", urlPatterns = {"/Salary_planServlet"})

public class Salary_planServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                String category = request.getParameter("category");
                double basic_salary = Double.parseDouble(request.getParameter("basic_salary"));
                double ot_rate = Double.parseDouble(request.getParameter("ot_rate"));
                double allowance = Double.parseDouble(request.getParameter("allowance"));
                Salary_plan obj = new Salary_plan();
                obj.setCategory(category);
                obj.setBasic_salary(basic_salary);
                obj.setOt_rate(ot_rate);
                obj.setAllowance(allowance);
                obj.setDate_time(current_date);
                try {
                    Salary_planController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int salary_plan_id = Integer.parseInt(request.getParameter("salary_plan_id"));
                String category = request.getParameter("category");
                double basic_salary = Double.parseDouble(request.getParameter("basic_salary"));
                double ot_rate = Double.parseDouble(request.getParameter("ot_rate"));
                double allowance = Double.parseDouble(request.getParameter("allowance"));
                Salary_plan obj = new Salary_plan();
                obj.setSalary_plan_id(salary_plan_id);
                obj.setCategory(category);
                obj.setBasic_salary(basic_salary);
                obj.setOt_rate(ot_rate);
                obj.setAllowance(allowance);
                obj.setDate_time(current_date);
                try {
                    Salary_planController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int salary_plan_id = Integer.parseInt(request.getParameter("salary_plan_id"));
                Salary_plan obj = new Salary_plan();
                obj.setSalary_plan_id(salary_plan_id);
                try {
                    Salary_planController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Salary_plan> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = Salary_planController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getSalary_plan_id() + "_" + list.get(i).getCategory() + "_" + list.get(i).getBasic_salary() + "_" + list.get(i).getOt_rate() + "_" + list.get(i).getAllowance() + "_" + list.get(i).getDate_time() + "_";
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
