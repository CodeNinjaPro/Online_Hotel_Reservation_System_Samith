package Models;

public class Offer {

    private int offer_id;
    private String description;
    private String type;
    private double amount;
    private String status;
    private String date_time;

    public Offer() {
    }

    public Offer(int offer_id) {
        this.offer_id = offer_id;
    }

    public Offer(int offer_id, String description, String type, double amount, String status, String date_time) {
        this.offer_id = offer_id;
        this.description = description;
        this.type = type;
        this.amount = amount;
        this.status = status;
        this.date_time = date_time;
    }

    public int getOffer_id() {
        return offer_id;
    }

    public void setOffer_id(int offer_id) {
        this.offer_id = offer_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
