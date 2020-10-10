package Controllers;

import Models.Salary_plan;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Salary_planController {

    Connector con = Connector.getInstance();

    private Salary_planController() {
    }

    private static final Salary_planController obj = new Salary_planController();

    public static Salary_planController getInstance() {
        return obj;
    }

    public void Save(Salary_plan data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO salary_plan(category,basic_salary,ot_rate,allowance,date_time) values ('" + data.getCategory() + "','" + data.getBasic_salary() + "','" + data.getOt_rate() + "','" + data.getAllowance() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Salary_plan data) throws Exception {
        con.getConnection();
        con.aud("UPDATE salary_plan SET category  = '" + data.getCategory() + "',basic_salary  = '" + data.getBasic_salary() + "',ot_rate  = '" + data.getOt_rate() + "',allowance  = '" + data.getAllowance() + "',date_time  = '" + data.getDate_time() + "' WHERE salary_plan_id = '" + data.getSalary_plan_id() + "'");
    }

    public void Delete(Salary_plan data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM salary_plan WHERE salary_plan_id = '" + data.getSalary_plan_id() + "'");
    }

    public List<Salary_plan> SearchAll() throws Exception {
        List<Salary_plan> objList = new ArrayList<Salary_plan>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM salary_plan");
        while (rset.next()) {
            Salary_plan obj = new Salary_plan();
            obj.setSalary_plan_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setBasic_salary(rset.getDouble(3));
            obj.setOt_rate(rset.getDouble(4));
            obj.setAllowance(rset.getDouble(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Salary_plan> Search(Salary_plan data) throws Exception {
        List<Salary_plan> objList = new ArrayList<Salary_plan>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM salary_plan WHERE salary_plan_id = '" + data.getSalary_plan_id() + "'");
        while (rset.next()) {
            Salary_plan obj = new Salary_plan();
            obj.setSalary_plan_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setBasic_salary(rset.getDouble(3));
            obj.setOt_rate(rset.getDouble(4));
            obj.setAllowance(rset.getDouble(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public Salary_plan SearchByDesignation(String designation) throws Exception {
        con.getConnection();
        Salary_plan obj = new Salary_plan();
        ResultSet rset = con.srh("SELECT * FROM salary_plan WHERE category = '" + designation + "'");
        while (rset.next()) {
            obj.setSalary_plan_id(rset.getInt(1));
            obj.setCategory(rset.getString(2));
            obj.setBasic_salary(rset.getDouble(3));
            obj.setOt_rate(rset.getDouble(4));
            obj.setAllowance(rset.getDouble(5));
            obj.setDate_time(rset.getString(6));
        }

        return obj;
    }

}
