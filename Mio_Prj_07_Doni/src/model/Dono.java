package model;

public class Dono {

	// propriet� oggetto:
	// 1-tipo
	// 2-nome propriet�
	// 3-visibilit�
	private String nomeRegalo;
	private double prezzo;

	// costruttori
	public Dono() {

	}

	public Dono(String nomeRegalo) {
		this.nomeRegalo = nomeRegalo;
	}

	public Dono(String nomeRegalo, double prezzo) {
//		super();
		this.nomeRegalo = nomeRegalo;
		this.prezzo = prezzo;
	}

// metodi
//	// GETTER E SETTER 
	public String getNomeRegalo() {
		return nomeRegalo;
	}

	public void setNomeRegalo(String nomeRegalo) {
		this.nomeRegalo = nomeRegalo;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
		return "Dono [nomeRegalo=" + nomeRegalo + ", prezzo=" + prezzo + "]";
//		return "nome regalo "+ this.nomeRegalo;
	}

}
