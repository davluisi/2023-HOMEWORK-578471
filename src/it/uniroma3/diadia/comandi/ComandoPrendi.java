package it.uniroma3.diadia.comandi;

import it.uniroma3.diadia.IO;
import it.uniroma3.diadia.IOConsole;
import it.uniroma3.diadia.Partita;
import it.uniroma3.diadia.ambienti.Stanza;
import it.uniroma3.diadia.attrezzi.Attrezzo;

public class ComandoPrendi implements Comando {
	private String nomeAttrezzo;

	public ComandoPrendi() {
		this.nomeAttrezzo = null;
	}
	
	public ComandoPrendi(String nomeAttrezzo) {
		this.nomeAttrezzo = nomeAttrezzo;
	}
	
	@Override
	public void esegui(Partita partita, IO console) {
		Stanza stanza = partita.getStanzaCorrente();
		if(stanza.getNumeroAttrezzi()==0) {
			console.mostraMessaggio("Non ci sono attrezzi nella stanza...\n");
		}
		else{
			if(stanza.hasAttrezzo(nomeAttrezzo)){
				Attrezzo attrezzo = stanza.getAttrezzo(nomeAttrezzo);
				stanza.removeAttrezzo(nomeAttrezzo);
				partita.getGiocatore().getBorsa().addAttrezzo(attrezzo);
				console.mostraMessaggio("Attrezzo preso\n");
			}
			else
				console.mostraMessaggio("L'attrezzo non è nella stanza...\n");
		}
		console.mostraMessaggio(partita.getStanzaCorrente().getDescrizione());
	}

	@Override
	public void setParametro(String parametro) {
		this.nomeAttrezzo = parametro;
	}

	@Override
	public String getNome() {
		return "prendi";
	}

	@Override
	public String getParametro() {
		return this.nomeAttrezzo;
	}

}
