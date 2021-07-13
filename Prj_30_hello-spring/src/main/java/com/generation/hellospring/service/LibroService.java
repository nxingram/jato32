package com.generation.hellospring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.hellospring.model.Libro;


@Service
public class LibroService {

	@Autowired // uses component + bean
	private ArrayList<Libro> libri;	

//	/**
//	 * Constructor: 
//	 * libri is autowired without annotation @Autowired, 
//	 * does not need component + bean
//	 * @param libri
//	 */
//	public LibroService(ArrayList<Libro> libri) {
//		this.libri = libri;
//	}
	
	public List<Libro> getLibri(){
		this.loadMockLibri();
		return this.libri;
	}
	
	private void loadMockLibri() {
		if(libri.size()==0) {
			libri.add(new Libro("Io, robot", 123));
			libri.add(new Libro("Lei, robot", 321));			
		}
	}	

}
