package test;

import model.Movimento;

public class TestMovimento {

	public static void main(String[] args) {
		
		// test creazione movimento
		Movimento movimento = new Movimento("descrizione movimento test", 100);
		
		// test stampa movimento
		System.out.println(movimento.toString());
	}
}
