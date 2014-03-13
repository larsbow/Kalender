package logikk;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Database;

public class AvtaleLogic {

	Database db = new Database();

	public boolean lagAvtale(String dato, String start, String slutt, String beskrivelse, Object romid, String sted, String ansatt) {
		if (dato.length() != 8 || start.length() != 4){
			return false;
		}
		try {
			db.updateQuery("INSERT INTO avtale VALUES (null, '" + dato + "','" + start + "','" + slutt + "','" + beskrivelse + "'," + romid + ",'" + sted + "','" + ansatt + "')");
			int varseltid = Integer.parseInt(start) +1990;
			String varselstring = Integer.toString(varseltid);
			while (varselstring.length() < 4){
				varselstring = "0" + varselstring;
			}
			db.updateQuery("INSERT INTO varsel VALUES (null, 'alarm', '"+varselstring+"', '"+dato+"')");
			
			ResultSet rs = db.readQuery("SELECT avtaleid FROM avtale ORDER BY avtaleid DESC");
			rs.next();
			int avtaleid = rs.getInt(1);
			ResultSet rs2 = db.readQuery("SELECT varselid FROM varsel ORDER BY varselid DESC");
			rs2.next();
			int varselid = rs2.getInt(1);
			System.out.println(varselid+" og "+avtaleid+" og "+ansatt);		
			System.out.println("INSERT INTO haravtale VALUES ("+avtaleid+", '"+ansatt+"', "+varselid+")");

			db.updateQuery("INSERT INTO haravtale VALUES ("+avtaleid+", '"+ansatt+"', "+varselid+")");
		} catch (Exception e) {
			return false;
		}
		return true;		
	}
	
	public String[] getAnsatte() {
		try {
			ResultSet rs = db.readQuery("SELECT brukernavn FROM ansatt");
			ArrayList<String> ar = new ArrayList<String>();
			int counter = 0;
			
			while (rs.next()) {
				
				counter++;
				ar.add(rs.getString(1));
			}

			String[] stockArr = new String[ar.size()];
			stockArr = ar.toArray(stockArr);
			
			return stockArr;
			
		} catch (SQLException e) {
			return null;
		}
		
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
