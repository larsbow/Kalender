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
		
		
		System.out.println("printer getavtalebruker" + hentAvt1.getAvtaleBruker());
		if (hentAvt1.getAvtaleBruker() == null)
			return false;
		else 
			return true;
	}
	
	public boolean kollegaHarAvtale() {
		hentAvt2 = new HentAvtaler(bruker, dato);
		
		
		System.out.println("printer getavtalekollega" + hentAvt2.getAvtaleBruker());
		if (hentAvt2.getAvtaleKollega() == null)
			return false;
		else 
			return true;
	}

}
