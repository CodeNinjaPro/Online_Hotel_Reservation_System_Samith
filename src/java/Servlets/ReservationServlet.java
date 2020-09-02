package Servlets;

import Models.Reservation;
import Controllers.ReservationController;
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

@WebServlet(name = "ReservationServlet", urlPatterns = {"/ReservationServlet"})

public class ReservationServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            String action = request.getParameter("action");
            String pattern = "yyyy/MM/dd - HH:mm:ss";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            String current_date = simpleDateFormat.format(new Date());

            if (action.equals("insert")) {
                int room_id = Integer.parseInt(request.getParameter("room_id"));
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                String in_date = request.getParameter("in_date");
                String out_date = request.getParameter("out_date");
                String date_time = request.getParameter("date_time");
                Reservation obj = new Reservation();
                obj.setRoom_id(room_id);
                obj.setCustomer_id(customer_id);
                obj.setIn_date(in_date);
                obj.setOut_date(out_date);
                obj.setDate_time(date_time);
                try {
                    ReservationController.getInstance().Save(obj);
                    response.getWriter().println("Saved!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("update")) {
                int reservation_id = Integer.parseInt(request.getParameter("reservation_id"));
                int room_id = Integer.parseInt(request.getParameter("room_id"));
                int customer_id = Integer.parseInt(request.getParameter("customer_id"));
                String in_date = request.getParameter("in_date");
                String out_date = request.getParameter("out_date");
                String date_time = request.getParameter("date_time");
                Reservation obj = new Reservation();
                obj.setReservation_id(reservation_id);
                obj.setRoom_id(room_id);
                obj.setCustomer_id(customer_id);
                obj.setIn_date(in_date);
                obj.setOut_date(out_date);
                obj.setDate_time(date_time);
                try {
                    ReservationController.getInstance().Update(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }

            } else if (action.equals("delete")) {
                int reservation_id = Integer.parseInt(request.getParameter("reservation_id"));
                Reservation obj = new Reservation();
                obj.setReservation_id(reservation_id);
                try {
                    ReservationController.getInstance().Delete(obj);
                    response.getWriter().println("Updated!");
                } catch (Exception ex) {
                    //error
                }
            } else if (action.equals("serch")) {
                try {
                    List<Reservation> list = new ArrayList<>();
                    List stringList = new ArrayList<>();

                    list = ReservationController.getInstance().SearchAll();
                    for (int i = 0; i < list.size(); i++) {
                        String s = list.get(i).getReservation_id() + "_" + list.get(i).getRoom_id() + "_" + list.get(i).getCustomer_id() + "_" + list.get(i).getIn_date() + "_" + list.get(i).getOut_date() + "_" + list.get(i).getDate_time() + "_";
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
