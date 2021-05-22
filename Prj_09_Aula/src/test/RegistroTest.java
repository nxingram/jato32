package test;

import database.DBStudenti;
import model.Studente;

public class RegistroTest {

	public static void main(String[] args) {
		Studente[] arrayStudenti = DBStudenti.studenti;
		stampaArrayStudenti(arrayStudenti, "" + 0);

		ordinaIncompleto(arrayStudenti);		
//		ordinaMio(arrayStudenti);		
//
//		ordinaMioVerboso(arrayStudenti);
//		ordinaMioVerboso(arrayStudenti);		
//		ordinaMioVerboso(arrayStudenti);		
//
//		// automatizzato con ciclo while e continua
//		boolean continua = true;
//		while (continua) {
//			continua = ordinaMioVerboso(arrayStudenti);
//			System.out.println("continua=" + continua + "\n"+"======================="+"\n");
//		}

	}

	public static void ordinaIncompleto(Studente[] studenti) {

		boolean guardia = false;

		for (int i = 0; i < studenti.length; i++) {

			if (i < studenti.length - 1) {
				Studente corrente = studenti[i];
				Studente successivo = studenti[i + 1];

				int test = corrente.getCognome().compareTo(successivo.getCognome());

				if (test > 0) {
					System.out.println("devi fare un altro giro");
					Studente temp = corrente;
					studenti[i] = successivo;
					studenti[i + 1] = temp;
				}

			}
		}
		stampaArrayStudenti(studenti, "?");
	}

	public static boolean ordinaMio(Studente[] studenti) {

		int numeroScambi = 0;

		// da 0 a ?
		int nCicliFor = studenti.length;

		// posso bloccarlo prima manualmente
		//nCicli = 4;	

		for (int i = 0; i < nCicliFor; i++) {

			if (i < nCicliFor - 1) { // altrimenti finisce oltre la fine dell'array alla riga "successivo"

				Studente corrente = studenti[i];
				Studente successivo = studenti[i + 1];

				int test = corrente.getCognome().compareTo(successivo.getCognome());

				if (test > 0) {
					System.out.println("     scambio la posiz degli studenti");
					Studente temp = corrente;
					studenti[i] = successivo;
					studenti[i + 1] = temp;
					numeroScambi++;
				}
			}
		}

		if (numeroScambi > 0) {
			stampaArrayStudenti(studenti, "" + numeroScambi);
			return true;
		} else {
			// tutti gli studenti sono ordinati
			stampaArrayStudenti(studenti, "" + numeroScambi);
			return false;
		}

	}

	public static boolean ordinaMioVerboso(Studente[] studenti) {

		int numeroScambi = 0;

		// da 0 a ?
		int nCicliFor = studenti.length;

		// lo blocco prima
//		nCicli = 4;	

		System.out.println("nCicliFor=" + nCicliFor + "   (lunghezza dell'array)");

		for (int i = 0; i < nCicliFor; i++) {

			System.out.println("\n" + "i=" + i);

			System.out.println("if(" + i + "<" + (nCicliFor - 1) + ")");
			if (i < nCicliFor - 1) { // altrimenti finisce oltre la fine dell'array alla riga "successivo"

				Studente corrente = studenti[i];
				Studente successivo = studenti[i + 1];

				System.out.println("  (i=" + i + ") => corrrente=" + corrente.getCognome());
				System.out.println("  (i+1=" + (i + 1) + ") => successivo=" + successivo.getCognome());

				int test = corrente.getCognome().compareTo(successivo.getCognome());
				System.out.println("  test=" + test);

				System.out.println("  if(" + test + ">0)");
				if (test > 0) {
					System.out.println("     scambio la posiz degli studenti");
					Studente temp = corrente;
					studenti[i] = successivo;
					studenti[i + 1] = temp;
					numeroScambi++;
				} else

					System.out.println();

			}
		}

		System.out.println("  terminato ciclo for");

		if (numeroScambi > 0) {
			stampaArrayStudenti(studenti, "" + numeroScambi);
			return true;
		} else {
			// tutti gli studenti sono ordinati
			stampaArrayStudenti(studenti, "" + numeroScambi);
			return false;
		}

	}

	private static void stampaArrayStudenti(Studente[] studenti, String numeroScambi) {
		System.out.println("\n" + "========STAMPA=========" + "\n");
		System.out.println("numeroScambi=" + numeroScambi + "\n");

		for (int i = 0; i < studenti.length; i++) {

			System.out.println(i + ")" + studenti[i].getCognome());
		}
		System.out.println("\n" + "=======================" + "\n");
	}

}
