package iojava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class BufferLettore {

	public static void main(String[] args) {
		System.out.println("java.class.path" + "__val__" + System.getProperties().getProperty("java.class.path"));
		FileReader file = null;
		try {
			file = new FileReader("filet.txt");// nell caertella corrente c' è un file
																	// lettore.class. è da qqui che voglio leggere i
																	// dati
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(file);// leggere in modo bufferizato i dati
		String s=null;
		do {
			try {
				s = br.readLine();
				if(s != null) {
				System.out.println(s);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while (s != null);
		BufferedWriter brw=null;
		FileWriter filew=null;
		try {
			filew= new FileWriter("conti.dat",true);// creo un file. aìse il file è uguale, lo mantiene
			brw=new BufferedWriter(filew);
			for(int i=0;i<10000;i++) {
				brw.append("Ciao"+i+"\n");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//brw= new BufferedWriter(filew);
	}

}
