package Models;

public class Salary_plan {

    private int salary_plan_id;
    private String category;
    private double basic_salary;
    private double ot_rate;
    private double allowance;
    private String date_time;

    public Salary_plan() {
    }

    public Salary_plan(int salary_plan_id) {
        this.salary_plan_id = salary_plan_id;
    }

    public Salary_plan(int salary_plan_id, String category, double basic_salary, double ot_rate, double allowance, String date_time) {
        this.salary_plan_id = salary_plan_id;
        this.category = category;
        this.basic_salary = basic_salary;
        this.ot_rate = ot_rate;
        this.allowance = allowance;
        this.date_time = date_time;
    }

    public int getSalary_plan_id() {
        return salary_plan_id;
    }

    public void setSalary_plan_id(int salary_plan_id) {
        this.salary_plan_id = salary_plan_id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public double getBasic_salary() {
        return basic_salary;
    }

    public void setBasic_salary(double basic_salary) {
        this.basic_salary = basic_salary;
    }

    public double getOt_rate() {
        return ot_rate;
    }

    public void setOt_rate(double ot_rate) {
        this.ot_rate = ot_rate;
    }

    public double getAllowance() {
        return allowance;
    }

    public void setAllowance(double allowance) {
        this.allowance = allowance;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
