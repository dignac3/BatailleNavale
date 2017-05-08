/**
 * 
 */
package iut.bataillenavale;

/**
 * @author iut
 *
 */
public class Plateau {
	private final int cote;
	private final int nb_bateaux;
	private final Case[][] cases;
	private final Bateau[] bateaux;
	private final String nom;
	private int score;
	
	public Plateau(String nom ,int cote,int nb_bateaux, int[] longueurs){
		this.nom = nom;
		this.setScore(0);
		this.cote=cote;
		this.nb_bateaux = nb_bateaux;
		bateaux = new Bateau[nb_bateaux];
		cases = new Case[cote][cote];
		String nom_bateau;
		for (int i = 0; i < nb_bateaux; i++) {
			switch (longueurs[i]) {
			case 2:
				nom_bateau = "Sous-Marin";
				break;
			case 3:
				nom_bateau = "Destroyer";
				break;
			case 4:
				nom_bateau = "Croiseur";
				break;
			case 5:
				nom_bateau = "Porte-Avion";
				break;
			default:
				nom_bateau = null;
				break;
			}
			bateaux[i] = new Bateau(longueurs[i], nom_bateau);
		}
		for (int i = 0; i < cases.length; i++) {
			for (int j = 0; j < cases.length; j++) {
				cases[i][j] = new Case();
			}
		}
	}
	
	public void placerBateau(int x, int y, boolean horizontal, Bateau bateau){
		
			if (horizontal) {
				System.out.println(bateau.getLongueur());
				for (int i = 0; i < bateau.getLongueur(); i++) {
					cases[x][y+i].setEstOccupePar(bateau);
					cases[x][y+i].setEstOccupe(true);
				}
			}
			/*else {
				for (int i = 0; i < bateau.getLongueur(); i++) {
					cases[x+i][y].setEstOccupePar(bateau);
					cases[x+i][y].setEstOccupe(true);
				}
			}*/
	}
	
	
	
	public boolean tirer(int x, int y){
		if (cases[x][y].isEstTouche()) {
			return false;
		}
		else {
			cases[x][y].setEstTouche(true);
			if (cases[x][y].isEstOccupe()) {
				cases[x][y].getEstOccupePar().setVie(cases[x][y].getEstOccupePar().getVie() -1);
				if (cases[x][y].getEstOccupePar().getVie() <= 0) {
					cases[x][y].getEstOccupePar().setEstCoule(true);
					this.setScore(this.getScore() + cases[x][y].getEstOccupePar().getLongueur()*100);
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
				int touche = 0;
				int occupe = 0;
				if (cases[i][j].isEstTouche()) {
					touche = 1;
				}
				else {
					occupe = 0;
				}
				if (cases[i][j].isEstOccupe()) {
					occupe = 1;
				}
				else {
					occupe = 0;
				}
				result += ("("+touche + ", " + occupe + ", " + cases[i][j].getEstOccupePar() + ")  ");
			}
			result += "\n";
		}
		
		return result;
		
	}

	/**
	 * @return the nb_bateaux
	 */
	public int getnb_bateaux() {
		return nb_bateaux;
	}

	/**
	 * @return the cote
	 */
	public int getCote() {
		return cote;
	}
	
	public Case getCase(int x,int y){
		return cases[x][y];
	}
	
	public Case[][] getCases(){
		return cases;
	}
	
	public Bateau getBateaux(int i){
		return bateaux[i];
	}
	
	public boolean aPerdu(){
		boolean result = true;
		for (int i = 0; i < bateaux.length; i++) {
			if (!bateaux[i].isEstCoule()) {
				result = false;
			}
		}
		return result;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
}