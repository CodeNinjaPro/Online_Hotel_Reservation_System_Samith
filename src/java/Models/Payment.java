package Models;

public class Payment {

    private int payment_id;
    private int reservation_id;
    private double amount;
    private String payment_type;
    private String date_time;

    public Payment() {
    }

    public Payment(int payment_id) {
        this.payment_id = payment_id;
    }

    public Payment(int payment_id, int reservation_id, double amount, String payment_type, String date_time) {
        this.payment_id = payment_id;
        this.reservation_id = reservation_id;
        this.amount = amount;
        this.payment_type = payment_type;
        this.date_time = date_time;
    }

    public int getPayment_id() {
        return payment_id;
    }

    public void setPayment_id(int payment_id) {
        this.payment_id = payment_id;
    }

    public int getReservation_id() {
        return reservation_id;
    }

    public void setReservation_id(int reservation_id) {
        this.reservation_id = reservation_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getPayment_type() {
        return payment_type;
    }

    public void setPayment_type(String payment_type) {
        this.payment_type = payment_type;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
