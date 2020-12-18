package dto;

import java.io.Serializable;

public class StaffsDTO implements Serializable{
private int staffId;
private String mail;
private String pass;
private String name;
private int gender;

public StaffsDTO() {}
public StaffsDTO(int staffId,String mail,String pass, String name,int gender) {
	this.staffId=staffId;
	this.mail=mail;
	this.pass=pass;
	this.name=name;
	this.gender=gender;
}
public int getStaffId() {
	return staffId;
}
public String getMail() {
	return mail;
}
public String getPass(){
	return pass;
}
public String getName() {
	return name;
}
public int getGender() {
	return gender;
}

}
