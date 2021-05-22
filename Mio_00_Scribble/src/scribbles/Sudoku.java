package scribbles;

import java.io.IOException;
import java.util.Scanner;

public class Sudoku{
	
	//Dimensione sudoku
	private static int DIM = 9;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int array[][] = new int [DIM][DIM];
		int locked[][] = new int [DIM][DIM];
		int sceltaDiff = 0;
		boolean terminato = false;
		boolean errore = false;
		
		System.out.println("\n\tSUDOKU - Java Edition\t\t\t\t\t\tDavide Piras");
		System.out.println("\n\tBENVENUTO!\n\tIl gioco si sviluppa in quattro diverse difficol�:\n\n\tFacile: i numeri presenti possono "
				+ "essere da 30 a 40, \n\tMedia: i numeri presenti possono essere da 20 a 30, \n\tDifficile: "
				+ "i numeri presenti possono essere da 10 a 20,\n\tPersonalizzata: l'utente sceglie il numero di valori gi� presenti."
				+ "\n\n\tSolo i numeri che ha inserito l'utente possono essere modificati, "
				+ "i restanti, \n\timpostati dal programma, sono bloccati: non possono essere modificati e vengono \n\tsegnalati con dei trattini."
				+ "\n\n\tOgni inserimento richiede preventivamente le \"coordinate\" della cella: \n\tLa lettera della riga e il numero della colonna,"
				+ " ciascuno seguito da invio. \n\n\tPer cancellare un numero, digitare le coordinate della cella ed inserire 0, "
				+ "\n\taltrimenti digitare un altro valore per sostituirlo.\n");
		System.out.println("\t1) Facile");
		System.out.println("\t2) Media");
		System.out.println("\t3) Difficile");
		System.out.println("\t4) Personalizzata");
		System.out.print("\n\tScegli la difficolt�: ");
		do{
			sceltaDiff = ((int)(Math.random()*10 + 1));
			errore = false;
			//TODO se l'utente inserisce un carattere il programma crasha
			int scelta = input.nextInt();
			switch(scelta) {
				case 1: sceltaDiff += 30; break;
				case 2: sceltaDiff += 20; break;
				case 3: sceltaDiff += 10; break;
				case 4: {
					System.out.print("\n\tQuanti valori preimpostati vuoi avere? ");
					sceltaDiff = input.nextInt();
					if(sceltaDiff < 0 || sceltaDiff > 81)
						errore = true;
					}; break;
				default: errore = true;
			}
			if(errore)
				System.out.print("\n\tAttenzione! scelta errata.\n\tScegli nuovamente la difficolt�: ");
		}while(errore);
		
		int difficolta = DIM * DIM - sceltaDiff;
		
		costruisciArray(array, locked);
		svuotaArray(array, difficolta);
		bloccaCelle(array, locked);
		
