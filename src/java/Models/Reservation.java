package Models;

public class Reservation {

    private int reservation_id;
    private int room_id;
    private int customer_id;
    private String in_date;
    private String out_date;
    private String date_time;

    public Reservation() {
    }

    public Reservation(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public Reservation(int reservation_id, int room_id, int customer_id, String in_date, String out_date, String date_time) {
        this.reservation_id = reservation_id;
        this.room_id = room_id;
        this.customer_id = customer_id;
        this.in_date = in_date;
        this.out_date = out_date;
        this.date_time = date_time;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getIn_date() {
        return in_date;
    }

    public void setIn_date(String in_date) {
        this.in_date = in_date;
    }

    public String getOut_date() {
        return out_date;
    }

    public void setOut_date(String out_date) {
        this.out_date = out_date;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
