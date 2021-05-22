package test;

import model.Dono;

public class DonoTest {

	public static void main(String[] args) {

		// creo un dono vuoto
		//new Dono(); // istanza di 1 dono
		new Dono();// costruttore vuoto
		
		new Dono("bici");//costruttore con 1 parametro
		
		new Dono("piatti", 3.5);
		
		
		Dono dono2 = new Dono("scolapasta", 10.75);
		
		
		System.out.println(dono2.getNomeRegalo());
		System.out.println(dono2.getPrezzo());
		
		dono2.setNomeRegalo("pelapatate");
		dono2.setPrezzo(5.1);
		
		System.out.println(dono2.getNomeRegalo());
		System.out.println(dono2.getPrezzo());
		
		System.out.println(dono2);
		System.out.println(dono2.toString());
		
		
//		// cambiamo nome e prezzo
//		dono2.setNomeRegalo("pelapatate");
//		dono2.setPrezzo(1.9);
//		
//		// stampiamo nome e prezzo
//		String nomeDono2 = dono2.getNomeRegalo();
//		System.out.println(nomeDono2);
//		
//		System.out.println(dono2.getPrezzo());
//		
//		System.out.println(dono2);
		
		
		
		
		
		
		
		
		
		
		
		
		
		// variabile:
		// tipo
		// nome variabile
		// inizializzazione
		int numeroInt = 20;
		
		// variabile Dono
//		Dono dono1 = new Dono();
		
		// asseegnare un nome al dono 
		// dono1 istanza della classe dono
		
		// assegno valore alla proprietà dell'oggeto dono1
//		dono1.nomeRegalo = "posate";
		
		// leggo la proprietà di dono1 e lo assegno 
		// ad una varibile
//		String mioRegaloDiNozze = dono1.nomeRegalo;
		
//		System.out.println(dono1.nomeRegalo);
		
	}

}
