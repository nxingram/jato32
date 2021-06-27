package controller;

import model.CorsoLaurea;
import model.Studente;

public class CorsoLaureaCtrl {

	private CorsoLaurea corsoLaurea;

	public CorsoLaureaCtrl(String nomeCorsoLaurea) {
		this.corsoLaurea = new CorsoLaurea(nomeCorsoLaurea);
	}
		
	public void aggiungiStudente(String nomeStudente) {
		this.corsoLaurea.iscrivi(nomeStudente);
		this.corsoLaurea.getImmatricolati();
		for (Studente studente : this.corsoLaurea.getImmatricolati()) {
			
		}
	}
	
	public void aggiungiEsame(String nomeStudente) {
		
	}
}
