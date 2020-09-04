package Servlets;

import Models.Payment;
import Controllers.PaymentController;
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

@WebServlet(name = "PaymentServlet", urlPatterns = {"/PaymentServlet"})

public class PaymentServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int reservation_id = Integer.parseInt(request.getParameter("reservation_id"));
                double amount = Double.parseDouble(request.getParameter("amount"));
                String payment_type = request.getParameter("payment_type");
                Payment obj = new Payment();
                obj.setReservation_id(reservation_id);
                obj.setAmount(amount);
                obj.setPayment_type(payment_type);
                obj.setDate_time(current_date);
                try {
                    PaymentController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int payment_id = Integer.parseInt(request.getParameter("payment_id"));
                int reservation_id = Integer.parseInt(request.getParameter("reservation_id"));
                double amount = Double.parseDouble(request.getParameter("amount"));
                String payment_type = request.getParameter("payment_type");
                Payment obj = new Payment();
                obj.setPayment_id(payment_id);
                obj.setReservation_id(reservation_id);
                obj.setAmount(amount);
                obj.setPayment_type(payment_type);
                obj.setDate_time(current_date);
                try {
                    PaymentController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int payment_id = Integer.parseInt(request.getParameter("payment_id"));
                Payment obj = new Payment();
                obj.setPayment_id(payment_id);
                try {
                    PaymentController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Payment> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = PaymentController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getPayment_id() + "_" + list.get(i).getReservation_id() + "_" + list.get(i).getAmount() + "_" + list.get(i).getPayment_type() + "_" + list.get(i).getDate_time() + "_";
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
