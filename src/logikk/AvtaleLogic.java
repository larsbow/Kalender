package logikk;

import java.awt.Component;

import javax.swing.JOptionPane;

import database.Database;

public class AvtaleLogic {

	Database db = new Database();

	public boolean lagAvtale(String dato, String start, String slutt, String beskrivelse, Object romid, String sted, String ansatt) {
		try {
			db.updateQuery("INSERT INTO avtale VALUES (null, '" + dato + "','" + start + "','" + slutt + "','" + beskrivelse + "'," + romid + ",'" + sted + "','" + ansatt + "')");
			int varseltid = Integer.parseInt(start) -100;
			String varselstring = Integer.toString(varseltid);
			while (varselstring.length() < 4){
				varselstring = "0" + varselstring;
			}
			db.updateQuery("INSERT INTO varsel VALUES (null, 'alarm', '"+varselstring+"', '"+dato+"')");
		} catch (Exception e) {
			return false;
		}
		return true;		
	}

	public void printAvtale(boolean success) {
		if (success) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Avtale opprettet!","Suksess",JOptionPane.INFORMATION_MESSAGE);
		}
		else {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Avtale ikke opprettet!","Feil",JOptionPane.WARNING_MESSAGE);
		}
	}
}
