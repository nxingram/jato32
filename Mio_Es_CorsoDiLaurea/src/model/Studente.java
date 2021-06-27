package model;

import java.util.ArrayList;

public class Studente {
	private String nome;
	private int matricola;
	private ArrayList<Esame> pianoStudio;
	private ArrayList<Esame> esamiSostenuti;

	public Studente(String nome, int matricola) {
		this.nome = nome;
		this.matricola = matricola;
		this.pianoStudio = new ArrayList<Esame>();
		this.esamiSostenuti = new ArrayList<Esame>();
	}

	public String getNome() {
		return nome;
	}

	public int getMatricola() {
		return matricola;
	}

	public void aggiungiEsame(String nomeEsame, int crediti) {
		this.pianoStudio.add(new Esame(nomeEsame, crediti));
	}

	public void promosso(String nomeEsame, int voto) {
		Esame e = null;
		for (Esame esame : esamiSostenuti) {
			if (esame.getNome().equals(nomeEsame))
				e = esame;
		}
		e.setVoto(voto);
		this.esamiSostenuti.add(e);
	}

	public void cancella(String nomeEsame) {
		for (int i = 0; i < this.pianoStudio.size(); i++) {
			if (this.pianoStudio.get(i).getNome().equals(nomeEsame)) {
				this.pianoStudio.remove(i);
				return;
			}
		}
	}

	public double media() {
		double tot = 0.0;
		for (Esame esame : this.esamiSostenuti) {
			tot += esame.getVoto();
		}

		return tot / this.esamiSostenuti.size();
	}

	public double crediti() {
		double totCrediti = 0.0;
		for (Esame esame : this.pianoStudio) {
			totCrediti += esame.getCrediti();
		}
		return totCrediti;
	}

	@Override
	public String toString() {
		return "Studente [nome=" + nome + ", matricola=" + matricola + ", pianoStudio=" + pianoStudio
				+ ", esamiSostenuti=" + esamiSostenuti + "]";
	}
	

}
