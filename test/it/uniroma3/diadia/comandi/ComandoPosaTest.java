package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class ComandoPosaTest {
	
	private Partita partita;
	private Comando posa;
	private IOConsole console;

	@BeforeEach
	void setUp() throws Exception {
		partita = new Partita();
		posa = new ComandoPosa();
		console = new IOConsole();
		partita.getGiocatore().getBorsa().addAttrezzo(new Attrezzo("penna", 1));
	}

	@Test
	void test1() {
		posa.setParametro("penna");
		posa.esegui(partita, console);
		assertTrue(partita.getStanzaCorrente().hasAttrezzo("penna"));
	}
	
	@Test
	void test2() {
		posa.esegui(partita, console);;
		assertEquals(1, partita.getStanzaCorrente().getNumeroAttrezzi());
	}

}
