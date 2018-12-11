package Superstar;




    public class Main {

      
	//MAIN Methode

		public static void main(String[] args)  {
            
            
            
						 
			char copyrigth = '\u00A9';
		
			Superstar supi1 = new Superstar("1.txt");		//erzeugt neuen Superstar aus Datei	
			supi1.getSuperStar();							//startet Superstar Abfrage
			
			
			System.out.println();
			System.out.println("Copyright by Leon Müller " + copyrigth);
		
		}
    }


