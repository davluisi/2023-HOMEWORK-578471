package it.uniroma3.diadia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.ambienti.StanzaBloccata;
import it.uniroma3.diadia.attrezzi.Attrezzo;

class StanzaBloccataTest {
	
	private Stanza stanzaBloccata = new StanzaBloccata("gabbia", "nord", "chiave");
	private Stanza vicina = new Stanza("vicina");

	@BeforeEach
	void setUp() throws Exception {
		stanzaBloccata.impostaStanzaAdiacente("nord", vicina);
	}

	@Test
	void test1() {
		stanzaBloccata.addAttrezzo(new Attrezzo("chiave", 1));
		assertEquals(vicina, stanzaBloccata.getStanzaAdiacente("nord"));
	}
	
	@Test
	void test2() {
		assertEquals(stanzaBloccata, stanzaBloccata.getStanzaAdiacente("nord"));
	}

}
