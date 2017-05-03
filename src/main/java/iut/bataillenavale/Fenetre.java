/**
 * 
 */
package iut.bataillenavale;

import java.awt.GraphicsConfiguration;
import java.awt.HeadlessException;

import javax.swing.JFrame;

/**
 * @author doria
 *
 */
public class Fenetre extends JFrame {

	public Fenetre(){
		this.setTitle("Bataille Navale");
		this.setSize(1600, 900);
		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().add(new Panel());
		this.setVisible(true);
	}
	
	public static void main(String[] args){
		
		new Fenetre();
	}
}
