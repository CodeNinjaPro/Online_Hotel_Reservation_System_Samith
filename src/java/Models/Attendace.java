//Generated by 24HRS
package Models;


public class Attendace{

	private int attendance_id;
	private int employee_id;
	private String in_time;
	private String out_time;
	private String date_time;

public Attendace(){
}

public Attendace(int attendance_id){
	this.attendance_id = attendance_id;
}
public Attendace(int attendance_id,int employee_id,String in_time,String out_time,String date_time){
	this.attendance_id = attendance_id;
	this.employee_id = employee_id;
	this.in_time = in_time;
	this.out_time = out_time;
	this.date_time = date_time;
}

public int getAttendance_id(){
return attendance_id;
}

public void setAttendance_id(int attendance_id){
	this.attendance_id = attendance_id;
}

public int getEmployee_id(){
return employee_id;
}

public void setEmployee_id(int employee_id){
	this.employee_id = employee_id;
}

public String getIn_time(){
return in_time;
}

public void setIn_time(String in_time){
	this.in_time = in_time;
}

public String getOut_time(){
return out_time;
}

public void setOut_time(String out_time){
	this.out_time = out_time;
}

public String getDate_time(){
return date_time;
}

public void setDate_time(String date_time){
	this.date_time = date_time;
}

}