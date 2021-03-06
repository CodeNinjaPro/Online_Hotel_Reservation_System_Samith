//Generated by 24HRS
package Models;


public class Employee{

	private int employee_id;
	private String full_name;
	private String address;
	private String nic;
	private String contact;
	private String email;
	private String designation;
	private String date_time;

public Employee(){
}

public Employee(int employee_id){
	this.employee_id = employee_id;
}
public Employee(int employee_id,String full_name,String address,String nic,String contact,String email,String designation,String date_time){
	this.employee_id = employee_id;
	this.full_name = full_name;
	this.address = address;
	this.nic = nic;
	this.contact = contact;
	this.email = email;
	this.designation = designation;
	this.date_time = date_time;
}

public int getEmployee_id(){
return employee_id;
}

public void setEmployee_id(int employee_id){
	this.employee_id = employee_id;
}

public String getFull_name(){
return full_name;
}

public void setFull_name(String full_name){
	this.full_name = full_name;
}

public String getAddress(){
return address;
}

public void setAddress(String address){
	this.address = address;
}

public String getNic(){
return nic;
}

public void setNic(String nic){
	this.nic = nic;
}

public String getContact(){
return contact;
}

public void setContact(String contact){
	this.contact = contact;
}

public String getEmail(){
return email;
}

public void setEmail(String email){
	this.email = email;
}

public String getDesignation(){
return designation;
}

public void setDesignation(String designation){
	this.designation = designation;
}

public String getDate_time(){
return date_time;
}

public void setDate_time(String date_time){
	this.date_time = date_time;
}

}