package model;

public class Attivita {

	private String descrizione;
	private int giorno;
	private int mese;
	private int anno;
	private int priorita;
	
	// Costruttore
	public Attivita(String descrizione, int giorno, int mese, int anno, int priorita) {
		super();
		this.descrizione = descrizione;
		this.giorno = giorno;
		this.mese = mese;
		this.anno = anno;
		this.priorita = priorita;
	}

	// Getters
	public String getDescrizione() {
		return descrizione;
	}

	public int getGiorno() {
		return giorno;
	}

	public int getMese() {
		return mese;
	}

	public int getAnno() {
		return anno;
	}

	public int getPriorita() {
		return priorita;
	}
	// end Getters
	
	public boolean primaDi(Attivita a) {
		if(this.anno<a.anno) {
			return true;
		}else if(this.anno==a.anno && this.mese<a.mese) {
			return true;			
		}else if(this.anno==a.anno && this.mese==a.mese && this.giorno<a.giorno) {
			return true;
		}else if(this.anno==a.anno && this.mese==a.mese && this.giorno==a.giorno && this.priorita>a.priorita) {
			return true;
		}
		
		return false;
	}

	// toString
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		sb.append(this.giorno+"-"+this.mese+"-"+this.anno+" ");
		sb.append("(pr. "+this.priorita+"): ");
		sb.append(this.descrizione);
		sb.append("]");		
		
		return sb.toString();
	}
	
	
	
	
	
	
	
}
