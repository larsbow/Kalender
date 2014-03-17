package gui;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

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

	public void synlig(boolean b, int id) {
		if (b){
			db.updateQuery("UPDATE erinviterttil SET synlig = true WHERE avtaleid = "+id+" AND brukernavn = '"+this.bruker+"'");
		} else {
			ResultSet rs = db.readQuery("SELECT kommer FROM erinviterttil WHERE brukernavn = '"+this.bruker+"' "
					+ "AND avtaleid = "+id);
			try {
				rs.next();
				if(!rs.getBoolean(1)){
					db.updateQuery("UPDATE erinviterttil SET synlig = false WHERE avtaleid = "+id+" AND brukernavn = '"+this.bruker+"'");
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"Avtalen er nå skjult.","Success",JOptionPane.INFORMATION_MESSAGE);
				} else {
					Component frame = null;
					JOptionPane.showMessageDialog(frame,"Kunne ikke skjule avtale., \n Du må avslå avtalen for å skjule den.","Feil",JOptionPane.INFORMATION_MESSAGE);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void kommer(boolean b, int id) {
		if (b) {
			db.updateQuery("UPDATE erinviterttil SET kommer = true WHERE avtaleid = "+id+" AND brukernavn = '"+this.bruker+"'");
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Du har nå svart ja på invitasjonen.","Svar",JOptionPane.INFORMATION_MESSAGE);
		} else {
			db.updateQuery("UPDATE erinviterttil SET kommer = false WHERE avtaleid = "+id+" AND brukernavn = '"+this.bruker+"'");
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Du har nå svart nei på invitasjonen","Svar",JOptionPane.INFORMATION_MESSAGE);
		}
	}
}
