package logikk;

import database.Database;

public class EndreAvtaleLogic {
	
	Database db = new Database();

	public boolean endreAvtale(int avtaleid, String dato, String start,
			String slutt, String beskrivelse, Object romid, String sted,
			String ansatt) {
		try {
			db.updateQuery("UPDATE avtale "
						 + "SET dato = '" + dato + "', starttid = '" + start + "', sluttid = '" 
						 + beskrivelse + "', romid = " + romid + ", sted = '" + sted + "'"
						 + "WHERE avtaleid =" + avtaleid);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public void printAvtale(boolean success) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
