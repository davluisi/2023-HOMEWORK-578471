package it.uniroma3.diadia.giocatore;

/**
 * Questa classe gestisce i dati del giocatore
 * 
 * @author docente di POO
 * @see Borsa
 * @version base
 */

public class Giocatore {
	
	static final private int CFU_INIZIALI = 20;
	private int cfu;
	private Borsa borsa;
	
	public Giocatore() {
		this.cfu = CFU_INIZIALI;
		this.borsa = new Borsa();
	}

	public Borsa getBorsa() {
		return this.borsa;
	}

	
	public void setCfu(int cfu) {
		this.cfu = cfu;
	}

	public int getCfu() {
		return this.cfu;
	}
	
}
