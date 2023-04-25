package it.uniroma3.diadia.comandi;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.comandi.Comando;
import it.uniroma3.diadia.comandi.ComandoVai;

class ComandoVaiTest {

	private Partita partita;
	private IOConsole console = new IOConsole();
	private Comando vai;

	@BeforeEach
	void setUp() {
		partita = new Partita();
		vai = new ComandoVai();
	}

	@Test
	void testEsegui1() {
		vai.setParametro("nord");
		vai.esegui(partita, console);
		assertEquals("Biblioteca", partita.getStanzaCorrente().getNome());
	}
	
	@Test
	void testEsegui2() {
		vai.esegui(partita, console);
		assertEquals("Atrio", partita.getStanzaCorrente().getNome());
	}

}
