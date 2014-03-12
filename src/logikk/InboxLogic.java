package logikk;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

public class InboxLogic {
	
	private String bruker;
	private Object[][] varsel;
	private Object[][] alarm;
	Database db;
	
	public InboxLogic(String bruker){
		this.bruker = bruker;
		db = new Database();
		findVarsel();
		findAlarm();
	}
	
	public void findVarsel(){
		ResultSet rs = db.readQuery("SELECT beskjed, avtaleid, tidspunkt, dato FROM ansatt, haravtale, varsel WHERE ansatt.brukernavn = '"+this.bruker+"'");
		try {
			int count = 0;
			while (rs.next()){
				rs.next();
				varsel[count][0] = rs.getObject(1);
				varsel[count][1] = rs.getObject(2);
				String tidspunkt = Integer.toString(rs.getInt(3))+" "+Integer.toString(rs.getInt(4));
				varsel[count][2] = tidspunkt;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object[][] getVarsel(){
		return this.varsel;
	}
	
	public void findAlarm(){
		ResultSet rs = db.readQuery("SELECT avtale.avtaleid, tidspunkt, varsel.dato, sted, romid FROM ansatt, haravtale, varsel, avtale WHERE ansatt.brukernavn = '"+this.bruker+"'");
		try {
			int count = 0;
			while (rs.next()){
				alarm[count][0] = rs.getObject(1);
				String tidspunkt = Integer.toString(rs.getInt(2))+" "+Integer.toString(rs.getInt(3));
				alarm[count][1] = tidspunkt;
				if (rs.getInt(5) == 0){
					alarm[count][2] = rs.getString(4);
				} else {
					alarm[count][2] = rs.getInt(5);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public Object[][] getAlarm(){
		return this.alarm;
	}
}
