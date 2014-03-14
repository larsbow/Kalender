package logikk;

import java.awt.Component;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import database.Database;

public class EndreAvtaleLogic {

	Database db = new Database();

	public boolean endreAvtale(int avtaleid, String dato, String start,
			String slutt, String beskrivelse, Object romid, String sted,
			String ansatt, String[] deltakere){

		try {
			ResultSet rs = db.readQuery("SELECT opprettetav FROM avtale WHERE avtaleid =" + avtaleid);
			rs.next();
			String bruker = rs.getString(1);

			if(bruker.equals(ansatt)){ 

				db.updateQuery("UPDATE avtale "
						+ "SET dato = '" + dato + "', starttid = '" + start + "', sluttid = '" 
						+ slutt + "', beskrivelse = '" + beskrivelse + "', romid = " + romid + ", sted = '" + sted + "'"
						+ " WHERE avtaleid =" + avtaleid );
				db.updateQuery("DELETE FROM erinviterttil WHERE avtaleid = "+avtaleid);
				for (int i= 0; i < deltakere.length; i++){
					db.updateQuery("INSERT INTO erinviterttil VALUES ("+avtaleid+", '"+deltakere[i]+"', null, true)");
				}
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
				Component frame = null;
				JOptionPane.showMessageDialog(frame,"Avtale slettet!","Suksess",JOptionPane.INFORMATION_MESSAGE);
			} else {
				Component frame = null;
			JOptionPane.showMessageDialog(frame,"Avtale ikke slettet! Avtalen ble opprettet av noen andre.","Feil",JOptionPane.WARNING_MESSAGE);
			}
		}catch (Exception e) {
			Component frame = null;
			JOptionPane.showMessageDialog(frame,"Avtale ikke slettet! Feil avtaleid.","Feil",JOptionPane.WARNING_MESSAGE);
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

	public String[] getAvtaler(String bruker) {
		ResultSet rs = db.readQuery("SELECT * FROM avtale WHERE opprettetav = '"+bruker+"'");
		ArrayList<String> tempd = new ArrayList<String>();
		try {
			while (rs.next()){
				String ID = Integer.toString(rs.getInt(1));
				while (ID.length()<4){
					ID = "0"+ID;
				} 
				tempd.add("ID:"+ID+" dato:"+rs.getString(2)+" tid:"+rs.getString(3)+" beskrivelse: '"+rs.getString(5)+"'\n");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		String[] avtaler = new String[tempd.size()];
		return tempd.toArray(avtaler);
	}

	public ArrayList<String> getInfo(String id) {
		ResultSet rs = db.readQuery("SELECT * FROM avtale NATURAL JOIN erinviterttil WHERE avtaleid = "+id);
		ArrayList<String> info = new ArrayList<String>();
		try {
			rs.next();
			for (int i = 2; i<8; i++){
				if (i==6){
					if (rs.getObject(i) == null){
						info.add(null);
					} else {
						info.add(Integer.toString(rs.getInt(i)));
					}
				} else {
					info.add(rs.getString(i));
				}
			}
			info.add(rs.getString(9));
			while (rs.next()){
				info.set(6, info.get(6)+", "+rs.getString(9));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return info;
	}



}
