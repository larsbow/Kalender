package logikk;

import gui.HentAvtaleGUI;

public class AvtaleOversikt {
	HentAvtaler hentAvt1;
	HentAvtaler hentAvt2;
	
	private String dato;
	private String bruker;
	public boolean user;
	public boolean kollega;
	
	
	public AvtaleOversikt(String bruker, String dato) {
		this.dato = dato;
		this.bruker = bruker;
		user = brukerHarAvtale();
		kollega = kollegaHarAvtale();
		
	}
	
	public boolean brukerHarAvtale() {
		hentAvt1 = new HentAvtaler(bruker, dato);
				
		if (hentAvt1.getAvtaleBruker().length == 0)
			return false;
		else 
			return true;
	}
	
	public boolean kollegaHarAvtale() {
		hentAvt2 = new HentAvtaler(bruker, dato);
				
		if (hentAvt2.getAvtaleKollega().length == 0)
			return false;
		else 
			return true;
	}

}
