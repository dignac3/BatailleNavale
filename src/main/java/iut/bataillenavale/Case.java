/**
 * 
 */
package iut.bataillenavale;

/**
 * @author iut
 *
 */
public class Case {
	
	private int x;
	private int y;
	private boolean estTouche;
	
	
	public Case(int x, int y) {
		super();
		this.x = x;
		this.y = y;
		this.estTouche = false;
	}
	/**
	 * @return the x
	 */
	public int getx() {
		return x;
	}
	/**
	 * @param x the x to set
	 */
	public void setx(int x) {
		this.x = x;
	}
	/**
	 * @return the y
	 */
	public int gety() {
		return y;
	}
	/**
	 * @param y the y to set
	 */
	public void sety(int y) {
		this.y = y;
	}
	
	/**
	 * 
	 * @param x
	 * @param y
	 */
	public void setXY(int x,int y){
		this.x = x;
		this.y = y;
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
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "["+ x + ", " + y + "]";
	}
	
	
	
}
