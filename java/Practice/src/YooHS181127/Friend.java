package YooHS181127;

import java.io.*;

abstract class Friend extends Object implements Serializable {
	
	private String name, phoneNum, address;
	
	
	Friend(String name, String phoneNum, String address){
		this.name = name;
		this.phoneNum = phoneNum;
		this.address = address;
	}
	public String getName() {
		return name;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
		
	public void ShowInfo() {
		System.out.println("이름 : " + name);
		System.out.println("전화번호 : " + phoneNum);
		System.out.println("주소 : " + address);
	}
	
	abstract public void ShowBasicInfo();   

		
	
}

class MiddleFriend  extends Friend implements Serializable {

	private String Class;
		
	MiddleFriend(String name, String phoneNum, String address, String Class){
		super(name, phoneNum, address);
		this.Class = Class;
		
	}
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("반 : "+ Class);
	}
	public void ShowBasicInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("반 : "+ Class);
	}
	

	
}

class HighFriend extends Friend implements Serializable{

	private String work;
	
	HighFriend(String name, String phoneNum, String address, String work){
		super(name, phoneNum, address);
		this.work = work;
		
	}
	public void ShowInfo() {
		
		super.ShowInfo();
		System.out.println("직업 : "+ work);
		}
	
	public void ShowBasicInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("직업 : "+ work);
	}	

	
}

class UnivFriend  extends Friend implements Serializable{

	private String SchName;
	
	UnivFriend(String name, String phoneNum, String address, String SchName){
		super(name, phoneNum, address);
		this.SchName = SchName;
		
	}
	public void ShowInfo() {
		super.ShowInfo();
		System.out.println("학교 : "+ SchName);
	}
	
	@Override 
	public void ShowBasicInfo(){
		System.out.println("이름 : "+getName());
		System.out.println("학교 : "+ SchName);
	}	

	
}






