package view;

import controller.Playlist;
import model.ClipVideo;

public class ProvaEsercizioPlaylist {

	public static String descriviClipVideo(ClipVideo c) {
		return "VIDEO " + c.getTitolo() + " (" + c.getMinuti() + ":" + c.getSecondi() + ")";
	}

	public static void stampaPlaylist(Playlist p) {
		if (p.numeroClipVideo() == 0)
			System.out.println("Lista vuota!");
		for (int i = 0; i < p.numeroClipVideo(); i++) {
			System.out.println(descriviClipVideo(p.getVideo(i)));
		}
	}

	public static void main(String[] args) {
		Playlist pl1 = new Playlist(20, 0);
		stampaPlaylist(pl1);
		ClipVideo c1 = new ClipVideo("titolo_video_1", 5, 40);
		ClipVideo c2 = new ClipVideo("titolo_video_2", 4, 30);
		ClipVideo c3 = new ClipVideo("titolo_video_3", 7, 20);
		ClipVideo c4 = new ClipVideo("titolo_video_4", 7, 40);
		ClipVideo c5 = new ClipVideo("titolo_video_5", 3, 40);
		System.out.println(descriviClipVideo(c1));
		System.out.println(descriviClipVideo(c2));
		System.out.println(descriviClipVideo(c3));
		System.out.println(descriviClipVideo(c4));
		System.out.println(descriviClipVideo(c5));
		System.out.println("Aggiungo video 1... " + (pl1.aggiungiVideo(c1) ? "OK" : "Non posso, troppo lungo..."));
		System.out.println("Aggiungo video 2... " + (pl1.aggiungiVideo(c2) ? "OK" : "Non posso, troppo lungo..."));
		System.out.println("Aggiungo video 3... " + (pl1.aggiungiVideo(c3) ? "OK" : "Non posso, troppo lungo..."));
		System.out.println("Aggiungo video 4... " + (pl1.aggiungiVideo(c4) ? "OK" : "Non posso, troppo lungo..."));
		stampaPlaylist(pl1);
		System.out.println("Lunghezza in secondi della playlist (1050): " + pl1.calcolaLunghezzaSecondi());
		System.out.println("Numero di clip nella playlist (3): " + pl1.numeroClipVideo());
		System.out.println("Contiene duplicati (false): " + pl1.verificaDuplicati());
		Playlist pl2 = new Playlist(30, 0);
		System.out.println("Aggiungo video 1... " + (pl2.aggiungiVideo(c1) ? "OK" : "Non posso, troppo lungo..."));
		System.out.println("Aggiungo video 5... " + (pl2.aggiungiVideo(c5) ? "OK" : "Non posso, troppo lungo..."));
		System.out.println(
				"Aggiungo (nuovamente) video 1... " + (pl2.aggiungiVideo(c1) ? "OK" : "Non posso, troppo lungo..."));
		System.out.println("Lunghezza in secondi della playlist (900): " + pl2.calcolaLunghezzaSecondi());
		System.out.println("Numero di clip nella playlist (3): " + pl2.numeroClipVideo());
		System.out.println("Contiene duplicati (true): " + pl2.verificaDuplicati());

	}
}