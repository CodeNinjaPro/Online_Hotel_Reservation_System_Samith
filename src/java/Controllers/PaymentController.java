package Controllers;

import Models.Payment;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class PaymentController {

    Connector con = Connector.getInstance();

    private PaymentController() {
    }

    private static final PaymentController obj = new PaymentController();

    public static PaymentController getInstance() {
        return obj;
    }

    public void Save(Payment data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO payment(reservation_id,amount,payment_type,date_time) values ('" + data.getReservation_id() + "','" + data.getAmount() + "','" + data.getPayment_type() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Payment data) throws Exception {
        con.getConnection();
        con.aud("UPDATE payment SET reservation_id  = '" + data.getReservation_id() + "',amount  = '" + data.getAmount() + "',payment_type  = '" + data.getPayment_type() + "',date_time  = '" + data.getDate_time() + "' WHERE payment_id = '" + data.getPayment_id() + "'");
    }

    public void Delete(Payment data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM payment WHERE payment_id = '" + data.getPayment_id() + "'");
    }

    public List<Payment> SearchAll() throws Exception {
        List<Payment> objList = new ArrayList<Payment>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM payment");
        while (rset.next()) {
            Payment obj = new Payment();
            obj.setPayment_id(rset.getInt(1));
            obj.setReservation_id(rset.getInt(2));
            obj.setAmount(rset.getDouble(3));
            obj.setPayment_type(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

    public List<Payment> Search(Payment data) throws Exception {
        List<Payment> objList = new ArrayList<Payment>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM payment WHERE payment_id = '" + data.getPayment_id() + "'");
        while (rset.next()) {
            Payment obj = new Payment();
            obj.setPayment_id(rset.getInt(1));
            obj.setReservation_id(rset.getInt(2));
            obj.setAmount(rset.getDouble(3));
            obj.setPayment_type(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

}
