package model;

public class ClipVideo {

	private String titolo;
	private int minuti; 
	private int secondi; 
	
	// Costruttore
	public ClipVideo(String titolo, int minuti, int secondi) {
		this.titolo = titolo;
		this.minuti = minuti;
		this.secondi = secondi;
	}

	// Getters
	public String getTitolo() {
		return titolo;
	}

	public int getMinuti() {
		return minuti;
	}

	public int getSecondi() {
		return secondi;
	}

	// toString
	@Override
	public String toString() {
		return "ClipVideo [titolo=" + titolo + ", minuti=" + minuti + ", secondi=" + secondi + "]";
	}






	
	
	
	
}
