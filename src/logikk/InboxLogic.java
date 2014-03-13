package logikk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
				if (!(rs.getString(1).equals("alarm"))) {
					varsel.add("Endring i avtale" +rs.getString(2) + ": " + rs.getString(1) + " skjedde " + Integer.toString(rs.getInt(3))+" "+Integer.toString(rs.getInt(4)));

				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<String> getVarsel(){
		return this.varsel;
	}

	public void findAlarm(){
		ResultSet rs = db.readQuery("SELECT avtale.avtaleid, avtale.starttid, avtale.dato, sted, romid, haravtale.brukernavn, varsel.dato, varsel.tidspunkt, varsel.beskjed FROM haravtale, varsel, avtale WHERE haravtale.brukernavn = '"+this.bruker+"' AND haravtale.avtaleid = avtale.avtaleid");
		try {
			int count = 0;
			while (rs.next()){
				if (hasBeen(rs.getString(8), rs.getString(7)) && rs.getString(9).equals("alarm")){
					alarm.add("ALARM: AvtaleID "+ rs.getString(1) + " starter klokken "+Integer.toString(rs.getInt(2))+" ved (DDMMYY) "+Integer.toString(rs.getInt(3))+" ");
					if (rs.getObject(5) == null){
						alarm.set(count, alarm.get(count)+" i "+rs.getString(4)+"\n");
					} else {
						alarm.set(count,  alarm.get(count)+"i rom nr "+rs.getInt(5) + "\n");
					}
				}
				count++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private boolean hasBeen(String tidspunkt, String dato) {
		Date tidno = new Date();
		int time = Integer.parseInt(tidspunkt.substring(0, 2));
		int minutt = Integer.parseInt(tidspunkt.substring(2, 4));
		int dag = Integer.parseInt(dato.substring(0, 2));
		int maaned = Integer.parseInt(dato.substring(2, 4));
		int aar = Integer.parseInt(dato.substring(4, 8));

		if (aar < (tidno.getYear()+1990)){
			return true;
		} else if (aar == (tidno.getYear() + 1990)){
			if (maaned < tidno.getMonth()) {
				return true;
			} else if (maaned == tidno.getMonth()) {
				if (dag < tidno.getDate()) {
					return true;
				} else if (dag == tidno.getDate()){
					if (time < tidno.getHours()) {
						return true;
					} else if (time == tidno.getHours()) {
						if (minutt <= tidno.getMinutes()){
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	public ArrayList<String> getAlarm(){
		return this.alarm;
	}
}
