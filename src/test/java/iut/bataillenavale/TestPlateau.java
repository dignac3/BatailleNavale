/**
 * 
 */
package iut.bataillenavale;


/**
 * @author iut
 *
 */
public class TestPlateau {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] longueurs = {2,4,1};
		Plateau p1 = new Plateau("Dodo",10, 3,longueurs);
		Plateau p2 = new Plateau("Gogo",10, 3,longueurs);;
		
		p1.placerBateau(0, 0, true, p1.getBateaux(0));
		p1.placerBateau(1, 0, true, p1.getBateaux(1));
		p1.placerBateau(2, 0, true, p1.getBateaux(2));
		
		p2.placerBateau(3, 0, true, p2.getBateaux(0));
		p2.placerBateau(4, 0, true, p2.getBateaux(1));
		p2.placerBateau(5, 0, true, p2.getBateaux(2));
		
		if (p1.tirer(4, 2)) {
			System.out.println("tir 1 a fonctionné");
		}
		p2.tirer(4, 0);
		
		
		System.out.println(p1);
		System.out.println("\n" + p2);
	}

}
