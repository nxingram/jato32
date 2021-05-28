package test;

import java.util.ArrayList;

import model.ContoCorrente;
import model.Movimento;

public class TestContoCorrente {

	public static void main(String[] args) {

		// test creazione conto corrente
		ContoCorrente cc = new ContoCorrente();
		
		// test aggiungi movimento
		double versamento = 200.0;
		cc.versamento(versamento);
		
		double prelievo = 50.0;		
		cc.prelievo(prelievo);
		
		
		// test stampa movimnti
		ArrayList<Movimento> movimenti = cc.getMovimenti();
		for (Movimento movimento : movimenti) {
			System.out.println(movimento);
		}
		
		//  test stampa saldo
		System.out.println(cc.getSaldo());
		
		
	}

}
