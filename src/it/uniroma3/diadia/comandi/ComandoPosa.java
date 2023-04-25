package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;
import it.uniroma3.diadia.giocatore.Borsa;

public class ComandoPosa implements Comando {
	private String nomeAttrezzo;
	
	public ComandoPosa() {
		this.nomeAttrezzo = null;
	}
	
	public ComandoPosa(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}

	@Override
	public void esegui(Partita partita, IO console) {
		Borsa borsa = partita.getGiocatore().getBorsa();
		Stanza stanza = partita.getStanzaCorrente();
		if(borsa.hasAttrezzo(nomeAttrezzo)) {
			Attrezzo attrezzo = borsa.removeAttrezzo(nomeAttrezzo);
			stanza.addAttrezzo(attrezzo);
			console.mostraMessaggio("Attrezzo posato.\n");
		}
		else
			console.mostraMessaggio("Non hai questo attrezzo.\n");
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "posa";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
