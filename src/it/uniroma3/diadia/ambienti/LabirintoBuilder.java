package it.uniroma3.diadia.ambienti;

import java.util.HashMap;
import java.util.Map;

import it.uniroma3.diadia.attrezzi.Attrezzo;

public class LabirintoBuilder extends Labirinto{

	private Stanza ultimaStanzaAggiunta = null;
	private Map<String, Stanza> listaStanze = new HashMap<String, Stanza>();

	public boolean hasStanza(String nomeStanza) {
		return this.listaStanze.containsKey(nomeStanza);
	}

	public LabirintoBuilder addStanza(String nomeStanza) {
		if(!(this.hasStanza(nomeStanza))) {
			Stanza nuova = new Stanza(nomeStanza);
			this.listaStanze.put(nomeStanza, nuova);
			this.ultimaStanzaAggiunta = nuova;
		}
		return this;
	}

	public LabirintoBuilder addStanzaIniziale(String nomeStanza) {
		if(this.hasStanza(nomeStanza))
			this.stanzaIngresso = this.listaStanze.get(nomeStanza);
		else {
			this.stanzaIngresso = new Stanza(nomeStanza);
			this.listaStanze.put(nomeStanza, stanzaIngresso);
		}
		this.ultimaStanzaAggiunta = this.stanzaIngresso;
		return this;
	}

	public LabirintoBuilder addStanzaVincente(String nomeStanza) {
		
		if(this.hasStanza(nomeStanza))
			this.stanzaVincente = this.listaStanze.get(nomeStanza);
		else {
			this.stanzaVincente = new Stanza(nomeStanza);
			this.listaStanze.put(nomeStanza, stanzaVincente);
		}
		this.ultimaStanzaAggiunta = this.stanzaVincente;
		return this;
	}

	public LabirintoBuilder getLabirinto() {
		return this;
	}

	public LabirintoBuilder addAttrezzo(String nomeAttrezzo, int peso) {
		this.ultimaStanzaAggiunta.addAttrezzo(new Attrezzo(nomeAttrezzo, peso));
		return this;
	}

	public LabirintoBuilder addAdiacenza(String nome1, String nome2, String direzione) {
		this.listaStanze.get(nome1).impostaStanzaAdiacente(direzione, this.listaStanze.get(nome2));
		return this;
	}

	public Map<String, Stanza> getListaStanze() {
		return this.listaStanze;
	}

	public LabirintoBuilder addStanzaMagica(String nomeStanzaMagica, int sogliaMagica) {
		Stanza stanzaMagica = new StanzaMagica(nomeStanzaMagica, sogliaMagica);
		this.listaStanze.put(nomeStanzaMagica, stanzaMagica);
		this.ultimaStanzaAggiunta = stanzaMagica;
		return this;
	}

	public LabirintoBuilder addStanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSblocco) {
		Stanza stanzaBloccata = new StanzaBloccata(nome, direzioneBloccata, nomeAttrezzoSblocco);
		this.listaStanze.put(nome, stanzaBloccata);
		this.ultimaStanzaAggiunta = stanzaBloccata;
		return this;
	}

	public LabirintoBuilder addStanzaBuia(String nome, String nomeAttrezzoLuce) {
		Stanza stanzabuia = new StanzaBuia(nome, nomeAttrezzoLuce);
		this.listaStanze.put(nome, stanzabuia);
		this.ultimaStanzaAggiunta = stanzabuia;
		return this;
	}
}
