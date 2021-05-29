package test;

import model.ClipVideo;
import model.Playlist;

public class TestPlaylist {

	public static void main(String[] args) {

		Playlist pl = new Playlist(15, 45);
		
		ClipVideo cv1 = new ClipVideo("video1", 3, 15);
		ClipVideo cv2 = new ClipVideo("video2", 4, 25);
		ClipVideo cv3 = new ClipVideo("video4", 35, 45);
		
		System.out.println("aggiunto: " + pl.aggiungiVideo(cv1));
		System.out.println("aggiunto: " + pl.aggiungiVideo(cv2));
		
		// deve restituire false, troppo lungo
		System.out.println("aggiunto lungo: " + pl.aggiungiVideo(cv3));
		
		// 2 vid, quello lungo non ci sta
		System.out.println("nClipVid: " + pl.numeroClipVideo());

		// titolo duplicato, deve rest false
		System.out.println("duplicati: " + pl.verificaDuplicati());
		
		// aggiungo video con titolo duplicato, rest true
		ClipVideo cv4 = new ClipVideo("video1", 2, 45);
		System.out.println("aggiunto duplicato: " + pl.aggiungiVideo(cv4));
		
		// titolo duplicato, deve rest true
		System.out.println("duplicati: " + pl.verificaDuplicati());
	}

}
