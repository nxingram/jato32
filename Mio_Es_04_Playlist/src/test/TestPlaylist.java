package test;

import controller.Playlist;
import model.ClipVideo;

public class TestPlaylist {

	public static void main(String[] args) {

		Playlist pl = new Playlist(15, 45);
		
		ClipVideo cv1 = new ClipVideo("video1", 3, 15);
		ClipVideo cv2 = new ClipVideo("video2", 4, 25);
		ClipVideo cv3 = new ClipVideo("video4", 35, 45);
		
		System.out.println("aggiunto (true): " + pl.aggiungiVideo(cv1));
		System.out.println("aggiunto (true): " + pl.aggiungiVideo(cv2));
		
		// deve restituire false, troppo lungo
		System.out.println("aggiunto lungo (false): " + pl.aggiungiVideo(cv3));
		
		// 2 vid, quello lungo non ci sta
		System.out.println("nClipVid (2): " + pl.numeroClipVideo());

		// titolo duplicato, deve rest false
		System.out.println("duplicati (false): " + pl.verificaDuplicati());
		
		// aggiungo video con titolo duplicato, rest true
		ClipVideo cv4 = new ClipVideo("video1", 2, 45);
		System.out.println("aggiunto duplicato (true): " + pl.aggiungiVideo(cv4));
		
		// titolo duplicato, deve rest true
		System.out.println("duplicati (true): " + pl.verificaDuplicati());
	}

}
