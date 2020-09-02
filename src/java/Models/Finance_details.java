package Models;

public class Finance_details {

    private int finance_details_id;
    private String description;
    private String type;
    private String status;
    private String date_time;

    public Finance_details() {
    }

    public Finance_details(int finance_details_id) {
        this.finance_details_id = finance_details_id;
    }

    public Finance_details(int finance_details_id, String description, String type, String status, String date_time) {
        this.finance_details_id = finance_details_id;
        this.description = description;
        this.type = type;
        this.status = status;
        this.date_time = date_time;
    }

    public int getFinance_details_id() {
        return finance_details_id;
    }

    public void setFinance_details_id(int finance_details_id) {
        this.finance_details_id = finance_details_id;
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
