package it.uniroma3.diadia.ambienti;

public class StanzaBloccata extends Stanza {

	private String direzioneBloccata;
	private String nomeAttrezzoSblocco;

	public StanzaBloccata(String nome, String direzioneBloccata, String nomeAttrezzoSblocco) {
		super(nome);
		this.direzioneBloccata = direzioneBloccata;
		this.nomeAttrezzoSblocco = nomeAttrezzoSblocco;
	}

	@Override
	public Stanza getStanzaAdiacente(String direzione) {
		if(direzione==this.direzioneBloccata) {
			if(!(this.hasAttrezzo(nomeAttrezzoSblocco)))
				return this;
			else
				return super.getStanzaAdiacente(direzione);
		}
		else
			return super.getStanzaAdiacente(direzione);
	}

	@Override
	public String getDescrizione() {
		StringBuilder risultato = new StringBuilder();
		risultato.append(super.getDescrizione() + "\n");
		risultato.append("Direzione bloccata: ");
		risultato.append(this.direzioneBloccata + "\n");
		risultato.append("Nome attrezzo per lo sblocco: ");
		risultato.append(nomeAttrezzoSblocco);
		return risultato.toString();
	}

}
