package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Labirinto;

class LabirintoTest {
	
	private Labirinto labirinto;

	@BeforeEach
	void setUp() {
		this.labirinto = new Labirinto();
		this.labirinto.creaStanze();
	}

	@Test
	void creaStanzeTest1() {
		assertEquals("osso", this.labirinto.getStanzaIngresso().getAttrezzo("osso").getNome());
	}
	
	@Test
	void creaStanzeTest2() {
		assertEquals("Biblioteca", this.labirinto.getStanzaIngresso().getStanzaAdiacente("nord").getNome());
	}
	
	@Test
	void creaStanzeTest3() {
		assertEquals("Aula N11", this.labirinto.getStanzaIngresso().getStanzaAdiacente("est").getNome());
	}
	
	@Test
	void creaStanzeTest4() {
		assertEquals("lanterna", this.labirinto.getStanzaIngresso().getStanzaAdiacente("sud").getAttrezzo("lanterna").getNome());		
	}

}
