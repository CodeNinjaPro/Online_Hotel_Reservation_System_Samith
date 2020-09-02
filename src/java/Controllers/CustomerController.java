package Controllers;

import Models.Customer;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CustomerController {

    Connector con = Connector.getInstance();

    private CustomerController() {
    }

    private static final CustomerController obj = new CustomerController();

    public static CustomerController getInstance() {
        return obj;
    }

    public void Save(Customer data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO customer(name,address,email,loyalty,date_time) values ('" + data.getName() + "','" + data.getAddress() + "','" + data.getEmail() + "','" + data.getLoyalty() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Customer data) throws Exception {
        con.getConnection();
        con.aud("UPDATE customer SET name  = '" + data.getName() + "',address  = '" + data.getAddress() + "',email  = '" + data.getEmail() + "',loyalty  = '" + data.getLoyalty() + "',date_time  = '" + data.getDate_time() + "' WHERE customer_ = '" + data.getCustomer_() + "'");
    }

    public void Delete(Customer data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM customer WHERE customer_ = '" + data.getCustomer_() + "'");
    }

    public List<Customer> SearchAll() throws Exception {
        List<Customer> objList = new ArrayList<Customer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM customer");
        while (rset.next()) {
            Customer obj = new Customer();
            obj.setCustomer_(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setLoyalty(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Customer> Search(Customer data) throws Exception {
        List<Customer> objList = new ArrayList<Customer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM customer WHERE customer_ = '" + data.getCustomer_() + "'");
        while (rset.next()) {
            Customer obj = new Customer();
            obj.setCustomer_(rset.getInt(1));
            obj.setName(rset.getString(2));
            obj.setAddress(rset.getString(3));
            obj.setEmail(rset.getString(4));
            obj.setLoyalty(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
