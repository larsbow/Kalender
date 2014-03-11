package logikk;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;


public class LoginLogic {
	
	private String pw;
	private String user;
	Database db = new Database();
	
	public LoginLogic(String username){
		setUser(username);
		setPw();
	}
	
	public boolean isTrue(String pw){
		if (pw == this.pw){
			return true;
		} else {
			return false;
		}
	}
	
	public void setUser(String username){
		ResultSet rs = db.readQuery("SELECT brukernavn FROM ansatt WHERE (brukernavn = '"+username+"')");
		try {
			if (rs.getRow() == 1){
				this.user = username;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getUser(){
		return this.user;
	}
	
	public void setPw(){
		try {
			ResultSet rs = db.readQuery("SELECT passord FROM ansatt WHERE (brukernavn = '"+this.user+"')");
			if ( rs.getRow() > 0){
			this.pw = rs.getString("passord");
			} else {
				this.pw = "";
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public String getPw(){
		return this.pw;
	}
}
