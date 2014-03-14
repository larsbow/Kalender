package logikk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import org.joda.time.DateTime;

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
		ResultSet rs = db.readQuery("SELECT beskjed, avtaleid, tidspunkt, dato, brukernavn"
				+ " FROM ansatt NATURAL JOIN haravtale NATURAL JOIN varsel WHERE brukernavn = '"+this.bruker+"'");
		try {
			while (rs.next()){
				if (!(rs.getString(1).equals("alarm"))) {
					varsel.add("Endring i avtale" +rs.getString(2) + ": " + rs.getString(1) + " Endringen skjedde " + rs.getString(3)+" "+rs.getString(4).substring(0,2)+"."+rs.getString(4).substring(2,4)+"."+rs.getString(4).substring(4));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[] getVarsel(){
		String[] varselstring = new String[this.varsel.size()];
		
		return this.varsel.toArray(varselstring);
	}

	public void findAlarm() {
		ResultSet rs = db.readQuery("SELECT * FROM haravtale WHERE brukernavn = '"+this.bruker+"'");
		try {
			int count = 0;
			while (rs.next()){
				int varselid = rs.getInt(3);
				int avtaleid = rs.getInt(1);
				ResultSet rsvarsel = db.readQuery("SELECT * FROM varsel WHERE varselid = "+varselid);
				ResultSet rsavtale = db.readQuery("SELECT * FROM avtale WHERE avtaleid = "+avtaleid);
				rsvarsel.next();
				rsavtale.next();
				if (hasBeen(rsvarsel.getString(3), rsvarsel.getString(4)) && (rsvarsel.getString(2).equals("alarm"))){
					String dato = rsavtale.getString(2);
					String klokke = rsavtale.getString(3);
					alarm.add("ALARM: AvtaleID "+avtaleid+" starter klokken "+klokke.substring(0, 2) + ":" + klokke.substring(2) +" ved dato "+ dato.substring(0,2) + "." + dato.substring(2,4) + "." + dato.substring(4));
					if (hasBeen(rsvarsel.getString(3), rsvarsel.getString(4)) && rsavtale.getObject(6) == null){
						alarm.set(count, alarm.get(count)+ " i "+ rsavtale.getString(7) + "\n");
					} else {
						alarm.set(count, alarm.get(count)+ " i rom nr"+ rsavtale.getString(6)+ "\n");
					}
					count++;
				}
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean hasBeen(String tidspunkt, String dato) {
		DateTime tidno = new DateTime();
		int time = Integer.parseInt(tidspunkt.substring(0, 2));
		int minutt = Integer.parseInt(tidspunkt.substring(2, 4));
		int dag = Integer.parseInt(dato.substring(0, 2));
		int maaned = Integer.parseInt(dato.substring(2, 4));
		int aar = Integer.parseInt(dato.substring(4, 8));

		if (aar < (tidno.year().get())){
			return true;
		} else if (aar == (tidno.year().get())){
			if (maaned < tidno.monthOfYear().get()) {
				return true;
			} else if (maaned == tidno.monthOfYear().get()) {
				if (dag < tidno.dayOfMonth().get()) {
					return true;
				} else if (dag == tidno.dayOfMonth().get()){
					if (time < tidno.hourOfDay().get()) {
						return true;
					} else if (time == tidno.hourOfDay().get()) {
						if (minutt <= tidno.minuteOfHour().get()){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public String[] getAlarm(){
		String[] alarmstring = new String[this.alarm.size()];
		return this.alarm.toArray(alarmstring);
	}
}
