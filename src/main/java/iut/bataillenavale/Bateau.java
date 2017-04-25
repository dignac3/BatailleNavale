/**
 * 
 */
package iut.bataillenavale;

/**
 * @author iut
 *
 */
public class Bateau {
	private String nom;
	private final int longueur;
	private boolean estCoule;
	private int vie ;
	
	public Bateau(int longueur){
		this.longueur=longueur;
		this.setVie(longueur);
		setEstCoule(false);
		this.setNom("");
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

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		if (longueur != 0) {
			int coule = 0;
			if (estCoule) {
				coule  = 1;
			} else {
				coule = 0;
			}
			return ("[" + longueur + "," + coule + "," + vie + "]");
		}
		return null;
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}
}
