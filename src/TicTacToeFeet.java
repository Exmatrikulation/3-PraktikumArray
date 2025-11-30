public class TicTacToeFeet {
	// Attribute
	private int spielzuege;
	private char[] feld;
	private final char LEER;
	
	// Konstruktor
	public TicTacToeFeet() {
		this.feld = new char[16];
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
		String out = 	"[ " + feld[0] + " ][ " + feld[1] + " ][ " + feld[2] + " ][ " + feld[3] + " ]\n" +
						"[ " + feld[4] + " ][ " + feld[5] + " ][ " + feld[6] + " ][ " + feld[7] + " ]\n" +
						"[ " + feld[8] + " ][ " + feld[9] + " ][ " + feld[10] + " ][ " + feld[11] + " ]\n" +
						"[ " + feld[12] + " ][ " + feld[13] + " ][ " + feld[14] + " ][ " + feld[15] + " ]\n";
		
		System.out.println(out);
	}
	
	public boolean istGameOver() {
		// Ist spielzuege groesser gleich 16 -> jedes feld belegt
		if (spielzuege >= 16) {
			// Nicht mehr zuege moeglich
			return true;
		}
		
		//	0	1	2	3
		//	4	5	6	7
		//	8	9	10	11
		//	12	13	14	15
		
		// ----
		for(int i = 0; i <= 12; i+=4) {
			if ((LEER != feld[i]) && (feld[i] == feld[i+1]) && (feld[i+1] == feld[i+2]) && (feld[i+2] == feld[i+3])) return true;
		}
		
		// ||||
		for(int i = 0; i <= 3; i++) {
			if ((LEER != feld[i]) && (feld[i] == feld[i+4]) && (feld[i+4] == feld[i+8]) && (feld[i+8] == feld[i+12])) return true;
		}
				
		// \	/
		if ((LEER != feld[0]) && (feld[0] == feld[5]) && (feld[5] == feld[10]) && (feld[10] == feld[15])) return true;
		if ((LEER != feld[3]) && (feld[3] == feld[6]) && (feld[6] == feld[9]) && (feld[9] == feld[12])) return true;
		
		return false;
	}
	
	
	
	// 'dummer' computer
	public void zugComputer() {
		int eingabe = -1;
		spielzuege++;
		do {
			/* die folgende Anweisung erzeugt eine Pseudo-Zufallszahl zwischen 1 und 9 */
			eingabe = (int)(Math.random() * 16) + 1;
			System.out.println("Computer hat das Feld " + (eingabe) + " gewählt.");
		}
		/* fuer die zufaellig bestimme Feldnummer wird anschliessend geprueft, ob diese nicht
		vielleicht bereits besetzt ist.
		Sonst muss eine neue Zahl ermittelt werden */
		while(eingabe <=16 && eingabe >=1 && !istFrei(eingabe));
		/* das Feld ist noch frei und wird nun markiert */
		setFeld(eingabe, 'O');
		System.out.println("Der Computer hat seinen Zug beendet.");
		/* geaendertes Spielfeld anzeigen */
		ausgeben();
	}

	// 
	public void zugSpieler() {
		int eingabe = -1;
		spielzuege++;
		
		do {
			System.out.println("Waehlen Sie eine gueltige Zahl (1-16)");
			eingabe = Keyboard.readInt() -1;
			System.out.println("Sie waehlten " + (eingabe +1) + ".");
		} while (!istFrei(eingabe));
		setFeld(eingabe, 'X');
		System.out.println("Sie haben Ihren Zug beendet.");
		ausgeben();
		
	}
	
	public void initialisiereSpielfeld() {
		// Mache jedes Feld von feld auf LEER
		for(int i = 0; i <= 15; i++) {
			feld[i] = LEER;
		}
	}

}
