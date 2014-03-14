package logikk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;

public class HentAvtaler {
	

	private String bruker;
	private String dato;
	private ArrayList<String> avtaler = new ArrayList<String>();
	Database db2;
	Database db3;

		
	public HentAvtaler(String bruker, String dato){
		this.bruker = bruker;
		this.dato = dato;
	}
	
	public void AvtalerKollega(String bruker, String dato){
		this.bruker = bruker;
		db2 = new Database();
		
		ResultSet rs = db2.readQuery("SELECT beskrivelse, starttid, sted, erinviterttil.brukernavn FROM avtale, erinviterttil WHERE erinviterttil.brukernavn != '"+this.bruker+"' and dato = '" + dato + "'" );
		try {
			while (rs.next()){
					avtaler.add("Avtaler for" +rs.getString(4) + ": Tid: " + rs.getString(2) + " Sted: " + rs.getString(3) + " Beskrivelse: " + rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[] getAvtaleKollega(){
		String[] avtaleString = new String[this.avtaler.size()];
		
		return this.avtaler.toArray(avtaleString);
	}
	
	public void AvtalerBruker(String bruker, String dato){
		this.bruker = bruker;
		db3 = new Database();
		
		ResultSet rs = db3.readQuery("SELECT beskrivelse, starttid, sted, erinviterttil.brukernavn FROM avtale, erinviterttil WHERE erinviterttil.brukernavn = '"+this.bruker+"' and dato = '" + dato + "'" );
		try {
			while (rs.next()){
					avtaler.add("Avtaler for" +rs.getString(4) + ": Tid: " + rs.getString(2) + " Sted: " + rs.getString(3) + " Beskrivelse: " + rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[] getAvtaleBruker(){
		String[] avtaleString = new String[this.avtaler.size()];
		
		return this.avtaler.toArray(avtaleString);
	}

	

}
