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
	private final int nbBateaux;
	private final Case[][] cases;
	private final Bateau[] bateaux;
	
	public Plateau(int cote,int nbBateaux, int[] longueurs){
		this.cote=cote;
		this.nbBateaux = nbBateaux;
		bateaux = new Bateau[nbBateaux];
		cases = new Case[cote][cote];
		for (int i = 0; i < nbBateaux; i++) {
			bateaux[i] = new Bateau(longueurs[i]);
		}
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases.length; j++) {
				cases[i][j] = new Case();
			}
		}
	}
	
	public void placerBateau(int x, int y, boolean horizontal, Bateau bateau){
		if (horizontal) {
			for (int i = 0; i < bateau.getLongueur(); i++) {
				cases[x][y+i].setEstOccupePar(bateau);
				cases[x][y+i].setEstOccupe(true);
			}
		}
		else {
			for (int i = 0; i < bateau.getLongueur(); i++) {
				cases[x-i][y].setEstOccupePar(bateau);
				cases[x-i][y].setEstOccupe(true);
			}
		}
	}
	
	public boolean tirer(int x, int y){
		if (cases[x][y].isEstTouche()) {
			return false;
		}
		else {
			cases[x][y].setEstTouche(true);
			if (cases[x][y].isEstOccupe()) {
				cases[x][y].getEstOccupePar().perteVie(cases[x][y].getEstOccupePar().getVie());
				if (cases[x][y].getEstOccupePar().getVie() == 0) {
					cases[x][y].getEstOccupePar().setEstCoule(true);
				}
			}
			return true;
		}
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String result = "";
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases.length; j++) {
				result += (String)("("+cases[i][j].isEstTouche() + ", " + cases[i][j].isEstOccupe() + ", " + cases[i][j].getEstOccupePar() + ")  ");
			}
			result += "\n\n";
		}
		
		return result;
		
	}
	
	
}