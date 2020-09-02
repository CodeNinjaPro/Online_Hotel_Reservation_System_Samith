package Controllers;

import Models.Room;
import DataBaseConnector.Connector;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class RoomController {

    Connector con = Connector.getInstance();

    private RoomController() {
    }

    private static final RoomController obj = new RoomController();

    public static RoomController getInstance() {
        return obj;
    }

    public void Save(Room data) throws Exception {
        con.getConnection();
        con.aud("INSERT INTO room(type,name,img,description,price,no_of_rooms,date_time) values ('" + data.getType() + "','" + data.getName() + "','" + data.getImg() + "','" + data.getDescription() + "','" + data.getPrice() + "','" + data.getNo_of_rooms() + "','" + data.getDate_time() + "') ");
    }

    public void Update(Room data) throws Exception {
        con.getConnection();
        con.aud("UPDATE room SET type  = '" + data.getType() + "',name  = '" + data.getName() + "',img  = '" + data.getImg() + "',description  = '" + data.getDescription() + "',price  = '" + data.getPrice() + "',no_of_rooms  = '" + data.getNo_of_rooms() + "',date_time  = '" + data.getDate_time() + "' WHERE room_id = '" + data.getRoom_id() + "'");
    }

    public void Delete(Room data) throws Exception {
        con.getConnection();
        con.aud("DELETE FROM room WHERE room_id = '" + data.getRoom_id() + "'");
    }

    public List<Room> SearchAll() throws Exception {
        List<Room> objList = new ArrayList<Room>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM room");
        while (rset.next()) {
            Room obj = new Room();
            obj.setRoom_id(rset.getInt(1));
            obj.setType(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setImg(rset.getString(4));
            obj.setDescription(rset.getString(5));
            obj.setPrice(rset.getDouble(6));
            obj.setNo_of_rooms(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

    public List<Room> Search(Room data) throws Exception {
        List<Room> objList = new ArrayList<Room>();
        con.getConnection();
        ResultSet rset = con.srh("SELECT * FROM room WHERE room_id = '" + data.getRoom_id() + "'");
        while (rset.next()) {
            Room obj = new Room();
            obj.setRoom_id(rset.getInt(1));
            obj.setType(rset.getString(2));
            obj.setName(rset.getString(3));
            obj.setImg(rset.getString(4));
            obj.setDescription(rset.getString(5));
            obj.setPrice(rset.getDouble(6));
            obj.setNo_of_rooms(rset.getString(7));
            obj.setDate_time(rset.getString(8));
            objList.add(obj);
        }

        return objList;
    }

}
