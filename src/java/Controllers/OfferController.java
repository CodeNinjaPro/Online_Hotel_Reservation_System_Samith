package Controllers;

import Models.Offer;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class OfferController {

    Connector con = Connector.getInstance();

    private OfferController() {
    }

    private static final OfferController obj = new OfferController();

    public static OfferController getInstance() {
        return obj;
    }

    public void Save(Offer data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO offer(description,type,amount,status,date_time) values ('" + data.getDescription() + "','" + data.getType() + "','" + data.getAmount() + "','" + data.getStatus() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Offer data) throws Exception {
        con.getConnection();
        con.aud("UPDATE offer SET description  = '" + data.getDescription() + "',type  = '" + data.getType() + "',amount  = '" + data.getAmount() + "',status  = '" + data.getStatus() + "',date_time  = '" + data.getDate_time() + "' WHERE offer_id = '" + data.getOffer_id() + "'");
    }

    public void Delete(Offer data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM offer WHERE offer_id = '" + data.getOffer_id() + "'");
    }

    public List<Offer> SearchAll() throws Exception {
        List<Offer> objList = new ArrayList<Offer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM offer");
        while (rset.next()) {
            Offer obj = new Offer();
            obj.setOffer_id(rset.getInt(1));
            obj.setDescription(rset.getString(2));
            obj.setType(rset.getString(3));
            obj.setAmount(rset.getDouble(4));
            obj.setStatus(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

    public List<Offer> Search(Offer data) throws Exception {
        List<Offer> objList = new ArrayList<Offer>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM offer WHERE offer_id = '" + data.getOffer_id() + "'");
        while (rset.next()) {
            Offer obj = new Offer();
            obj.setOffer_id(rset.getInt(1));
            obj.setDescription(rset.getString(2));
            obj.setType(rset.getString(3));
            obj.setAmount(rset.getDouble(4));
            obj.setStatus(rset.getString(5));
            obj.setDate_time(rset.getString(6));
            objList.add(obj);
        }

        return objList;
    }

}
