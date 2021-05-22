package scribbles;

import java.io.IOException;

public class ClearConsoleTest {

	public static void main(String[] args) {

		for (int i = 0; i < 100; i++) {
//		System.out.println(System.lineSeparator().repeat(50));
			Cls();
			System.out.println(i);

		}
	}

public static void Cls()
{
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
}
}
