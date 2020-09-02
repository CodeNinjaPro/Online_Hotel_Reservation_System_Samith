package Models;

public class Customer {

    private int customer_;
    private String name;
    private String address;
    private String email;
    private String loyalty;
    private String date_time;

    public Customer() {
    }

    public Customer(int customer_) {
        this.customer_ = customer_;
    }

    public Customer(int customer_, String name, String address, String email, String loyalty, String date_time) {
        this.customer_ = customer_;
        this.name = name;
        this.address = address;
        this.email = email;
        this.loyalty = loyalty;
        this.date_time = date_time;
    }

    public int getCustomer_() {
        return customer_;
    }

    public void setCustomer_(int customer_) {
        this.customer_ = customer_;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLoyalty() {
        return loyalty;
    }

    public void setLoyalty(String loyalty) {
        this.loyalty = loyalty;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
