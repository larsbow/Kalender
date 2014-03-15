package logikk;

import database.Database;

public class DBconnect {
	
	Database db;
	
	public DBconnect() {
		if (!db.getConnection().isValid(10)) {
			db = new Database();
		}
	}
}
