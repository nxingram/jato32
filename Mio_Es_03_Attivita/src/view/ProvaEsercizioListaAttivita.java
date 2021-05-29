package view;

import controller.ListaAttivita;
import model.Attivita;

public class ProvaEsercizioListaAttivita {

	public static void main(String[] args) {
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		Attivita t1 = new Attivita("Lavare il bagno",1,11,2021,0);
		System.out.println("Attivita' 1: " + t1);
		Attivita t2 = new Attivita("Preparare la traccia dell'esercizio 1",3,11,2021,2);
		System.out.println("Attivita' 2: " + t2);
		Attivita t3 = new Attivita("Prenotare il campo di calcetto",4,11,2021,3);
		System.out.println("Attivita' 3: " + t3);
		Attivita t4 = new Attivita("Restituire bici in ciclofficina",4,11,2021,2);
		System.out.println("Attivita' 4: " + t4);
		Attivita t5 = new Attivita("Ordinare camera",4,11,2021,-1);
		System.out.println("Attivita' 5: " + t5);
		Attivita t6 = new Attivita("Restituire libri in biblioteca",7,11,2021,2);
		System.out.println("Attivita' 6: " + t6);
		Attivita t7 = new Attivita("Completare iscrizione a concorso",2,1,2022,3);
		System.out.println("Attivita' 7: " + t7);
		Attivita t8 = new Attivita("Rammendare pantaloni",2,1,2022,1);
		System.out.println("Attivita' 8: " + t8);
		System.out.println("Descrizione Attivita' 1 (risposta attesa: 'Lavare il bagno') = '" + t1.getDescrizione() + "'");
		System.out.println(	"Scadenza Attivita' 1 (risposta attesa: '1-11-2021') ='"  + Integer.toString(t1.getGiorno()) + "-" + Integer.toString(t1.getMese()) + "-" + Integer.toString(t1.getAnno()) + "'" );
		System.out.println("Priorita' Attivita' 1 (risposta attesa: 0)= " + Integer.toString(t1.getPriorita()));
		System.out.println("Stringa Attivita' 1 (risposta attesa: '[1-11-2021 (pr. 0): Lavare il bagno]') = '" + t1 + "'");
		
		System.out.println("- - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - - ");
		System.out.println("Creo una lista con priorita' comprese tra1 e 3");	
		ListaAttivita lista = new ListaAttivita(1,3);
		System.out.println("Stringa Lista (risposta attesa: '') = '" +lista + "'");
		System.out.println("Aggiungi attività 3 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t3)));
		System.out.println("Stringa Lista (risposta attesa: '[4-11-2021 (pr. 3): Prenotare il campo di calcetto]') = '" + lista + "'");
		System.out.println("Aggiungi attività 2 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t2)));
		System.out.println("Aggiungi attività 1 (risposta attesa: false) = " + Boolean.toString(lista.aggiungiAttivita(t1)));
		System.out.println("Stringa Lista (risposta attesa: '[3-11-2021 (pr. 2): Preparare la traccia dell'esercizio 1],[4-11-2021 (pr. 3): Prenotare il campo di calcetto]') = '" + lista + "'");
		System.out.println("Carico per priorita' >= 2 (risposta attesa: 2) = " + Integer.toString(lista.carico(2)));
		System.out.println("Carico per priorita' >= 3 (risposta attesa: 1) = " + Integer.toString(lista.carico(3)));
		System.out.println("Carico per priorita' >= 4 (risposta attesa: 0) = " + Integer.toString(lista.carico(4)));
		System.out.println("Esegui attività (risposta attesa: '[3-11-2021 (pr. 2): Preparare la traccia dell'esercizio 1]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - ");
		System.out.println("Creo una lista con priorita' comprese tra 0 e 2");
		lista = new ListaAttivita(0,2);
		System.out.println("Aggiungi attività 4 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t4)));
		System.out.println("Aggiungi attività 5 (risposta attesa: false) = " + Boolean.toString(lista.aggiungiAttivita(t5)));
		System.out.println("Aggiungi attività 7 (risposta attesa: false) = " + Boolean.toString(lista.aggiungiAttivita(t7)));
		System.out.println("Esegui attività (risposta attesa: '[4-11-2021 (pr. 2): Restituire bici in ciclofficina]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Stringa Lista (risposta attesa: '') = '" +lista + "'");
		System.out.println("- - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - ");
		System.out.println("Creo una lista con priorita' comprese tra -1 e 3");
		lista = new ListaAttivita(-1,3);
		System.out.println("Aggiungi attività 4 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t4)));
		System.out.println("Aggiungi attività 6 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t6)));
		System.out.println("Aggiungi attività 5 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t5)));
		System.out.println("Aggiungi attività 7 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t7)));
		System.out.println("Aggiungi attività 3 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t3)));
		System.out.println("Aggiungi attività 2 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t2)));
		System.out.println("Aggiungi attività 1 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t1)));
		System.out.println("Aggiungi attività 8 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t8)));
		System.out.println("Esegui attività (risposta attesa: '[1-11-2021 (pr. 0): Lavare il bagno]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Aggiungi attività 1 (risposta attesa: true) = " + Boolean.toString(lista.aggiungiAttivita(t1)));
		System.out.println("Esegui attività (risposta attesa: '[1-11-2021 (pr. 0): Lavare il bagno]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[3-11-2021 (pr. 2): Preparare la traccia dell'esercizio 1]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[4-11-2021 (pr. 3): Prenotare il campo di calcetto]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[4-11-2021 (pr. 2): Restituire bici in ciclofficina]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[4-11-2021 (pr. -1): Ordinare camera]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[7-11-2021 (pr. 2): Restituire libri in biblioteca]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[2-1-2022 (pr. 3): Completare iscrizione a concorso]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[2-1-2022 (pr. 1): Rammendare pantaloni]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Stringa Lista (risposta attesa: '') = '" + lista + "'");


	
	
	}

}
