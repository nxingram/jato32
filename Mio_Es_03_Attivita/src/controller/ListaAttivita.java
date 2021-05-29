package controller;

import java.util.ArrayList;
import model.Attivita;

/**
 * @author Home
 *
 */
public class ListaAttivita {

	private ArrayList<Attivita> listaAttivita;
	private int minPriorita;
	private int maxPriorita;

	// Costruttore
	public ListaAttivita(int minPriorita, int maxPriorita) {
		this.minPriorita = minPriorita;
		this.maxPriorita = maxPriorita;
		this.listaAttivita = new ArrayList<Attivita>();
	}

	public boolean aggiungiAttivita(Attivita a) {
		// programmazione difensiva
		// se priorità è fuori dai limiti, esco subito dl metodo, restituitsco false
		if (a.getPriorita() < this.minPriorita || a.getPriorita() > this.maxPriorita) {
			return false;
		}

		return this.listaAttivita.add(a); // add restituisce true
	}

	public int carico(int priorita) {
		int contatore = 0;
		for (Attivita attivita : listaAttivita) {
			if (attivita.getPriorita() >= priorita) {
				contatore++;
			}
		}
		return contatore;
	}

	public Attivita eseguiAttivita() {
		this.ordinaLista();
		Attivita attivitaEseguita = this.listaAttivita.get(0);
		this.listaAttivita.remove(0);
		return attivitaEseguita;
	}
	
	@Override
	public String toString() {
		this.ordinaLista();
		StringBuilder sb = new StringBuilder();
//		sb.append("Lista Attivita': ");
		for (Attivita attivita : this.listaAttivita) {
			sb.append(attivita).append(", ");
		}
		return sb.toString();
	}

	private void ordinaLista() {

		boolean continua = true;
		while (continua) {
			continua = false;
			for (int i = 1; i < this.listaAttivita.size(); i++) {

				Attivita corrente = this.listaAttivita.get(i);
				Attivita successiva = this.listaAttivita.get(i - 1);

				// per come lavora primaDi, 
				// inverto il risultato "!" per avere l'ordine cronologico
				if (!successiva.primaDi(corrente)) {
					// scambio posizione
					this.listaAttivita.set(i-1, corrente);
					this.listaAttivita.set(i, successiva);
					continua = true;
				}
			} 
		}
	}

}
