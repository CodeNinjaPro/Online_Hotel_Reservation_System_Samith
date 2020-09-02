package Controllers;

import Models.Reservation;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ReservationController {

    Connector con = Connector.getInstance();

    private ReservationController() {
    }

    private static final ReservationController obj = new ReservationController();

    public static ReservationController getInstance() {
        return obj;
    }

    public void Save(Reservation data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO reservation(room_id,customer_id,in_date,out_date,date_time) values ('" + data.getRoom_id() + "','" + data.getCustomer_id() + "','" + data.getIn_date() + "','" + data.getOut_date() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Reservation data) throws Exception {
        con.getConnection();
        con.aud("UPDATE reservation SET room_id  = '" + data.getRoom_id() + "',customer_id  = '" + data.getCustomer_id() + "',in_date  = '" + data.getIn_date() + "',out_date  = '" + data.getOut_date() + "',date_time  = '" + data.getDate_time() + "' WHERE reservation_id = '" + data.getReservation_id() + "'");
    }

    public void Delete(Reservation data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM reservation WHERE reservation_id = '" + data.getReservation_id() + "'");
    }

    public List<Reservation> SearchAll() throws Exception {
        List<Reservation> objList = new ArrayList<Reservation>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM reservation");
        while (rset.next()) {
            Reservation obj = new Reservation();
            obj.setReservation_id(rset.getInt(1));
            obj.setRoom_id(rset.getInt(2));
            obj.setCustomer_id(rset.getInt(3));
            obj.setIn_date(rset.getString(4));
            obj.setOut_date(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Reservation> Search(Reservation data) throws Exception {
        List<Reservation> objList = new ArrayList<Reservation>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM reservation WHERE reservation_id = '" + data.getReservation_id() + "'");
        while (rset.next()) {
            Reservation obj = new Reservation();
            obj.setReservation_id(rset.getInt(1));
            obj.setRoom_id(rset.getInt(2));
            obj.setCustomer_id(rset.getInt(3));
            obj.setIn_date(rset.getString(4));
            obj.setOut_date(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
