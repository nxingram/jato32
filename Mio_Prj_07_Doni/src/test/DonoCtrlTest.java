package test;

import controller.DonoCtrl;
import model.Dono;

public class DonoCtrlTest {

	public static void main(String[] args) {

		DonoCtrl dc1 = new DonoCtrl();// inizializzato
		
		DonoCtrl dc2 = new DonoCtrl(new Dono[10]);// inizializzato
		
		DonoCtrl dc3 = new DonoCtrl(new Dono[20]);// inizializzato

		System.out.println("dc1: "+ dc1.getListaDoni().length);
		System.out.println("dc2: "+ dc2.getListaDoni().length);
		System.out.println("dc3: "+ dc3.getListaDoni().length);
		
		
		dc1.aggiungiDono(new Dono("tagliacarte", 100));
		dc1.stampaContenuto();
		
	}

}
