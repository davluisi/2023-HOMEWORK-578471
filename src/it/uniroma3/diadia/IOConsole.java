package it.uniroma3.diadia;
import java.util.Scanner;

/**
 * Questa classe gestisce le interazioni di Input/Output con l'utente.
 * Può far stampare un messaggio o leggerne uno da tastiera.
 * 
 * @author docente di POO
 * @version base
 */
public class IOConsole implements IO{
	
	@Override
	public void mostraMessaggio(String msg) {
		System.out.println(msg);
	}
	
	@Override
	public String leggiRiga() {
		Scanner scannerDiLinee = new Scanner(System.in);
		String riga = scannerDiLinee.nextLine();
//      scannerDiLinee.close();
		return riga;
	}
}
