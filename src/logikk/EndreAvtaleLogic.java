package logikk;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import database.Database;

public class EndreAvtaleLogic {

	Database db = new Database();

	public boolean endreAvtale(int avtaleid, String dato, String start,
			String slutt, String beskrivelse, Object romid, String sted,
			String ansatt){

		try {
			ResultSet rs = db.readQuery("SELECT opprettetav FROM avtale WHERE avtaleid =" + avtaleid);
			rs.next();
			String bruker = rs.getString(1);

			if(bruker.equals(ansatt)){ 

				db.updateQuery("UPDATE avtale "
						+ "SET dato = '" + dato + "', starttid = '" + start + "', sluttid = '" 
						+ slutt + "', beskrivelse = '" + beskrivelse + "', romid = " + romid + ", sted = '" + sted + "'"
						+ " WHERE avtaleid =" + avtaleid ); 
				return true;
			}	
		} catch (Exception e) {
			return false;
		}
		return false;
	}

	public void slettAvtale(int avtaleid, String bruker) {
		try {
			ResultSet rs = db.readQuery("SELECT opprettetav FROM avtale WHERE avtaleid =" + avtaleid);
			rs.next();
			String bruker2 = rs.getString(1);

			if(bruker2.equals(bruker)){ 
				db.updateQuery("DELETE FROM avtale WHERE avtaleid = " + avtaleid);
			} 
		}catch (Exception e) {

		}
	}

	public void printAvtale(boolean success) {
		if (success) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Avtale endret!","Suksess",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Avtale ikke endret!","Feil",JOptionPane.WARNING_MESSAGE);
		}
	}



}
