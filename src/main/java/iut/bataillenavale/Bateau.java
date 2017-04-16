/**
 * 
 */
package iut.bataillenavale;

/**
 * @author iut
 *
 */
public class Bateau {
	private int x;
	private int y;
	private final int longueur;
	private boolean estCoule;
	
	public Bateau(int x, int y, int longueur){
		this.longueur=longueur;
		this.x = x;
		this.y = y;
		estCoule = false;
	}

	/**
	 * @return the longueur
	 */
	public int getLongueur() {
		return longueur;
	}

	/**
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * @param x the x to set
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * @param y the y to set
	 */
	public void setY(int y) {
		this.y = y;
	}
}
