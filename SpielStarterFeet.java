/**
 * Die Klasse dient zum Start des Spiels TicTacToe.
 * Diese Klasse ist eine modifizierte Version von der Originalen!!
 * 
 */
public class SpielStarterFeet {
	
	/**
	 * In diesem Attribut wird abgelegt, ob das Spiel bereits 
	 * beendet ist bzw. ob weiter gespielt werden soll.
	 */
	private boolean gameOver;
	
	/**
	 * Zum Spielen wird ein Objekt der Klasse TicTacToe benoetigt.
	 */
	private TicTacToeFeet spielplan = new TicTacToeFeet();
	
		
	
	/**
	 * Standard-Konstruktor der Klasse SpielStarter.
	 */
	SpielStarterFeet() { 
		gameOver = false; 	 
	}
	
	/**
	 * Eigentliche Start-Methode des Spiels. Wird von 
	 * <code>main</code> aufgerufen.
	 */
	public void start() {
		
		/* aeussere Schleife */
		do{		
			System.out.println("Willkommen! Sie moechten gern eine Runde Tic-Tac-Toe spielen ?");
			System.out.println("Dann geht es jetzt los!");			
			System.out.println();
			System.out.println("Ihr Zeichen lautet " + "X" + ". Das Zeichen des Computers lautet " + "O" + ".");
			System.out.println("Waehlen Sie ein Feld aus. Geben Sie eine Zahl zwischen 1 und 16 ein:");
			spielplan.initialisiereSpielfeld(); 
			spielplan.ausgeben();
			
			/* innere Schleife */
			while(!gameOver){ // solange das Spiel nicht beendet ist
				
				spielplan.zugSpieler();
				if(spielplan.istGameOver()){
					spielplan.ausgeben();
					System.out.println("Sie haben gewonnen!!!");
					break;
				}
				spielplan.zugComputer();
				if(spielplan.istGameOver()){
					spielplan.ausgeben();
					System.out.println("Der Computer hat gewonnen. Schade.");
					break;
				}
			}
			
			System.out.println("Spiel beendet!");
			System.out.print("Moechten Sie noch einmal spielen (J/N)? ");
			try {
				if(Keyboard.readChar() == 'N'){
					gameOver = true;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} while(!gameOver);
	}

	
	/**
	 * Hauptprogramm. 
	 * @param args
	 */
	public static void main(String[] args) {
		SpielStarterFeet s= new SpielStarterFeet();
		s.start();
		
	}
}
