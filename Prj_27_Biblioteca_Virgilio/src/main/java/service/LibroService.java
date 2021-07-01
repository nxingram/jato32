package service;

import java.util.Set;
import java.util.TreeSet;

import dal.LibroDAOImpl;
import entities.Libro;

public class LibroService {

	private LibroDAOImpl libroDaoImpl;
	
	public LibroService() {
		libroDaoImpl = new LibroDAOImpl();
	}

	public Set<String> getTitoli() {
		Set<String> titoli = new TreeSet<String>();
		for (Libro l : libroDaoImpl.getAll()) {
			titoli.add(l.getTitolo());
		}
		return titoli;
	}

}
