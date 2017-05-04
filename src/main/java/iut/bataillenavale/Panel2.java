/**
 * 
 */
package iut.bataillenavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.TransferHandler;

/**
 * @author Younes
 *
 */
public class Panel2 extends JPanel{
	private static final int MAX = 11;
	private JLabel jl_information = new JLabel("Information sur les joueurs :                                                ");
	private JLabel jl_ligne = new JLabel("_________________________________________________________________________________");
	private JLabel jl_joueur1 = new JLabel("Joueur 1 : ");
	private JLabel jl_porteav = new JLabel("  - Nombre de porte-avions : 1 ");
	private JLabel jl_croiseur = new JLabel("  - Nombre de croiseurs : 1 ");
	private JLabel jl_destr = new JLabel("  - Nombre de destroyers : 1 ");
	private JLabel jl_ssmarin = new JLabel("  - Nombre de sous-marins : 1 ");
	private JLabel jl_porteav2 = new JLabel("  - Nombre de porte-avions : 1 ");
	private JLabel jl_croiseur2 = new JLabel("  - Nombre de croiseurs : 1 ");
	private JLabel jl_destr2 = new JLabel("  - Nombre de destroyers : 1 ");
	private JLabel jl_ssmarin2 = new JLabel("  - Nombre de sous-marins : 1 ");
	private JLabel jl_joueur2 = new JLabel("Joueur 2 :");
	private JLabel jl_placez = new JLabel("Placez vos bateaux :");
	private JButton[][] jb_case = new JButton[1000][1000];
	
	
	@SuppressWarnings("unused")
	public Panel2(){
		
		this.setLayout(new BorderLayout());
		Font titre = new Font("Arial",Font.BOLD,20);
		Font ss_titre = new Font("Arial",Font.BOLD,15);
		JPanel jp_ouest = new JPanel(new GridBagLayout());
		
		GridBagConstraints gc_ouest = new GridBagConstraints();
		gc_ouest.fill = GridBagConstraints.HORIZONTAL;
		jl_information.setFont(titre);
		jl_placez.setFont(titre);
		jl_joueur1.setFont(ss_titre);
		jl_joueur2.setFont(ss_titre);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 1;
		jp_ouest.add(jl_information,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 2;
		gc_ouest.insets=new Insets(15, 0, 0, 0);
		jp_ouest.add(jl_joueur1,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 3;
		jp_ouest.add(jl_porteav,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 4;
		jp_ouest.add(jl_croiseur,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 5;
		jp_ouest.add(jl_destr,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 6;
		jp_ouest.add(jl_ssmarin,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 7;
		jp_ouest.add(jl_joueur2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 8;
		jp_ouest.add(jl_porteav2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 9;
		jp_ouest.add(jl_croiseur2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 10;
		jp_ouest.add(jl_destr2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 11;
		jp_ouest.add(jl_ssmarin2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 12;
		jp_ouest.add(jl_ligne,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 13;
		jp_ouest.add(jl_placez,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 14;
		
		gc_ouest.insets=new Insets(50, 0, 0, 0);
		JPanel jp_plateau_bat = new JPanel(new GridBagLayout());
		GridBagConstraints gc_plateau_bat = new GridBagConstraints();
		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 8; j++) {
				jb_case[i][j] = new JButton("");
				jb_case[i][j].setBackground(new Color(100, 100, 100));
				jb_case[i][j].setPreferredSize(new Dimension(40, 40));
				gc_plateau_bat.gridx = i;
				gc_plateau_bat.gridy = j;
				jp_plateau_bat.add(jb_case[i][j],gc_plateau_bat);
				
		}
		
		jp_ouest.add(jp_plateau_bat,gc_ouest);
		
		this.add(jp_ouest,BorderLayout.WEST);
		JPanel jp_plateau = new JPanel(new GridBagLayout());
		plateau(jp_plateau,1); 
		this.add(jp_plateau,BorderLayout.CENTER);
		jp_plateau.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		jp_ouest.setBorder(BorderFactory.createLoweredSoftBevelBorder()); 
		}
		
	}





	


	/* ---------------------------------------------------METHODE------------------------------------------------------ */

	
	
	
	
	
	
	
	
	


	/**
	 * 
	 */
	@SuppressWarnings("unused")
	public void plateau(JPanel jp_plateau,int idJoueur) {
		/* GRIDBAGCONSTRAINT */
		GridBagConstraints gc_plateau = new GridBagConstraints();
		
		for (int i = 0; i < MAX; i++) {
			

			for (int j = 0; j < MAX; j++) {
				
				if(MAX>=13 && MAX<15){
					coordonnéeCouleur(i, j);
					gc_plateau.gridx = i+1;
					gc_plateau.gridy = j+1;
					jb_case[i][j].setPreferredSize(new Dimension(60, 60));
					jp_plateau.add(jb_case[i][j],gc_plateau);
				}
				else if(MAX>=15 && MAX<18){
					coordonnéeCouleur(i, j);
					gc_plateau.gridx = i+1;
					gc_plateau.gridy = j+1;
					jb_case[i][j].setPreferredSize(new Dimension(50, 50));
					jp_plateau.add(jb_case[i][j],gc_plateau);
				}
				else if (MAX>=18 && MAX<22){
					coordonnéeCouleur(i, j);
					gc_plateau.gridx = i+1;
					gc_plateau.gridy = j+1;
					jb_case[i][j].setPreferredSize(new Dimension(40, 40));
					jp_plateau.add(jb_case[i][j],gc_plateau);
					
				}
				else if (MAX>=22 && MAX<25){
					coordonnéeCouleur(i, j);
					gc_plateau.gridx = i+1;
					gc_plateau.gridy = j+1;
					jb_case[i][j].setPreferredSize(new Dimension(35, 35));
					jp_plateau.add(jb_case[i][j],gc_plateau);
				}
				else if (MAX>=25){
					coordonnéeCouleur(i, j);
					gc_plateau.gridx = i+1;
					gc_plateau.gridy = j+1;
					jb_case[i][j].setPreferredSize(new Dimension(33, 33));
					jp_plateau.add(jb_case[i][j],gc_plateau);
				}
				else{
					coordonnéeCouleur(i, j);
				gc_plateau.gridx = i+1;
				gc_plateau.gridy = j+1;
				jb_case[i][j].setPreferredSize(new Dimension(70, 70));
				jp_plateau.add(jb_case[i][j],gc_plateau);
				}
			}
		}
		
	}

	
	
	
	/* --------------------------------------------------------------------------------------------------------- */
	
	

	/**
	 * @param i
	 * @param j
	 */
	private void coordonnéeCouleur(int i, int j) {
		if (j == 0 ) {
			jb_case[i][j] = new JButton(Integer.toString(i));
			jb_case[i][j].setBackground(new Color(255, 255, 255));
			jb_case[i][j].setEnabled(false);
			
		}
		else if (i == 0) {
			jb_case[i][j] = new JButton(Integer.toString(j));
			jb_case[i][j].setEnabled(false);
			jb_case[i][j].setBackground(new Color(255, 255, 255));
		
			
		}
		else {
			jb_case[i][j] = new JButton("");
			jb_case[i][j].setBackground(new Color(100, 100, 100));
		}
	}
	
}
