package logikk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.Database;

public class HentAvtaler {
	

	private String bruker;
	private String dato;

	private ArrayList<String> brukerAvtaler = new ArrayList<String>();
	private ArrayList<String> kolleagaAvtaler = new ArrayList<String>();

	Database db;
	Database db2;

		
	public HentAvtaler(String bruker, String dato){
		db = new Database();
		db2 = new Database();
		this.bruker = bruker;
		this.dato = dato;
		AvtalerKollega(bruker, dato);
		AvtalerBruker(bruker, dato);
	}
	
	public void AvtalerKollega(String bruker, String dato){
		this.bruker = bruker;
		System.out.println("kollega dato: " + dato);
		ResultSet rs = db.readQuery("SELECT distinct beskrivelse, starttid, sted, erinviterttil.brukernavn FROM avtale natural join erinviterttil WHERE erinviterttil.brukernavn != '"+this.bruker+"' and dato = '" + dato + "'" );
		try {
			while (rs.next()){
				kolleagaAvtaler.add("Avtaler for: " +rs.getString(4) + "    Tid: " + rs.getString(2) + "     Sted: " + rs.getString(3) + "    Beskrivelse: " + rs.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[] getAvtaleKollega(){
		String[] avtaleString = new String[this.kolleagaAvtaler.size()];
		
		return this.kolleagaAvtaler.toArray(avtaleString);
	}
	
	public void AvtalerBruker(String bruker, String dato){ // find funksjonen
		this.bruker = bruker;
		System.out.println("bruker dato" + dato);
		
		ResultSet rs2 = db2.readQuery("SELECT distinct beskrivelse, starttid, sted, erinviterttil.brukernavn FROM avtale natural join erinviterttil WHERE erinviterttil.brukernavn = '"+this.bruker+"' and dato = '" + dato + "'" );
		try {
			while (rs2.next()){
					brukerAvtaler.add("Avtaler for:  " +rs2.getString(4) + "    Tid: " + rs2.getString(2) + "   Sted: " + rs2.getString(3) + "   Beskrivelse: " + rs2.getString(1));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public String[] getAvtaleBruker(){
		String[] avtaleString = new String[this.brukerAvtaler.size()];
		
		return this.brukerAvtaler.toArray(avtaleString);
	}

	

}
