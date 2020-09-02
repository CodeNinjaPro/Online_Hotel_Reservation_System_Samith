package Controllers;

import Models.Finance_details;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class Finance_detailsController {

    Connector con = Connector.getInstance();

    private Finance_detailsController() {
    }

    private static final Finance_detailsController obj = new Finance_detailsController();

    public static Finance_detailsController getInstance() {
        return obj;
    }

    public void Save(Finance_details data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO finance_details(description,type,status,date_time) values ('" + data.getDescription() + "','" + data.getType() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Finance_details data) throws Exception {
        con.getConnection();
        con.aud("UPDATE finance_details SET description  = '" + data.getDescription() + "',type  = '" + data.getType() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE finance_details_id = '" + data.getFinance_details_id() + "'");
    }

    public void Delete(Finance_details data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM finance_details WHERE finance_details_id = '" + data.getFinance_details_id() + "'");
    }

    public List<Finance_details> SearchAll() throws Exception {
        List<Finance_details> objList = new ArrayList<Finance_details>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM finance_details");
        while (rset.next()) {
            Finance_details obj = new Finance_details();
            obj.setFinance_details_id(rset.getInt(1));
            obj.setDescription(rset.getString(2));
            obj.setType(rset.getString(3));
            obj.setStatus(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

    public List<Finance_details> Search(Finance_details data) throws Exception {
        List<Finance_details> objList = new ArrayList<Finance_details>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM finance_details WHERE finance_details_id = '" + data.getFinance_details_id() + "'");
        while (rset.next()) {
            Finance_details obj = new Finance_details();
            obj.setFinance_details_id(rset.getInt(1));
            obj.setDescription(rset.getString(2));
            obj.setType(rset.getString(3));
            obj.setStatus(rset.getString(4));
            obj.setDate_time(rset.getString(5));
            objList.add(obj);
        }

        return objList;
    }

}
