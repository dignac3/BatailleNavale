/**
 * 
 */
package iut.bataillenavale;

/**
 * @author iut
 *
 */
public class Bateau {
	private final int longueur;
	private boolean estCoule;
	private int vie ;
	
	public Bateau(int longueur){
		this.longueur=longueur;
		this.setVie(longueur);
		setEstCoule(false);
	}

	/**
	 * @return the longueur
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * @return the vie
	 */
	public int getVie() {
		return vie;
	}

	/**
	 * @param vie the vie to set
	 */
	public void setVie(int vie) {
		this.vie = vie;
	}
	
	public void perteVie(int vie){
		this.vie = vie-1;
	}

	/**
	 * @return the estCoule
	 */
	public boolean isEstCoule() {
		return estCoule;
	}

	/**
	 * @param estCoule the estCoule to set
	 */
	public void setEstCoule(boolean estCoule) {
		this.estCoule = estCoule;
	}
}
