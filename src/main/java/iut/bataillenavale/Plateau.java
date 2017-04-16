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
				cases[i][j] = new Case(i,j);
				
				
			}
		}

	
	}

	public int getCote() {
		return cote;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		
		for (int i = 0; i < cases.length; i++) {
			"c"+cases
		}
		return "Plateau [cote=" + cote + ", cases=" + Arrays.toString(cases) + "]";
	}
	
	
}

