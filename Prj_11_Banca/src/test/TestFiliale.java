package test;

import controller.Filiale;
import model.Cliente;
import model.ContoCorrente;

public class TestFiliale {

	public static void main(String[] args) {
		
		// test creazione filiale
		Filiale filiale = new Filiale("Test filiale");
		
		// test creazione cliente
		Cliente c1 = filiale.addCliente("test cliente 1");		
		
		// test apriconto
		ContoCorrente contoCorrente = filiale.apriConto();
		
		// test collega cliente		
		filiale.collegaContoCliente(c1, contoCorrente);
		
		// etc...
	}
}
