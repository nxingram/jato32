package test;

import java.util.ArrayList;

import controller.ListaAttivita;
import model.Attivita;

public class TestListaAttivita {

	public static void main(String[] args) {

		Attivita a2 = new Attivita("attivita2", 15, 3, 2020, 3); 
		Attivita a3 = new Attivita("attivita3", 15, 3, 2020, 1); 
		Attivita a1 = new Attivita("attivita1", 5, 5, 2021, 1);
		
		ListaAttivita la = new ListaAttivita(1, 5);
		la.aggiungiAttivita(a1);
		la.aggiungiAttivita(a2);
		la.aggiungiAttivita(a3);
		
		
		System.out.println(la);
		
		testCheFalliscono(); // eseguo parte del codice di prova per dabuggare il mio codice
		

	}

	private static void testCheFalliscono() {
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
		System.out.println("- - - - - - - - - - - - - - - - - - - - -- - - - - - - - - - - - - - - ");
		System.out.println("Creo una lista con priorita' comprese tra -1 e 3");
		ListaAttivita lista = new ListaAttivita(-1,3);
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
		System.out.println(lista);
		System.out.println("Esegui attività (risposta attesa: '[4-11-2021 (pr. 3): Prenotare il campo di calcetto]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[4-11-2021 (pr. 2): Restituire bici in ciclofficina]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[4-11-2021 (pr. -1): Ordinare camera]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[7-11-2021 (pr. 2): Restituire libri in biblioteca]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[2-1-2022 (pr. 3): Completare iscrizione a concorso]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Esegui attività (risposta attesa: '[2-1-2022 (pr. 1): Rammendare pantaloni]') = '"+ lista.eseguiAttivita() + "'");
		System.out.println("Stringa Lista (risposta attesa: '') = '" + lista + "'");		
	}

}
