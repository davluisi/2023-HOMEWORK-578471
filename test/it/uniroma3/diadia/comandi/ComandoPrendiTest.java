package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;

class ComandoPrendiTest {
	
	private Partita partita;
	private Comando prendi;
	private IOConsole console = new IOConsole();

	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();
		prendi = new ComandoPrendi();
	}

	@Test
	void test() {
		prendi.setParametro("osso");
		prendi.esegui(partita, console);
		assertTrue(partita.getGiocatore().getBorsa().hasAttrezzo("osso"));
	}

}
