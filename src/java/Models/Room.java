package Models;

public class Room {

    private int room_id;
    private String type;
    private String name;
    private String img;
    private String description;
    private double price;
    private String no_of_rooms;
    private String date_time;

    public Room() {
    }

    public Room(int room_id) {
        this.room_id = room_id;
    }

    public Room(int room_id, String type, String name, String img, String description, double price, String no_of_rooms, String date_time) {
        this.room_id = room_id;
        this.type = type;
        this.name = name;
        this.img = img;
        this.description = description;
        this.price = price;
        this.no_of_rooms = no_of_rooms;
        this.date_time = date_time;
    }

    public int getRoom_id() {
        return room_id;
    }

    public void setRoom_id(int room_id) {
        this.room_id = room_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNo_of_rooms() {
        return no_of_rooms;
    }

    public void setNo_of_rooms(String no_of_rooms) {
        this.no_of_rooms = no_of_rooms;
    }

    public String getDate_time() {
        return date_time;
    }

    public void setDate_time(String date_time) {
        this.date_time = date_time;
    }

}
