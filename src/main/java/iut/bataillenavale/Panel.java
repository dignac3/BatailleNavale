/**
 * 
 */
package iut.bataillenavale;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;

/**
 * @author doria
 *
 */
@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	//variables demarrer
	private JButton jb_demarrer = new JButton("Jouer à la Bataille Navale !");
	ImageIcon img = new ImageIcon("fond-depart.jpg");
	
	
	//variables parametres
	JLabel jl_titre = new JLabel("<html><p>Paramètres\n</p></html>");
	JLabel jl_j1 = new JLabel("Joueur 1 : ");
	JLabel jl_j2 = new JLabel("Joueur 2 : ");
	JLabel jl_delbateau = new JLabel("Supprimer le dernier bateau");
	JLabel jl_nbbateau = new JLabel("Nombre bateau(x) : 0)");
	JLabel jl_tailleplat = new JLabel("Taille du plateau : 10");
	JButton jb_addbateau = new JButton("Ajouter un bateau");
	JButton jb_taillebateau = new JButton("Taille : ");
	JButton jb_lancer = new JButton("Lancer la partie !");
	JTextField jtf_j1 = new JTextField();
	JTextField jtf_j2 = new JTextField();
	JSlider js_tailleplat = new JSlider(5, 50, 10);
	
	
	//Panel Demarrer
	public Panel(){
		//Border layout
		
		this.setLayout(new GridBagLayout());
		
		//Affichage Bouton
		jb_demarrer.setFont(new Font(null, 0, 50));
		jb_demarrer.setBackground(new Color(76,45, 197, 50));
		jb_demarrer.setForeground(new Color(255, 255, 255));
		Border border=BorderFactory.createLineBorder(new Color(0), 3, true);
		jb_demarrer.setBorder(border);
		this.add(jb_demarrer);
		
		
		jb_demarrer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				parametres();
			}
		});
	}
	//dessin image fond
	public void paintComponent(Graphics g){
	    super.paintComponents(g);
	    g.drawImage(img.getImage(), 0, 0, null);
	}      
         
	public void parametres(){
		
		//parametrage nouvelle fenetre
		repaint();
		this.removeAll();
		this.setLayout(new GridBagLayout());
		
		this.add(jl_titre, new GridBagConstraints());
	}
}
