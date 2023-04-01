package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;
import it.uniroma3.diadia.giocatore.Giocatore;

/**
 * Classe principale di diadia, un semplice gioco di ruolo ambientato al dia.
 * Per giocare crea un'istanza di questa classe e invoca il metodo gioca
 *
 * Questa è la classe principale crea e istanzia tutte le altre
 *
 * @author  docente di POO 
 *         (da un'idea di Michael Kolling and David J. Barnes) 
 * @see Stanza
 * @version base
 */

public class DiaDia {

	static final private String MESSAGGIO_BENVENUTO = ""+
			"Ti trovi nell'Universita', ma oggi e' diversa dal solito...\n" +
			"Meglio andare al piu' presto in biblioteca a studiare. Ma dov'e'?\n"+
			"I locali sono popolati da strani personaggi, " +
			"alcuni amici, altri... chissa!\n"+
			"Ci sono attrezzi che potrebbero servirti nell'impresa:\n"+
			"puoi raccoglierli, usarli, posarli quando ti sembrano inutili\n" +
			"o regalarli se pensi che possano ingraziarti qualcuno.\n\n"+
			"Per conoscere le istruzioni usa il comando 'aiuto'.\n";

	static final private String[] elencoComandi = {"vai", "aiuto", "prendi", "posa", "fine\n"};

	private Partita partita;
	private Giocatore giocatore;

	public DiaDia() {
		this.partita = new Partita();
		this.giocatore = this.partita.getGiocatore();
	}

	/**
	 * Fa iniziare il gioco e processa  le istruzioni fino alla terminazione
	 * 
	 */
	public void gioca(IOConsole console) {
		String istruzione; 

		console.mostraMessaggio(MESSAGGIO_BENVENUTO);
		istruzione = console.leggiRiga();	
		this.processaIstruzione(istruzione, console);
		do		
			istruzione = console.leggiRiga();
		while (!processaIstruzione(istruzione, console));
	}   


	/**
	 * Processa una istruzione 
	 * 
	 * @return true se l'istruzione e' eseguita e il gioco continua, false altrimenti
	 */
	private boolean processaIstruzione(String istruzione, IOConsole console) {
		Comando comandoDaEseguire = new Comando(istruzione);

		if ("fine".equals(comandoDaEseguire.getNome())) {
			this.fine(console); 
			return true;
		} else if ("vai".equals(comandoDaEseguire.getNome()))
			this.vai(console);
		else if ("aiuto".equals(comandoDaEseguire.getNome()))
			this.aiuto(console);
		else if("prendi".equals(comandoDaEseguire.getNome()))
			this.prendi(console);
		else if("posa".equals(comandoDaEseguire.getNome()))
			this.posa(console);
		else
			console.mostraMessaggio("Comando sconosciuto.\n");
		if (this.partita.vinta()) {
			console.mostraMessaggio("Hai vinto!");
			return true;
		} 
		else 

			return false;
	}   

	// implementazioni dei comandi dell'utente:

	/**
	 * Stampa informazioni di aiuto.
	 */
	private void aiuto(IOConsole console) {
		for(int i=0; i< elencoComandi.length; i++) 
			console.mostraMessaggio(elencoComandi[i]+" ");
	}

	/**
	 * Cerca di andare in una direzione. Se c'è una stanza ci entra 
	 * e ne stampa il nome, altrimenti stampa un messaggio di errore
	 */
	private void vai(IOConsole console) {
		console.mostraMessaggio("Dove vuoi andare? (nord/sud/est/ovest)");
		String direzione = console.leggiRiga();
		Stanza prossimaStanza = this.partita.getStanzaCorrente().getStanzaAdiacente(direzione);
		if (prossimaStanza == null)
			console.mostraMessaggio("Direzione inesistente.\n");
		else {
			this.partita.setStanzaCorrente(prossimaStanza);
			int cfu = this.giocatore.getCfu();
			this.giocatore.setCfu(cfu--);
		}
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	/**
	 * Fa prendere un attrezzo al giocatore,
	 * mettendolo nella borsa e togliendolo dalla stanza.
	 * Stampa un messaggio di errore se la stanza non ha attrezzi
	 * o l'attrezzo cercato non vi è presente.
	 * 
	 * @return se l'attrezzo è stato preso
	 */
	private boolean prendi(IOConsole console) {
		boolean preso = false;
		Stanza stanza = this.partita.getStanzaCorrente();
		if(stanza.getNumeroAttrezzi()==0) {
			console.mostraMessaggio("Non ci sono attrezzi nella stanza...\n");
		}
		else{
			console.mostraMessaggio("Cosa vuoi prendere?");
			String nomeAttrezzo = console.leggiRiga();
			if(stanza.hasAttrezzo(nomeAttrezzo)){
				Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);
				stanza.removeAttrezzo(nomeAttrezzo);
				this.giocatore.getBorsa().addAttrezzo(attrezzo);
				preso = true;
				console.mostraMessaggio("Attrezzo preso\n");
			}
			else
				console.mostraMessaggio("L'attrezzo non è nella stanza...\n");
		}
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		return preso;
	}


	/**
	 * Fa posare un attrezzo al giocatore, togliendolo dalla borsa
	 * e mettendolo nella stanza.
	 * Stampa un messaggio di errore se nella borsa non c'è l'attrezzo cercato.
	 * 
	 * @return se l'attrezzo è stato posato
	 */
	private boolean posa(IOConsole console) {
		boolean posato = false;
		Borsa borsa = this.partita.getGiocatore().getBorsa();
		Stanza stanza = this.partita.getStanzaCorrente();
		console.mostraMessaggio("Cosa vuoi posare?");
		String nomeAttrezzo = console.leggiRiga();
		if(borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
			stanza.addAttrezzo(attrezzo);
			console.mostraMessaggio("Attrezzo posato.\n");
			posato = true;
		}
		else
			console.mostraMessaggio("Non hai questo attrezzo.\n");
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
		return posato;
	}

	/**
	 * Comando "Fine".
	 */
	private void fine(IOConsole console) {
		console.mostraMessaggio("Grazie di aver giocato!");  // si desidera smettere
	}

	/**
	 * metodo main
	 */
	public static void main(String[] argc) {
		DiaDia gioco = new DiaDia();
		final IOConsole console = new IOConsole();
		gioco.gioca(console);
	}
}