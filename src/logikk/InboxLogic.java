package logikk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;

public class InboxLogic {
	
	private String bruker;
	private ArrayList<String> varsel = new ArrayList<String>();
	private ArrayList<String> alarm = new ArrayList<String>();
	Database db;
	
	public InboxLogic(String bruker){
		this.bruker = bruker;
		db = new Database();
		findVarsel();
		findAlarm();
	}
	
	public void findVarsel(){
		ResultSet rs = db.readQuery("SELECT beskjed, avtaleid, tidspunkt, dato, haravtale.brukernavn FROM ansatt, haravtale, varsel WHERE haravtale.brukernavn = '"+this.bruker+"'");
		try {
			while (rs.next()){
				varsel.add("Endring i avtale" +rs.getString(2) + ": " + rs.getString(1) + " skjedde " + Integer.toString(rs.getInt(3))+" "+Integer.toString(rs.getInt(4)));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getVarsel(){
		return this.varsel;
	}
	
	public void findAlarm(){
		ResultSet rs = db.readQuery("SELECT avtale.avtaleid, tidspunkt, varsel.dato, sted, romid, haravtale.brukernavn FROM haravtale, varsel, avtale WHERE haravtale.brukernavn = '"+this.bruker+"'");
		try {
			int count = 0;
			while (rs.next()){
				alarm.add("ALARM: AvtaleID"+ rs.getString(1) + " starter "+Integer.toString(rs.getInt(2))+" "+Integer.toString(rs.getInt(3))+" ");
				if (rs.getObject(5) == null){
					alarm.set(count, alarm.get(count)+" i "+rs.getString(4)+"\n");
				} else {
					alarm.set(count,  alarm.get(count)+"i rom nr "+rs.getInt(5) + "\n");
				}
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<String> getAlarm(){
		return this.alarm;
	}
}
