/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import Controllers.AttendaceController;
import Controllers.EmployeeController;
import Controllers.Salary_planController;
import Models.Attendace;
import Models.Salary_plan;
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

/**
 *
 * @author Roshan Withanage
 */
@WebServlet(name = "SalaryViewServlet", urlPatterns = {"/SalaryViewServlet"})
public class SalaryViewServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */

//            response.getWriter().println("okay");
            int employee_id = Integer.parseInt(request.getParameter("employee_id"));
            String year = request.getParameter("year");
            String month = request.getParameter("month");

            try {
                List<Attendace> list = new ArrayList<>();
                list = AttendaceController.getInstance().getAttendanceMonth(employee_id, year, month);

                if (list.size() > 0) {

                    String designation = EmployeeController.getInstance().getDesignation(employee_id);

                    Salary_plan plan = new Salary_plan();
                    plan = Salary_planController.getInstance().SearchByDesignation(designation);

                    double no_of_days = list.size();
                    double no_of_ot = 0;

                    for (int i = 0; i < list.size(); i++) {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
                        Date date1 = format.parse(list.get(i).getIn_time());
                        Date date2 = format.parse(list.get(i).getOut_time());
                        long difference = date2.getTime() - date1.getTime();
                        no_of_ot += Math.round(difference / 3600000 * 100.0) / 100.0;
                    }

                    double salary_per_day = plan.getBasic_salary() / 25;
                    double total_for_epf = salary_per_day * no_of_days;
                    double allowance = plan.getAllowance();
                    double ot_rate = plan.getOt_rate();

                    double gross_salary = Math.round(total_for_epf + allowance + (no_of_ot * ot_rate) * 100.0) / 100.0;

                    double epf_deduction = total_for_epf * 0.08;
                    double net_salary = gross_salary - epf_deduction;

                    String data = employee_id + "_" + year + "_" + month + "_" + no_of_days + "_" + salary_per_day + "_"
                            + total_for_epf + "_" + no_of_ot + "_" + ot_rate + "_" + allowance + "_" + gross_salary + "_" + epf_deduction
                            + "_" + net_salary;
                    response.getWriter().println(data);

                } else {
                    response.getWriter().println("salary not avalable");
                }

            } catch (Exception e) {
            }

        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
