package iojava;

import java.io.File;
import java.util.Arrays;
//import java.util.Enumeration;
public class DirUtil {

	public static void main(String[] args) {// per lanciare da terminale, deve averre un main string args. valori
											// provenienti dalla riga di comando
		if (args == null && args.length==0) {
			System.out.println("Nessun Parametro");
		} else {
			if (args[0].equals("-d")) {

				for (int i = 0; i < args.length; i++) {
					File dir = new File(args[i]);
					if (dir.exists()) {
						dir.delete();
						System.out.println("Cancello la directory_" + dir);
					} else {
						System.out.println("Inesistente la directory_" + dir);
					}
					// System.out.println(Arrays.toString(args));
				}
			}
			else {
				for (int i = 0; i < args.length; i++) {
					File dir = new File(args[i]);
					System.out.println("Creo la directory"+dir);
					dir.mkdir();
			}
			}
		//creea in insieme di string un insieme di directory
		//un insieme di stringhe e cancella un insimee di directory
//		Enumeration<Object> en = System.getProperties().keys();

//		while (en.hasMoreElements()) {
//
//			String key = (String) en.nextElement();
		System.out.println("java.class.path"+ "__val__" + System.getProperties().getProperty("java.class.path"));
//		}
		File dir_curr = new File(".");// in realtà è una directory
		File filet=new File("filet.txt");
		System.out.println(filet.getAbsolutePath());
		
		dir_curr.list();
		System.out.println(Arrays.toString(dir_curr.list()));
		System.out.println(Arrays.toString(filet.list()));
		System.out.println(filet.isFile());
		System.out.println(dir_curr.isFile());
		
		
	}
	}
}
