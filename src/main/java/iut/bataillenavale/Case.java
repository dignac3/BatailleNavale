/**
 * 
 */
package iut.bataillenavale;

/**
 * @author iut
 *
 */
public class Case {
	private boolean estTouche;
	private boolean estOccupe;
	private Bateau estOccupePar;
	
	public Case() {
		super();
		this.setEstTouche(false);
		this.setEstOccupe(false);
		this.setEstOccupePar(null);
	}

	/**
	 * @return the estOccupePar
	 */
	public Bateau getEstOccupePar() {
		return estOccupePar;
	}

	/**
	 * @param estOccupePar the estOccupePar to set
	 */
	public void setEstOccupePar(Bateau estOccupePar) {
		this.estOccupePar = estOccupePar;
	}

	/**
	 * @return the estOccupe
	 */
	public boolean isEstOccupe() {
		return estOccupe;
	}

	/**
	 * @param estOccupe the estOccupe to set
	 */
	public void setEstOccupe(boolean estOccupe) {
		this.estOccupe = estOccupe;
	}

	/**
	 * @return the estTouche
	 */
	public boolean isEstTouche() {
		return estTouche;
	}

	/**
	 * @param estTouche the estTouche to set
	 */
	public void setEstTouche(boolean estTouche) {
		this.estTouche = estTouche;
	}

}
