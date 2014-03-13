package logikk;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.JOptionPane;

import database.Database;

public class AvtaleLogic {

	Database db = new Database();

	public boolean lagAvtale(String dato, String start, String slutt, String beskrivelse, Object romid, String sted, String[] deltakere, String ansatt) {
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
			
			for(int i = 0; i < deltakere.length; i++) {
				db.updateQuery("INSERT INTO erinviterttil VALUES ("+avtaleid+", '" + deltakere[i] + "', null, true)");
			}
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

			String[] sa = new String[ar.size()];
			return ar.toArray(sa);

		} catch (SQLException e) {
			return null;
		}

	}
	
	public String[] extractDeltakere (String deltakere) {
		String[] ansatte = deltakere.split(", ");
		return ansatte;
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
	
	private String bruker;
	private ArrayList<String> avtaler = new ArrayList<String>();
	Database db2;


	public void getAvtaler(String bruker, String dato){
		this.bruker = bruker;
		db2 = new Database();
		
		ResultSet rs = db2.readQuery("SELECT beskrivelse, starttid, sted, erinviterttil.brukernavn FROM avtale, haravtale WHERE erinviterttil.brukernavn = '"+this.bruker+"' and dato = '" + dato + "'" );
		try {
			while (rs.next()){
					avtaler.add("Avtaler for" +rs.getString(4) + ": Tid: " + rs.getString(2) + " Sted: " + rs.getString(3) + " Beskrivelse: " + rs.getString(1) + " skjedde ");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[] getVarsel(){
		String[] avtalestring = new String[this.avtaler.size()];
		
		return this.avtaler.toArray(avtalestring);
	}
}
