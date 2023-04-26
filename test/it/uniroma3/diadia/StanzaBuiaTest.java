package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBuia;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBuiaTest {
	
	private Stanza stanzaBuia;
	final static String messaggio = "Qui c'è un buio pesto";

	@BeforeEach
	void setUp() throws Exception {
		stanzaBuia = new StanzaBuia("caverna", "lanterna");
	}

	@Test
	void test1() {
		stanzaBuia.addAttrezzo(new Attrezzo("torcia", 2));
		assertEquals(messaggio, stanzaBuia.getDescrizione());
	}
	
	@Test
	void test2() {
		stanzaBuia.addAttrezzo(new Attrezzo("lanterna", 1));
		assertNotEquals(messaggio, stanzaBuia.getDescrizione());
	}

}
