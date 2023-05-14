package it.uniroma3.diadia;

import it.uniroma3.diadia.ambienti.Labirinto;
import it.uniroma3.diadia.ambienti.LabirintoBuilder;
import it.uniroma3.diadia.comandi.*;
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


	private Partita partita;

	public DiaDia() {
		this.partita = new Partita();
	}

	/**
	 * Fa iniziare il gioco e processa  le istruzioni fino alla terminazione
	 * 
	 */
	public void gioca(IO console) {
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
	private boolean processaIstruzione(String istruzione, IO console) {
		Comando comandoDaEseguire;

		FabbricaDiComandi factory = new FabbricaDiComandiFisarmonica();
		comandoDaEseguire = factory.costruisciComando(istruzione);
		comandoDaEseguire.esegui(this.partita, console);
		if (this.partita.vinta())
			console.mostraMessaggio("Hai vinto!");
		if (!this.partita.giocatoreIsVivo())
			console.mostraMessaggio("Hai esaurito i CFU...");

		return this.partita.isFinita();
	}   


	/**
	 * metodo main
	 */
	public static void main(String[] argc) {
		final IO console = new IOConsole();
		
		Labirinto labirinto = new LabirintoBuilder()
				.addStanzaIniziale("LabCampusOne")
				.addStanzaVincente("Biblioteca")
				.addAdiacenza("LabCampusOne","Biblioteca","ovest")
				.getLabirinto();
		
		DiaDia gioco = new DiaDia();
		gioco.gioca(console);
	}
}