package model;

import java.util.ArrayList;
import java.util.Random;

public class CorsoLaurea {
	private String nome;  
	private ArrayList<Studente> immatricolati;  
	public static int prossimaMatricola;  
	public static final int MIN_CREDITI = 80;
	
	public CorsoLaurea(String nome) {
		this.nome = nome;
		this.immatricolati = new ArrayList<Studente>();
		this.prossimaMatricola = 0;
	}

	public String getNome() {
		return nome;
	} 
	
	public void iscrivi(String nomeStudente){
		this.immatricolati.add(new Studente(nomeStudente, this.getMatricola()));
	} 
		
	private int getMatricola() {
		return this.prossimaMatricola++;
	}
	
	public void ritira(String nomeStudente){
		for (int i = 0; i < this.immatricolati.size(); i++) {
			if(this.immatricolati.get(i).getNome().equals(nomeStudente)) {
				this.immatricolati.remove(i);
				return;
			}
		}
	}
	
	public void appello(String nomeEsame, ArrayList<Studente> iscritti){
		Random r = new Random();
		int voto = r.nextInt(30);
		for (Studente studente : iscritti) {
			if(voto>=18)
				studente.promosso(nomeEsame, voto);
		}
	}  
	
	public void laurea() {
		
	}

	public ArrayList<Studente> getImmatricolati() {
		return immatricolati;
	}
	
	
	
}
