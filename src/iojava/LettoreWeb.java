package iojava;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class LettoreWeb {

	public static void main(String[] args) {
		URL url;//creare un url che è l indirizzo internet da analizzare
		URLConnection uRLConnection= null;
		try {
			url = new URL("http://m.gutenberg.org/files/2600/2600-h/2600-h.htm#link2HCH0001");
			uRLConnection=url.openConnection();//apri la connessione
			uRLConnection.connect();// collegamento al server google. se metti uRlConnection.setConnectTimeout(20000), che sono i millisecondi. oppure setReadTimeout(20000)

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {//potenziali eccezioni
			// TODO Auto-generated catch block
			e.printStackTrace();
	
	}try {
		InputStream risposta=uRLConnection.getInputStream();
		BufferedReader br=new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()));//salva i dati su un lettore
		String riga=null;
		do {
			riga=br.readLine();//leggiamo il buffer riga per riga
			System.out.println(riga);
		}while(riga!=null);
		br.readLine();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}
}
