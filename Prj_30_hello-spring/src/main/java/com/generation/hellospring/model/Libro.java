package com.generation.hellospring.model;

import org.springframework.stereotype.Component;

public class Libro {

	public String Titolo;
	public int pagine;
	
	public Libro() {}
	public Libro(String titolo, int pagine) {
		super();
		Titolo = titolo;
		this.pagine = pagine;
	}
	public String getTitolo() {
		return Titolo;
	}
	public void setTitolo(String titolo) {
		Titolo = titolo;
	}
	public int getPagine() {
		return pagine;
	}
	public void setPagine(int pagine) {
		this.pagine = pagine;
	}
	
	
	
	
}
