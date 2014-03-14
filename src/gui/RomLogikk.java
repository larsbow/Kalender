package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;

public class RomLogikk {

	Database db = new Database();
	
	public Integer[] finnLedige(String dato, String starttid, String sluttid) {
		try {
			ResultSet rs = db.readQuery("SELECT starttid, sluttid, romid FROM avtale WHERE dato = '" + dato + "'");
			ArrayList<Integer> ledige = new ArrayList<Integer>();
			while (rs.next()) {
				if (Integer.parseInt(sluttid) < Integer.parseInt(rs.getString(1))) {
					ledige.add(rs.getInt(3));
				}
			}
			Integer[] ledigerom= new Integer[ledige.size()];
			return ledige.toArray(ledigerom);
		
		} catch (SQLException e) {
			
		}
		return null;
	}

}
