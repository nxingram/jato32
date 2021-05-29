package test;

import model.ClipVideo;

public class ClipVideoTest {

	public static void main(String[] args) {

		ClipVideo clipVideo = new ClipVideo("titolo clip", 3, 45);
		
		System.out.println(clipVideo);
		System.out.println(clipVideo.getTitolo());
		System.out.println(clipVideo.getMinuti());
		System.out.println(clipVideo.getSecondi());
		
		
	}

}
