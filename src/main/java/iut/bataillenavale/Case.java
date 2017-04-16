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
	
	
	public Case() {
		super();
		this.estTouche = false;
	}
	
	/**
	 * @return the estTouche
	 */
	public boolean getEstTouche() {
		return estTouche;
	}
	@Override
	public String toString() {
		return "Case [estTouche=" + estTouche + "]";
	}

	/**
	 * @param estTouche the estTouche to set
	 */
	public void setEstTouche(boolean estTouche) {
		this.estTouche = estTouche;
	}
	
	
}
