/**
 * 
 */
package iut.bataillenavale;


import javax.swing.JFrame;

/**
 * @author doria
 *
 */
@SuppressWarnings("serial")
public class Fenetre extends JFrame {

	public Fenetre(){
		this.setTitle("Bataille Navale");
		this.setSize(1600, 900);
		this.setResizable(false);
		this.setContentPane(new Panel());
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		
		new Fenetre();
	}
}
