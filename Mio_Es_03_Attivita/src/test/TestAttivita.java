package test;

import model.Attivita;

public class TestAttivita {

	public static void main(String[] args) {

		Attivita a1 = new Attivita("attivita1", 15, 3, 2020, 3); 
		Attivita a2 = new Attivita("attivita2", 5, 5, 2021, 1);
		
		// deve restituire true
		System.out.println("Attivita' precedente (true): " + a1.primaDi(a2));
		
		// stesso giorno di a1, la priorità di a3 è maggiore di a1, rest false
		Attivita a3 = new Attivita("attivita3", 15, 3, 2020, 1); 
		System.out.println("Attivita' precedente (false): " + a1.primaDi(a3));
		
	}

}
