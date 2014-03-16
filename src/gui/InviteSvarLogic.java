package gui;

import java.sql.ResultSet;
import java.sql.SQLException;

import database.Database;

public class InviteSvarLogic {

	Database db;
	String bruker;
	int avtaleid;
	
	public InviteSvarLogic(String bruker, String avtaleid, Database db){
		this.db = db;
		this.bruker = bruker;
		this.avtaleid = Integer.parseInt(avtaleid);
	}
	
	public String getDeltakere(String d){
		String[] deltakere = d.split(", ");
		String dms = "";
		int n = 1;
		for (String deltaker : deltakere){
			ResultSet rs = db.readQuery("SELECT kommer, brukernavn, avtaleid FROM erinviterttil WHERE brukernavn = '"+deltaker+"' "
					+ "AND avtaleid = "+this.avtaleid);
			try {
				rs.next();
				if (rs.getBoolean(1)){
					dms = dms + deltaker + "(kommer), ";
				} else if (!rs.getBoolean(1)){
					dms = dms + deltaker + "(kommer ikke), ";
				} else {
					dms = dms + deltaker + "(ikke svart), ";
				}
				if (dms.length() > 70*n) {
					dms = dms + "\n";
					n++;
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dms;
	}
}
