/**
 * 
 */
package iut.bataillenavale;

import java.util.Arrays;

/**
 * @author iut
 *
 */
public class Plateau {
	private final int cote;
	private Case[][] cases;
	
	public Plateau(int cote){
		this.cote=cote;
		cases = new Case[cote][cote];
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases.length; j++) {
				cases[i][j] = new Case();
				
				
			}
		}

	
	}

	@Override
	public String toString() {
		return "Plateau [cote=" + cote + ", cases=" + Arrays.toString(cases) + "]";
	}

	public int getCote() {
		return cote;
	}
	
	public void tir (int x, int y){
		if (!cases[x][y].getEstTouche()) {
			cases[x][y].setEstTouche(true);
		}
	}
}

