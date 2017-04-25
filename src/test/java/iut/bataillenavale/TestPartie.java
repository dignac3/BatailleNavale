/**
 * 
 */
package iut.bataillenavale;

/**
 * @author doria
 *
 */
public class TestPartie {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] longueurs = {1,4};
		Plateau p1 = new Plateau("Dodo", 10, longueurs.length, longueurs);
		
		p1.placerBateau(0, 1, true, p1.getBateaux(0));
		p1.placerBateau(4, 0, false, p1.getBateaux(1));

		p1.tirer(0, 1);
		p1.tirer(4, 0);
		p1.tirer(5, 0);
		p1.tirer(6, 0);
		System.out.println(p1);
		System.out.println("bateau 1 mort: " + p1.getBateaux(0).isEstCoule());
		System.out.println("bateau 2 mort: " + p1.getBateaux(1).isEstCoule());
		System.out.println("p1 a perdu :" + p1.aPerdu());
		System.out.println("Tir derniere case bateau :");
		p1.tirer(7, 0);
		System.out.println("bateau 1 mort: " + p1.getBateaux(0).isEstCoule());
		System.out.println("bateau 2 mort: " + p1.getBateaux(1).isEstCoule());
		System.out.println("p1 a perdu :" + p1.aPerdu());

		System.out.println(p1);
	}

}
