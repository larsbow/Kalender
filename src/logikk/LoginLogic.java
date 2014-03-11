package logikk;

import database.Database;


public class LoginLogic {
	
	protected String pw;
	public String user;
	Database db;
	
	public boolean isTrue(){
		db.readQuery("SELECT passord FROM ansatt WHERE passord = "+pw);
	}
	
	public void setUser(String username){
		user = username;
	}
	
	public String getUser(){
		return user;
	}
	
	public void setPw(String password){
		pw = password;
	}
	
	public String getPw(){
		return pw;
	}
}
