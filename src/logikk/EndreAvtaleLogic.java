package logikk;

import java.awt.Component;

import javax.swing.JOptionPane;

import database.Database;

public class EndreAvtaleLogic {
	
	Database db = new Database();

	public boolean endreAvtale(int avtaleid, String dato, String start,
			String slutt, String beskrivelse, Object romid, String sted,
			String ansatt) {
		try {
			db.updateQuery("UPDATE avtale "
						 + "SET dato = '" + dato + "', starttid = '" + start + "', sluttid = '" 
						 + slutt + "', beskrivelse = '" + beskrivelse + "', romid = " + romid + ", sted = '" + sted + "'"
						 + "WHERE avtaleid =" + avtaleid);
		} catch (Exception e) {
			return false;
		}
		return true;
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
