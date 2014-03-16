package logikk;

import gui.HentAvtaleGUI;

public class AvtaleOversikt {

	private String dato;
	private String bruker;
	HentAvtaler hentAvt = new HentAvtaler(bruker, dato);
	public boolean user;
	public boolean kollega;
	
	
	public AvtaleOversikt(String bruker, String dato) {
		this.dato = dato;
		this.bruker = bruker;
		user = brukerHarAvtale();
		kollega = kollegaHarAvtale();
		
	}
	
	public boolean brukerHarAvtale() {
		return (hentAvt.getAvtaleBruker().length == 0);
	}
	
	public boolean kollegaHarAvtale() {
		return (hentAvt.getAvtaleKollega().length == 0);

	}

}
