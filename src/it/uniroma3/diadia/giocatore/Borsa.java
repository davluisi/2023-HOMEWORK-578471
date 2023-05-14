package it.uniroma3.diadia.giocatore;

import java.util.*;

import it.uniroma3.diadia.attrezzi.*;


/**
 * Ha il compito di conservare gli attrezzi del giocatore
 * 
 * @author docente di POO
 * @version base
 */

public class Borsa {
	public final static int DEFAULT_PESO_MAX_BORSA = 10;
	private Map<String, Attrezzo> attrezzi;
	private int numeroAttrezzi;
	private int pesoMax;
	public Borsa() {
		this(DEFAULT_PESO_MAX_BORSA);
	}
	
	public Borsa(int pesoMax) {
		this.pesoMax = pesoMax;
		this.attrezzi = new HashMap<String, Attrezzo>();
		this.numeroAttrezzi = 0;
	}
	
	/**
	 * Aggiunge un attrezzo alla borsa, se questa può contenerne altri
	 * 
	 * @param attrezzo
	 * @return se l'attrezzo è stato aggiunto alla borsa
	 */
	public boolean addAttrezzo(Attrezzo attrezzo) {
		if (this.getPeso() + attrezzo.getPeso() > this.getPesoMax() && !(this.hasAttrezzo(attrezzo.getNome())))
			return false;
		this.attrezzi.put(attrezzo.getNome(), attrezzo);
		this.numeroAttrezzi++;
		return true;
	}
	
	public int getPesoMax() {
		return pesoMax;
	}
	
	public Attrezzo getAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.get(nomeAttrezzo);
	}
	
	public Map<String, Attrezzo> getAttrezzi() {
		return this.attrezzi;
	}
	
	public int getPeso() {
		int peso = 0;
		for (String nomeAttrezzo : attrezzi.keySet())
			peso += attrezzi.get(nomeAttrezzo).getPeso();
		return peso;
	}
	
	/**
	 * Verifica il contenuto della borsa
	 * 
	 * @return se la borsa è vuota
	 */
	public boolean isEmpty() {
		return this.numeroAttrezzi == 0;
	}
	
	/**
	 * Cerca un attrezzo nella borsa
	 * 
	 * @param nomeAttrezzo
	 * @return se l'attrezzo c'è
	 */
	public boolean hasAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.containsKey(nomeAttrezzo);
	}
	
	/**
	 * Rimuove un attrezzo dalla borsa
	 * 
	 * @param nomeAttrezzo
	 * @return l'attrezzo rimosso
	 */
	public Attrezzo removeAttrezzo(String nomeAttrezzo) {
		return this.attrezzi.remove(nomeAttrezzo);
		
	}
	
	/**
	 * Restituisce la lista degli attrezzi nella borsa ordinati per peso 
	 * quindi, a parità di peso, per nome
	 * @return attrezzi ordinati per peso
	 */
	public List<Attrezzo> getContenutoOrdinatoPerPeso(){
		List<Attrezzo> listaOrdinata = new ArrayList<Attrezzo>();
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		for(String nomeAttrezzo : this.attrezzi.keySet()) {
			listaOrdinata.add(this.attrezzi.get(nomeAttrezzo));
		}
		Collections.sort(listaOrdinata, cmp);
		return listaOrdinata;
	}
	
	/**
	 * restituisce l'insieme gli attrezzi nella borsa
	 * ordinati per peso e quindi, a parità di peso, per nome
	 * @return l'insieme di attrezzi ordinato per peso
	 */
	public SortedSet<Attrezzo> getSortedSetOrdinatoPerPeso(){
		ComparatoreAttrezziPerPeso cmp = new ComparatoreAttrezziPerPeso();
		SortedSet<Attrezzo> insiemeOrdinato = new TreeSet<Attrezzo>(cmp);
		for(String nomeAttrezzo : this.attrezzi.keySet()) {
			insiemeOrdinato.add(this.attrezzi.get(nomeAttrezzo));
		}
		return insiemeOrdinato;
	}
	
	/**
	 * restituisce l'insieme degli attrezzi nella borsa ordinati per nome
	 * @return attrezzi ordinati per nome
	 */
	public SortedSet<Attrezzo> getContenutoOrdinatoPerNome(){
		SortedSet<Attrezzo> insiemeOrdinato = new TreeSet<Attrezzo>();
		for(String nomeAttrezzo : this.attrezzi.keySet()) {
			insiemeOrdinato.add(this.attrezzi.get(nomeAttrezzo));
		}
		return insiemeOrdinato;
	}
	
	/**
	 * restituisce una mappa che associa un intero (rappresentante un
	 * peso) con l’insieme (comunque non vuoto) degli attrezzi di tale
	 * peso: tutti gli attrezzi dell'insieme che figura come valore hanno
	 * lo stesso peso pari all'intero che figura come chiave
	 * @return
	 */
	public Map<Integer, Set<Attrezzo>> getContenutoRaggruppatoPerPeso(){
		Map<Integer, Set<Attrezzo>> mappa = new HashMap<Integer, Set<Attrezzo>>();
		Set<Attrezzo> tmp;
		List<Attrezzo> lista = new ArrayList<Attrezzo>();
		for(Attrezzo attrezzo : this.attrezzi.values())
			lista.add(attrezzo);
		for(Attrezzo attrezzo : lista) {
			tmp = mappa.get(attrezzo.getPeso());
			if(tmp==null)
				tmp = new HashSet<Attrezzo>();
			tmp.add(attrezzo);
			mappa.put(attrezzo.getPeso(), tmp);
		}
		return mappa;
	}
	
	public String toString() {
		StringBuilder s = new StringBuilder();

		if (!this.isEmpty()) {
			s.append("Contenuto borsa ("+this.getPeso()+"kg/"+this.getPesoMax()+"kg): ");
			s.append(this.getContenutoRaggruppatoPerPeso());
		}
		else
			s.append("Borsa vuota");
		return s.toString();
	}


}
