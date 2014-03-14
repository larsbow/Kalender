package gui;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;

public class RomLogikk {

	Database db = new Database();

	public String[] finnLedige(String dato, String starttid, String sluttid, int deltakere) {
		try {
			ResultSet rs1 = db.readQuery("SELECT starttid, sluttid, romid, kapasitet FROM avtale NATURAL JOIN rom WHERE dato = '" + dato + "'");
			ResultSet rs2 = db.readQuery("SELECT romid, kapasitet FROM rom");
			ArrayList<String> ledige = new ArrayList<String>();
			ArrayList<String> kap = new ArrayList<String>();

			while (rs2.next()) {
				ledige.add(rs2.getString(1));
				kap.add(rs2.getString(2));
			}
			
			System.out.println(kap.get(0));
			System.out.println(kap.get(1));
			System.out.println(kap.get(2));
			
			for(int j = 0; j < ledige.size(); j++) {
				if(deltakere > Integer.parseInt(kap.get(j))) {
					ledige.set(j, "feil");
					kap.set(j, "feil");
				}
			}
			
			ledige.remove("feil");
			kap.remove("feil");
 
			while (rs1.next()) {
				System.out.println(Integer.parseInt(rs1.getString(4)));
				if ((Integer.parseInt(sluttid) > Integer.parseInt(rs1.getString(1))) && (Integer.parseInt(starttid) < Integer.parseInt(rs1.getString(2)))) {
					ledige.remove("" + rs1.getInt(3));
					kap.remove("" + rs1.getInt(4));
				}
			}		

			String[] ledigerom= new String[ledige.size()];

			for(int i = 0; i < ledigerom.length; i++) {
				ledigerom[i] = "Rom " + ledige.get(i) + ", kapasitet " + kap.get(i);
			}

			return ledigerom;

		} catch (SQLException e) {

		}
		return null;
	}

}
