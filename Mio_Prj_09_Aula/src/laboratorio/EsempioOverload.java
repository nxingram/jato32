package laboratorio;

public class EsempioOverload {

	static int a = 25;
	static int b = 29;
	static int[] voti = {a,b, b, a, 23, 45, 56, 2, 9, 45, 56, 2, 9};
	static int[] ordinato = new int[voti.length];

	public static void main(String[] args) {
		

		//ordina(a, b);
		for (int i=0 ; i < voti.length; i++) {
			ordinato[i]=voti[i]; // copiato l'array voti nell'array ordinato
		}
		
		// ordina voti e ordina restituisce true o false
		while(ordina(voti)) {
			System.out.println("riprovo");
		}
		
//		System.out.println("originali");
//		for (int voto : voti) {
//			System.out.print(voto);
//		}
//		System.out.println("ordinati");

		for (int i = 0; i < ordinato.length; i++) {
			System.out.println(ordinato[i]);
		}

	}
	
	// OVERLOAD DEL METODO: + versioni, cambiano i parametri
	//0 , 1 //length = 2; 
	private static boolean ordina(int[] voti) {//a,b, b, a, 23, 45, 56, 2, 9
		boolean risposta = false;
		boolean guardia = false;
		int temp = 0;
		for (int i = 0; i < voti.length; i++) {
			//qui devo verificare di trovarmi prima dell'ultimo elemento
			
			if (i < voti.length - 1) {
				risposta = ordina(ordinato[i], ordinato[i+1]);				
				if(risposta==true) {
					temp = ordinato[i];
					ordinato[i] = ordinato[i+1];
					ordinato[i+1] = temp;
					guardia = true;
				}
			}
			
		}
		return guardia;
	}

	private static boolean ordina(int a, int b) {	
		if (a <= b) {
			System.out.println("I numeri " + a + " e " + b);
			System.out.println("sono già ordinati");
			return false;
		} else { // a > b
			System.out.println("I numeri " + a + " e " + b);
			System.out.println("NON sono ordinati");
			return true;
		}		
	}

	
	
	
}
