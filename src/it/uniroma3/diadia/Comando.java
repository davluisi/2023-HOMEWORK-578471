package it.uniroma3.diadia;


/**
 * Questa classe modella un comando.
 * Un comando consiste di una parola:
 * il nome del comando.
 * 
 * @author  docente di POO
 * @version base
 */

public class Comando {

    private String nome;

    public Comando(String istruzione) {
		this.nome = istruzione; 
    }

    public String getNome() {
        return this.nome;
    }

    public boolean sconosciuto() {
        return (this.nome == null);
    }
}