		while (!terminato) {//----------------------------------------------------Ciclo stampa ed inserimento 
			//clear();
			stampaTabella(array, locked);
			terminato = inputUtente(array, locked);
			if(terminato) {
				stampaTabella(array, locked);
				System.out.println();
				System.out.println("\t\t     HAI VINTO, COMPLIMENTI!");
			}
		}
	}
	
	private static void costruisciArray(int[][] array, int[][] locked) {
		boolean errore = false;
		int contaErrore1 = 0;
		int contaErrore2 = 0;
		for(int riga = 0; riga < DIM; riga++) {//---------------------------------Ciclo annidato di caricamento array
			for(int colonna = 0; colonna < DIM; colonna++) {
				array[riga][colonna] = ((int)(Math.random()*DIM + 1));//----------RANDOM
				errore = controlloArray(array, riga, colonna);
				if(errore==true) {//----------------------------------------------Controllo errore: nel caso di errore fa reinserire il valore della singola cella
					colonna--;
					contaErrore1++;
					contaErrore2++;
				}
				if(contaErrore2 > 1000) {//---------------------------------------Controllo anti-loop avanzato: se gli inserimenti di una riga danno errore 
					riga = ((int)(riga/3))*3;									//per piu di 1000 volte, azzero le tre celle 3x3 orizzontali in cui era bloccato l'inserimento 
					colonna = -1;
					for(int riga1 = riga; riga1 < riga + 3; riga1++)
						for(int colonna1 = 0; colonna1 < DIM; colonna1++)
							array[riga1][colonna1] = 0;
					contaErrore2 = 0;
				}
				if(contaErrore1 > 100) {//----------------------------------------Controllo anti-loop: se gli inserimenti in una riga danno errore 
					for(int colonna1=0; colonna1<DIM; colonna1++)				//per piu di 100 volte, azzero l'intera riga e ricomincio dalla prima cella
						array[riga][colonna1] = 0;
					colonna = -1;
					contaErrore1=0;
				}
				
				/*
				stampaTabella(array, locked);//-----------------------------------Visualizzazione per DEBUG 
				System.out.println(riga + " " + contaErrore1 + " " + contaErrore2);
				clear();*/
				
				
			}
			contaErrore1 = 0;//---------------------------------------------------Azzero i contatori di errore ogni nuova riga
			contaErrore2 = 0;
		}
	}

	private static boolean controlloArray(int[][] array, int riga, int colonna) {	
		
		if(array[riga][colonna] == 0)//-------------------------------------------Evita il controllo se la cella � vuota o viene svuotata
			return false;
		
		int contaErrore = 0;//----------------------------------------------------Ciclo di controllo riga dell'inserimento
			for(int colonna1 = 0; colonna1 < DIM; colonna1++) {
				if(array[riga][colonna]==array[riga][colonna1]) {
					contaErrore++;
					if(contaErrore == 2) {//--------------------------------------Controllo per evitare l'errore quando il valore inserito trova se stesso
						return true;
					}
			}
		}
		contaErrore = 0;//--------------------------------------------------------Ciclo di controllo colonna dell'inserimento
			for(int riga1 = 0; riga1 < DIM; riga1++) {
				if(array[riga][colonna]==array[riga1][colonna]) {
					contaErrore++;
					if(contaErrore == 2) {
						return true;
					}
				}
			}
		contaErrore = 0;//--------------------------------------------------------Ciclo annidato di controllo cella 3x3 dell'inserimento
		for(int riga2 =((int)(riga/3))*3; riga2 < ((int)(riga/3))*3 + 3; riga2++) {
			for(int colonna2 = ((int)(colonna/3))*3; colonna2 < ((int)(colonna/3))*3 + 3; colonna2++) {
				if(array[riga][colonna]==array[riga2][colonna2]) {
					contaErrore++;
					if(contaErrore == 2) {
						return true;
					}
				}
			}
		}
		return false;	
	}
	
	private static void svuotaArray(int[][] array, int difficolta) {
		for(int indice = 0; indice < difficolta; indice++) {
			int riga = ((int)(Math.random()*DIM + 1) - 1);//------------------------Generazione coordinate casuali
			int colonna = ((int)(Math.random()*DIM + 1) - 1);
			if(array[riga][colonna] == 0)//-----------------------------------------Controllo per evitare di svuotare una cella gi� vuota
				indice--;
			else array[riga][colonna] = 0;
		}
	}
	
	private static void bloccaCelle(int[][] array, int[][] locked) {
		for (int riga = 0; riga < DIM; riga++) 
			for (int colonna = 0; colonna < DIM; colonna++)
				locked[riga][colonna] = array[riga][colonna];		
	}

	private static boolean inputUtente(int[][] array, int[][] locked) {
		Scanner input = new Scanner(System.in);
		boolean erroreInput;
		boolean errore = false;
		boolean terminato = false;
		String spazio = "                     ";
		int colonna = 0;
		int riga = 0;
		int valore = 0;
		System.out.println();
		do {
			erroreInput = false;
			System.out.print("     COORDINATE:     ");
			do {
				if(erroreInput)
					System.out.print(spazio);
				erroreInput = false;
				System.out.print("Inserisci lettera della riga: ");
				char letteraRiga = input.next().charAt(0);
				letteraRiga = Character.toUpperCase(letteraRiga);
				riga = ((int)letteraRiga)-65;
				if(riga < 0 || riga >= DIM) {
					System.out.println(spazio + "> RIGA ERRATA------------------");
					erroreInput = true;
				}
			}while(erroreInput);//------------------------------------------------Ciclo di controllo lettera riga
			
			do {
				erroreInput = false;
				System.out.print(spazio + "Inserisci numero della colonna: ");
				//TODO se l'utente inserisce un carattere il programma crasha
				colonna = input.nextInt();
				if(colonna < 0 || colonna >= DIM) {
					System.out.println(spazio + "> COLONNA ERRATA---------------");
					erroreInput = true;
				}
			}while(erroreInput);//------------------------------------------------Ciclo di controllo numero colonna
			
			if(locked[riga][colonna] != 0) {//------------------------------------Controllo se la cella � modificabile
				System.out.println(spazio + "> NON PUOI MODIFICARE QUESTA CELLA");
				System.out.println(spazio + "-------------------------------");
				erroreInput = true;
			}
		}while(erroreInput);//----------------------------------------------------Ciclo di controllo coordinate
		do {
			do {
				erroreInput = false;
				System.out.print(spazio + "Inserisci valore cella (0 per svuotare): ");
				//TODO se l'utente inserisce un carattere il programma crasha
				valore = input.nextInt();
				if(valore < 0 || valore >= DIM) {
					System.out.println(spazio + "> INSERIMENTO ERRATO");
					erroreInput = true;
				}
			}while(erroreInput);//------------------------------------------------Ciclo di controllo inserimento compreso tra 0 e DIM
				
			array[riga][colonna] = valore;
			errore = controlloArray(array, riga, colonna);
			if(errore) {
				System.out.println(spazio + "> INSERIMENTO ERRATO, VALORE GIA' PRESENTE");
				erroreInput = true;
			}
		}while(erroreInput);//----------------------------------------------------Ciclo di controllo inserimento gi� presente
	terminato = controlloTerminato(array);
	return terminato;
	}

	private static boolean controlloTerminato(int[][] array) {
		for (int i = 0; i < DIM; i++)//-------------------------------------------Ciclo annidato di controllo: se l'array � completo ritorna vero
			for (int j = 0; j < DIM; j++) {
				if(array[i][j] == 0)
					return false;
			}
		return true;
	}

	private static void stampaTabella(int[][] array, int[][] locked) {
		for (int i = 0; i < 100; i++)//-------------------------------------------Tentativo di pulizia schermo
			System.out.println();
				
		System.out.println();//---------------------------------------------------Stampa numeri colonne 0->DIM
		System.out.print(" ");
		for (int colonna = 0; colonna < DIM; colonna++) {
			if(colonna % 3 == 0) 
				System.out.print(" ");
			System.out.print("     " + colonna);
		}
		System.out.println();
		
		for (int riga = 0; riga <= DIM; riga++) {//-------------------------------Ciclo di stampa caselle
			stampaLinea(riga);
			if(riga < DIM)
				stampaRiga(array, riga, locked);
		}
	}
	
	private static void stampaRiga(int[][] array, int riga, int[][] locked) {
		stampaRigaVuota(locked, riga);
		
		int lettera = 65 + riga;//------------------------------------------------Stampa lettere righe: utilizzo codice ascii per la stampa sequenziale (65 = A)
		System.out.print(" " + (char)lettera + " |");
		for(int colonna = 0; colonna <= DIM; colonna++) {
			
			
			if(colonna % 3 == 0)//------------------------------------------------Ogni 3 colonne stampa doppio separatore
				System.out.print("|");
			
			if(colonna < DIM) {
				System.out.print("  ");
				
				
				if(array[riga][colonna] != 0)//-----------------------------------Controllo input utente, se non effettuato o cancellato con 0 lasciare vuoto
					System.out.print(array[riga][colonna]);
				else
					System.out.print(" ");
				
				System.out.print("  |");
			}
		}
		stampaRigaVuota(locked, riga);
	}
	
	private static void stampaRigaVuota(int[][] locked, int riga) {
		System.out.println();
		System.out.print("   |");
		for(int indice = 0; indice <= DIM; indice++) {
			
			
			if(indice % 3 == 0)//-------------------------------------------------Ogni 3 colonne stampa doppio separatore
				System.out.print("|");
			
			if(indice < DIM) {
				System.out.print("  ");
				
				
				if(locked[riga][indice] != 0)//-----------------------------------Stampo dei trattini nelle celle bloccate
					System.out.print("-");
				
				else
					System.out.print(" ");
				System.out.print("  |");
			}
		}
		System.out.println();
	}

	private static void stampaLinea(int riga) {
		System.out.print("   ");//------------------------------------------------Stampa la linea di dimensioni adeguate in base a DIM
		for(int indice = 0; indice < ((DIM * 5) + (((DIM / 3) + 1) * 2) + ((DIM / 3) * 2)); indice++) 
			System.out.print("-");
		
		
		if(riga % 3 == 0) {//-----------------------------------------------------Ogni 3 righe stampa la doppia linea
			System.out.println();
			System.out.print("   ");
			for(int indice1 = 0; indice1 < ((DIM * 5) + (((DIM / 3) + 1) * 2) + ((DIM / 3) * 2)); indice1++)
				System.out.print("-");
		}	
	}
	
	/*
	public static void clear(){//------------------------------------------------CLS
	    try {
	    	 if (System.getProperty("os.name").contains("Windows"))
	    		 	new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
	    	 else
	             Runtime.getRuntime().exec("clear");
	    } catch (InterruptedException e) {
	    	e.printStackTrace();
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	  }*/
}



