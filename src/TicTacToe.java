public class TicTacToe {
	// Attribute
	private int spielzuege;
	private char[] feld;
	private final char LEER;
	
	// Konstruktor
	public TicTacToe() {
		this.feld = new char[9];
		this.LEER = '-';
	}
	
	public char getFeld(int nummer) {
		return this.feld[nummer];
	}
	
	public void setFeld(int nummer, char zeichen) {
		this.feld[nummer] = zeichen;
	}
	
	public boolean istFrei(int nummer) {
		if (nummer >= feld.length || nummer < 0) return false; // kleiner als 0 ist bloed | Len ist immer +1 max zugriff -> sonst out of bounds
		return this.feld[nummer] == LEER;
	}
	
	
	public void ausgeben() {
		String out = 	"[ " + feld[0] + " ][ " + feld[1] + " ][ " + feld[2] + " ]\n" +
						"[ " + feld[3] + " ][ " + feld[4] + " ][ " + feld[5] + " ]\n" +
						"[ " + feld[6] + " ][ " + feld[7] + " ][ " + feld[8] + " ]";
		
		System.out.println(out);
	}
	
	public boolean istGameOver() {
		// Ist spielzuege groesser 9
		if (spielzuege >= 9) {
			// Nicht mehr moeglich
			return true;
		}
		
		//	0	1	2
		//	3	4	5
		//	6	7	8
		
		// ---
		if ((LEER != feld[0]) && (feld[0] == feld[1]) && (feld[1] == feld[2])) return true;
		if ((LEER != feld[3]) && (feld[3] == feld[4]) && (feld[4] == feld[5])) return true;
		if ((LEER != feld[6]) && (feld[6] == feld[7]) && (feld[7] == feld[8])) return true;
		
		// |||
		if ((LEER != feld[0]) && (feld[0] == feld[3]) && (feld[3] == feld[6])) return true;
		if ((LEER != feld[1]) && (feld[1] == feld[4]) && (feld[4] == feld[7])) return true;
		if ((LEER != feld[2]) && (feld[2] == feld[5]) && (feld[5] == feld[8])) return true;
		
		// \	/
		if ((LEER != feld[0]) && (feld[0] == feld[4]) && (feld[4] == feld[8])) return true;
		if ((LEER != feld[2]) && (feld[2] == feld[4]) && (feld[4] == feld[6])) return true;
		
		return false;
	}
	
	
	
	/**
	* Wird ausgefuehrt, wenn der Computer seinen naechsten Zug machen soll.
	* Innerhalb der Methode wird zunaechst zufaellig eine Zahl zwischen 1 und 9
	* bestimmt. Anschliessend wird versucht das Feld mit der entsprechenden
	* Feldnummer zu markieren.
	*
	*/
	public void zugComputer() {
		int eingabe = -1;
		spielzuege++;
		do {
			/* die folgende Anweisung erzeugt eine Pseudo-Zufallszahl zwischen 1 und 9 */
			eingabe = (int)(Math.random() * 9) + 1;
			System.out.println("Computer hat das Feld " + (eingabe) + " gewählt.");
		}
		/* fuer die zufaellig bestimme Feldnummer wird anschliessend geprueft, ob diese nicht
		vielleicht bereits besetzt ist.
		Sonst muss eine neue Zahl ermittelt werden */
		while(eingabe <=9 && eingabe >=1 && !istFrei(eingabe));
		/* das Feld ist noch frei und wird nun markiert */
		setFeld(eingabe, 'O');
		System.out.println("Der Computer hat seinen Zug beendet.");
		/* geaendertes Spielfeld anzeigen */
		ausgeben();
	}

	public void zugSpieler() {
		int eingabe = -1;
		spielzuege++;
		
		do {
			System.out.println("Waehlen Sie eine gueltige Zahl (1-9)");
			eingabe = Keyboard.readInt() -1;
			System.out.println("Sie waehlten " + eingabe +1 + ".");
		} while (eingabe <=9 && eingabe >=1 && !istFrei(eingabe));
		setFeld(eingabe, 'X');
		System.out.println("Sie haben Ihren Zug beendet.");
		ausgeben();
		
	}
	
	public void initialisiereSpielfeld() {
		// Mache jedes Feld von feld auf LEER
		for(int i = 0; i <= 8; i++) {
			feld[i] = LEER;
		}
	}

}
