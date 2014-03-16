package logikk;

import gui.HentAvtaleGUI;

public class AvtaleOversikt {

	private String dato;
	private String bruker;
	HentAvtaler hentAvt;
	public boolean user;
	public boolean kollega;
	
	
	public AvtaleOversikt(String bruker, String dato) {
		this.dato = dato;
		this.bruker = bruker;
		user = brukerHarAvtale();
		kollega = kollegaHarAvtale();
		
	}
	
	public boolean brukerHarAvtale() {
		hentAvt = new HentAvtaler(bruker, dato);
		return (hentAvt.getAvtaleBruker().length != 0);
	}
	
	public boolean kollegaHarAvtale() {
		hentAvt = new HentAvtaler(bruker, dato);
		return (hentAvt.getAvtaleKollega().length != 0);

	}

}
