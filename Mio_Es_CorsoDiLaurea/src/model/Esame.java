package model;

public class Esame {
	private String nome;
	private int crediti;
	private int voto;

	public Esame(String nome, int crediti) {
		this.nome = nome;
		this.crediti = crediti;
	}

	public String getNome() {
		return nome;
	}

	public int getCrediti() {
		return crediti;
	}

	public int getVoto() {
		return voto;
	}

	public void setVoto(int voto) {
		this.voto = voto;
	}

	@Override
	public String toString() {
		return "Esame [nome=" + nome + ", crediti=" + crediti + ", voto=" + voto + "]";
	}

}
