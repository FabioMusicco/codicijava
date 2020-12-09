package esercizio_sett_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

public class GuerraPace {

	public static void main(String[] args) {
		URL url;// creare un url che è l indirizzo internet da analizzare
		URLConnection uRLConnection = null;
		try {
			url = new URL("http://m.gutenberg.org/files/2600/2600-h/2600-h.htm#link2HCH0001");
			uRLConnection = url.openConnection();// apri la connessione
			uRLConnection.connect();// collegamento al server google

		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int war_counter = 0;
		Map<String,Integer> occorrenze= new HashMap <String,Integer>();
		try {
			InputStream risposta = uRLConnection.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(uRLConnection.getInputStream()));
			String riga = null;
			String periodo = "";
			boolean siamo_nel_periodo = true;
			
			
			do {
				riga = br.readLine();// leggiamo il buffer riga per riga
				if (siamo_nel_periodo) {
					periodo += riga;
				}
				// System.out.println(riga);
				if (riga != null && riga.indexOf("<p>") >= 0) {
					siamo_nel_periodo = true;
					periodo = "";// analizza un LTRO periodo
				}
				if (riga != null && riga.indexOf("</p>") >= 0) {
					siamo_nel_periodo = false;
					String[] periodo_splittato = periodo.split(" ");
					for (int i = 0; i < periodo_splittato.length; i++) {
						String parola_iesima=periodo_splittato[i];
						if(occorrenze.get(parola_iesima) ==null) {
							occorrenze.put(parola_iesima,0);
						}
						Integer numero_occorrenze=occorrenze.get(parola_iesima);
						occorrenze.put(parola_iesima,numero_occorrenze+1);//contatore
//						if (periodo_splittato[i].contains("war")) {
//							war_counter++;
//						}
					}

				}
				
			} while (riga != null);
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println("Numero occorrenze" + occorrenze );
	//	System.out.println("La parola WAR compare " + war_counter + " volte");

	}

}
