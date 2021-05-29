package model;

import java.util.ArrayList;

public class Playlist {

	private int minuti;
	private int secondi;
	private ArrayList<ClipVideo> listaVideo;

	// Costruttore
	public Playlist(int minuti, int secondi) {
		this.minuti = minuti;
		this.secondi = secondi;
		this.listaVideo = new ArrayList<ClipVideo>();
	}
	
	public int numeroClipVideo() {
		return this.listaVideo.size();
		}
	
	public ClipVideo getVideo(int indice) {
		return this.listaVideo.get(indice);
	}
	
	// durata playlist: somma della durata dei video
	public int calcolaLunghezzaSecondi() {
		int tot=0;
		for (ClipVideo cv : listaVideo) {
			tot += (cv.getMinuti()*60) + cv.getSecondi(); 
		}
		return tot;
	}
	
	// durata max playlist
	private int calcolaLunghezzaMaxSecondi(){
		return (this.minuti*60) + this.secondi;		
	}
	
	public boolean aggiungiVideo(ClipVideo cv) {
		int durataCv = (cv.getMinuti()*60) + cv.getSecondi();
		int durataTot = this.calcolaLunghezzaSecondi();
		int durataMax = this.calcolaLunghezzaMaxSecondi();
		
		// se non ci sta nella lista, restituisco false ed esco dal metodo
		if((durataTot + durataCv) > durataMax ) {
			return false;			
		}
		
		// ci sta nella lista, lo aggiungo
		this.listaVideo.add(cv);
		return true;		
	}
	
	public boolean verificaDuplicati() {
		
		for (int i = 0; i < listaVideo.size(); i++) {
			for (int j = 0; j < listaVideo.size(); j++) {
				// salto se sto confrontando lo stesso video
				if(i==j) {
					continue;
				}
				// se ho 2 titoli uguali, restituisco true, ed esco dal metodo
				if(listaVideo.get(i).getTitolo().equals(listaVideo.get(j).getTitolo())){
					return true;					
				}
			}
		}
		
		return false;
	}
	
	
}
