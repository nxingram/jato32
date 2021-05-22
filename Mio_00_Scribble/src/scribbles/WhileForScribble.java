package scribbles;



public class WhileForScribble {

	public static void main(String[] args) {

		// -----------------------------------
		System.out.println("- ciclo WHILE, stampa da 0 a 9");
		int i = 0;
		while (i < 10) {
			System.out.println(i);
			i++;
		}

		delimiter();

		// -----------------------------------
		System.out.println("- ciclo DO-WHILE, stampa da 0 a 9");
		int j = 0;
		do {
			System.out.println(j);
			j++;
		} while (j < 10);

		delimiter();

		// -----------------------------------
		System.out.println("- ciclo FOR, stampa da 0 a 9");

		for (int k = 0; k < 10; k++) {
			System.out.println(k);
		}

		delimiter();
		// -----------------------------------

		System.out.println("- ciclo FOR, stampa Array da 'zero' a 'nove'");
		// Array di tipo Stringa
		String[] arrayStringhe = { "zero", "uno", "due", "tre", "quattro", "cinque", "sei", "sette", "otto", "nove" };
		
		// contatore m va da 0 a lunghezzaArray
		int lunghezzaArray = arrayStringhe.length;
		for (int m = 0; m < lunghezzaArray; m++) {
			String valorecorrente = arrayStringhe[m];
			System.out.println("(m=" + m + ") => "+ valorecorrente);
		}
		
		delimiter();

		// -----------------------------------

		System.out.println("- ciclo FOREACH, stampa Array da 'zero' a 'nove'");
		// contatore? lunghezza? => fa tutto da solo
		for (String valoreCorrente2 : arrayStringhe) {
			System.out.println(valoreCorrente2);
		}
		
		
	}
	


	private static void delimiter() {
		System.out.println();
		System.out.println("===================================");
		System.out.println();
	}

}
