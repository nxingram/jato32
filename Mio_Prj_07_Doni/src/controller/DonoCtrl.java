package controller;

import model.Dono;

public class DonoCtrl {//listaNozze oppure sacco dei doni + elfo

	
	private Dono[] listaDoni;// contenitore dei doni
	
	

	// costruttore senza parametr0
	public DonoCtrl() {
		// inizializzo il contenitore di questo oggetto
		this.listaDoni = new Dono[30]; // inizializzazione fissa o default
	}
	
	// costruttore con parametro
	public DonoCtrl(Dono[] listaDoni) {
	//	super();

		// inizializzo il contenitore di questo oggetto
		// ma la dimensione me la passano da fuori
		this.listaDoni = listaDoni; // inizializz variabile
	}

	
	// GETTER
	public Dono[] getListaDoni() {
		return listaDoni;
	}
	
	
	
	
	// aggiungi dono
	public void aggiungiDono(Dono dono) {
//		this.listaDoni += dono;
//		this.listaDoni[i] = dono;
		int i = posizioneLibera();
		if(i>=0)
			this.listaDoni[i] = dono;
		
	}
	
	private int posizioneLibera() {
		for (int i = 0; i < listaDoni.length; i++) {
			if(listaDoni[i] == null)
				return i;			
		}
		
		
		return -1; // array è pieno, sacco è pieno
		
	}
	
	
	
	public void stampaContenuto() {
		//uso il foreach
		for (Dono dono : listaDoni) {
			if (dono != null)
			System.out.println(dono);
		}
		
//		for (int i = 0; i < listaDoni.length; i++) {
//			Dono dono = listaDoni[i];
//			if (dono != null)
//				System.out.println(dono);
//		}
	}
	
	
	public double valoreDoni() {
		// variabile
		double totale = 0;
		
		for (Dono dono : listaDoni) {
			if (dono != null)
				totale = totale + dono.getPrezzo();
//				totale += dono.getPrezzo();
		}
		
		return totale;
	}
	
	
	
	
	
	
	
	
	
}
