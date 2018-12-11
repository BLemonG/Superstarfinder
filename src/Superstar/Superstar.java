package Superstar;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;


public class Superstar {
	
//Attribute	 	   
	
	ArrayList<String> names;
	boolean [][] matrix;				

//Konstruktor
	public Superstar (String textdatei) {
		names = alleEinlesen(textdatei);						//Namens-ArrayList aller Gruppenmitglieder
		matrix = new boolean[names.size()][names.size()];		//Matrix für die Like/Gelikt Verhälltnisse zu speichern
		this.matrixStandardBelegung();							//Befüllen mit false Werten
		this.matrixNamenBefüllen(textdatei);					//Einlesen der Likes
		}
	
//Methoden  	
	public ArrayList<String> alleEinlesen(String textdatei) {
			  
		ArrayList<String> names = null;
			
				//Buffered Reader zum Einlesen der ersten Zeile in der txt-Datei
				try (BufferedReader br = new BufferedReader(new FileReader(textdatei))) {		

					

					//Einlesen der erste Zeile
					String namenskette = br.readLine();
					//alle Strings in der Zeile durch Leerzeichen splitten und in ArrayList einfügen
					names = new ArrayList<String>(Arrays.asList(namenskette.split(" ")));		
					br.close();
					//Anzahl der Personen ausgeben
					System.out.println("Es nehmen " + names.size() + " Personen teil:");		
					//Alle Personen zum Überprüfen ausgeben
					System.out.println(names);													
					
						
				} catch (NumberFormatException | IOException e) {
					//Falls Datei nicht vorhanden ist Fehler melden
					System.out.println("Fehler beim einlesen der Datei: " + textdatei);			
					e.printStackTrace();
				} 
				return names;
			 }
	//Ausgabe der Namensliste in der Console mit der matrix entsprechenden Abständen
	private void namenAusgeben(ArrayList<String> names) {
		for (String s:names) {
			System.out.printf("%-9s", s);
        }
		System.out.println();
	}
	
	//Ausgabe der LikeGeleiked-Matrix
	public void matrixAusgabe() {
		
		System.out.println(" ");
		System.out.println("Matrixausgabe:"); //neue Zeile
		namenAusgeben(names);
					
		System.out.println("---------------------------------------------");
					for(byte i = 0; i < names.size(); i++) {	//Gehe jede Zeile von oben nach unten durch
						for(byte j = 0; j < names.size(); j++) {	//Gehe nun jedes Element von links nach rechts durch
							// prinf erlaubt formatiertes Ausgeben von werten: z.B. rechtsbündig (mindestens 3 Stellen)
						    System.out.printf( "%-8s|" , Boolean.toString(matrix[i][j]));
						}
						//Ende der Zeile:
						System.out.println(); //neue Zeile
						System.out.println("---------------------------------------------"); 
					}
	}		
	
	//Bei der Erzeugung wird die Matrix standardmäßig mit false belegt
	public void matrixStandardBelegung() {
		
			int laenge = names.size();
		
			for(byte i = 0; i < laenge; i++) {		//Gehe jede Zeile von oben nach unten durch
				
				for(byte j = 0; j < laenge; j++) {	//Gehe nun jedes Element von links nach rechts durch
					matrix[i][j] = false;		//Belege jedes Elemnt mit dem default-Wert false; 
				}
			}
			this.matrixAusgabe();
	}
				
	/**
	 * In dieser Methode wird das vorgegebene Textfile ab der 2. Zeile eingelesen.
	 * Nach dem Auslesen des 1. Strings wird sofort dessen Position in der Namens-ArrayList bestimmt, ebenso
	 * geschieht dies bei dem 2. String. Diese Positionen geben an, an welcher Stelle in der Matrix die Belegung true 
	 * eingetragen werden soll.
	 * 
	 * @param textdatei
	 */
	public void matrixNamenBefüllen(String textdatei) {
		
		Scanner s;
		try {
//			Scanner geht neuen File ab Zeile 1 durch, da Zeile 0 nur alle teilnehmer sind
			s = new Scanner(new File(textdatei));
			s.nextLine();
//			//Matrix dort mit true werten befüllen, wo jemand jemanden liked
			//Scanner übergibt true, wo i = der erste String, und j = der zweite String in einer Zeile ist
			while (s.hasNextLine()) {
				
				matrix [names.indexOf(s.next())][names.indexOf(s.next())] = true;	
			}
			s.close();
		}catch (Exception e) {
			
			e.printStackTrace();
		}
		//Matrixausgabe zur Überprüfung
		this.matrixAusgabe();
	}
	
	
	public void getSuperStar() {
		
		boolean anwaerter = false;
		boolean superstar = false;
		int euro = 0;
		
		//Geht jede Zeile der Matrix Schritt für Schritt durch, wenn der erste Eintrag mit true kommt 
		//und nicht i = j ist (also Eintrag bei sich selbst), handelt es sich sicher nicht um einen Superstar.
		//Nur wenn alle Einträge false sind, kann man die Spalte des "Anwärters" testen:
		//Diese muss immer mit true (bis auf Matrix[i][i] belegt sein.
		for(int i = 0; i < names.size(); i++) {
			anwaerter = false;
			superstar = false;
			
			//Ist die Zeile nur mit false belegt?
			for(int j = 0; j < names.size(); j++) {
//				Zur Überprüfung, ob 
//				System.out.println("Liked " + names.get(i) + " das Mitglied " + names.get(j) + "? " + matrix[i][j]);
				euro++;
				
				if(matrix[i][j] == true) {
					anwaerter = false;
					break;	//Bricht die innere for-Schleife ab, wenn der erste liked-Eintrag kommt -> Spart Kosten
				}
				else
					anwaerter = true;
			}
			
			//Wenn ja, teste auf Superstar, sonst nächste Zeile
			if(anwaerter == true) {
				//Teste ob Spalte nur mit true (bis auf eigener Eintrag) belegt ist
				for(int m = 0; m < names.size(); m++) {
//					System.out.println("Liked " + names.get(m) + " das Anwaertermitglied " + names.get(i) + "? "+ matrix[m][i]);
					euro++;
					
					if(matrix[m][i] == false && (m != i)) {
						superstar = false;
						break;
					}
					else
						superstar = true;
				}
			}
			
			if(superstar) {
				System.out.println(" ");
				System.out.println(names.get(i) + " ist Superstar! ");
				System.out.println(" ");
			}
			
			
		}
		
		System.out.println(" ");
		System.out.println("Die Anfrage kostet  " + euro + "€!");
		System.out.println(" ");
		
	}
		

}

   
