/**
 * 
 */
package iut.bataillenavale;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * @author doria
 *
 */
@SuppressWarnings("serial")
public class Panel extends JPanel {
	
	//Variables lancement de partie
	private int tailleplat = 10;
	int taille_petitplat;
	private String nom_j1;
	private String nom_j2;
	private int nbbateaux = 0;
	private ArrayList<Integer> longueursbateaux = new ArrayList<Integer>();
	private int[] longueurs;

	
	//variables demarrer
	private JButton jb_demarrer = new JButton("Jouer à la Bataille Navale !");
	ImageIcon img = new ImageIcon("fond-depart.jpg");
	
	
	//variables parametres

	private JPanel jp_param = new JPanel(new GridBagLayout());
	private JLabel jl_titre = new JLabel("Paramètres");
	private JLabel jl_j1 = new JLabel("Joueur 1 : ");
	private JLabel jl_j2 = new JLabel("Joueur 2 : ");
	private JLabel jl_taillebateau = new JLabel("Taille : ");
	private String[] tb ={"2","3","4","5"}; 
	private JComboBox<String> jcb_taillebateau = new JComboBox<>(tb);
	private JLabel jl_nbbateau = new JLabel("Nombre bateau(x) : "+ nbbateaux);
	private JLabel jl_tailleplat = new JLabel("Taille du plateau : " + tailleplat);
	private JButton jb_addbateau = new JButton("Ajouter un bateau");
	private JButton jb_delbateau = new JButton("Supprimer le dernier bateau");
	private JButton jb_lancer = new JButton("Lancer la partie !");
	private JTextField jtf_j1 = new JTextField(15);
	private JTextField jtf_j2 = new JTextField(15);
	private JSlider js_tailleplat = new JSlider(5, 15, 10);
	private Color bleu_trsp = new Color(76,45, 197, 50);
	private Color bleu = new Color(76,45,197);

	//Panel Demarrer
	public Panel(){
		//Border layout
		
		this.setLayout(new GridBagLayout());
		
		//Affichage Bouton
		jb_demarrer.setFont(new Font(null, 0, 50));
		jb_demarrer.setBackground(bleu_trsp);
		jb_demarrer.setForeground(Color.white);
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
		this.revalidate();
		this.removeAll();
		repaint();
		this.setLayout(new GridBagLayout());
		
		//Definition JPanel
		//jp_param.setPreferredSize(new Dimension(700, 700));
		GridBagConstraints c = new GridBagConstraints();
		
		//Placement éléments
		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 10, 0);
		jl_titre.setFont(new Font(null, 0, 20));
		jp_param.add(jl_titre,c);
		
		c.gridx = 0;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 30, 0);
		jp_param.add(jl_j1,c);
		
		c.gridx = 1;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 0, 25);
		jp_param.add(jtf_j1,c);
		
		c.gridx = 3;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0,0 , 0);
		jp_param.add(jl_j2,c);
		
		c.gridx = 4;
		c.gridy = 1;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		jp_param.add(jtf_j2,c);
		
		c.gridx = 0;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 2;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 5, 0);
		jp_param.add(jb_addbateau,c);
		
		c.gridx = 4;
		c.gridy = 2;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		
		jp_param.add(jl_nbbateau,c);
		
		c.gridx = 0;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE_TRAILING;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 40, 0);
		jp_param.add(jl_taillebateau,c);

		c.gridx = 1;
		c.gridy = 3;
		c.gridheight = 1;
		c.gridwidth = 1;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		jp_param.add(jcb_taillebateau,c);
		
		
		c.gridx = 0;
		c.gridy = 4;
		c.gridheight = 1;
		c.gridwidth = 3;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE_LEADING;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 20, 0);
		jp_param.add(jb_delbateau,c);
		jb_delbateau.setEnabled(false);
		
		c.gridx = 0;
		c.gridy = 5;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 5, 0);
		jp_param.add(jl_tailleplat,c);
		
		c.gridx = 0;
		c.gridy = 6;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE;
		c.fill = GridBagConstraints.NONE;
		c.ipadx = 0;
		c.ipady = 0;
		c.insets = new Insets(0, 0, 5, 0);
		jp_param.add(js_tailleplat,c);
		
		c.gridx = 0;
		c.gridy = 7;
		c.gridheight = 1;
		c.gridwidth = GridBagConstraints.REMAINDER;
		c.weightx = 1;
		c.weighty = 1;
		c.anchor = GridBagConstraints.BASELINE;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 0;
		c.ipady = 0;
		jp_param.add(jb_lancer,c);
		
		
		Border border = BorderFactory.createEmptyBorder(10, 20, 20, 20);
		jp_param.setBorder(border );
		this.add(jp_param);
		
		
		//Action Listener
		
		js_tailleplat.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				tailleplat = js_tailleplat.getValue();
				jl_tailleplat.setText("Taille du plateau : " + tailleplat);
				if (nbbateaux >= tailleplat - 1) {
					nbbateaux = tailleplat - 1;
					jl_nbbateau.setText("Nombre bateau(x) : "+ nbbateaux);
					jb_addbateau.setEnabled(false);
				}
				else {
					jb_addbateau.setEnabled(true);
				}
			}
		});
		
		
		jb_addbateau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				longueursbateaux.add(nbbateaux,(Integer)(jcb_taillebateau.getSelectedIndex()+2));
				nbbateaux += 1;
				jb_delbateau.setEnabled(true);
				jl_nbbateau.setText("Nombre bateau(x) : "+ nbbateaux);
				if (nbbateaux >=tailleplat - 1) {
					jb_addbateau.setEnabled(false);
				}
			}
		});
		
		jb_delbateau.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				nbbateaux -= 1;
				jl_nbbateau.setText("Nombre bateau(x) : "+ nbbateaux);
				if (nbbateaux <= 0) {
					jb_delbateau.setEnabled(false);
				}
				if (nbbateaux <=tailleplat - 1) {
					jb_addbateau.setEnabled(true);
				}
			}
		});
		
		jb_lancer.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				longueurs = new int[nbbateaux];
				for (int i = 0; i < nbbateaux; i++) {
					longueurs[i] = longueursbateaux.get(i);
					System.out.println(longueurs[i]);
				}
				nom_j1 = jtf_j1.getText();
				nom_j2 = jtf_j2.getText();
				if (nom_j1.length() <= 0) {
					JOptionPane.showMessageDialog(jp_param, "Le joeueur 1 n'a pas de nom" , "Champs manquant", JOptionPane.WARNING_MESSAGE);
				}
				else if (nom_j2.length() <= 0) {
					JOptionPane.showMessageDialog(jp_param, "Le joeueur 2 n'a pas de nom" , "Champs manquant", JOptionPane.WARNING_MESSAGE);
				}
				else if (nbbateaux <=0) {
					JOptionPane.showMessageDialog(jp_param, "Vous n'avez pas ajouté de bateau","Pas de bateau",JOptionPane.WARNING_MESSAGE);
				}else {
					//Ajout 1 à taille de la grille pour numérotation
					tailleplat += 1;
					partie();
				}
				//longueurs : ok
				//nbbateaux : ok
				//tailleplat : ok
				//j1 : ok
				//j2 : ok
			}
		});
	}
	
	
	

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
	private JButton[][] jb_case = new JButton[100][100];
	private JButton[][] jb_case_petit = new JButton[100][100];
	Bateau bateau_choisi;
	
	public void partie(){
		this.revalidate();
		this.removeAll();
		repaint();
		
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
		gc_ouest.gridy = 0;
		gc_ouest.anchor = GridBagConstraints.LINE_START;
		jp_ouest.add(jl_information,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 1;
		gc_ouest.insets=new Insets(15, 0, 0, 0);
		jp_ouest.add(jl_joueur1,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 2;
		jp_ouest.add(jl_porteav,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 3;
		jp_ouest.add(jl_croiseur,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 4;
		jp_ouest.add(jl_destr,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 5;
		jp_ouest.add(jl_ssmarin,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 6;
		jp_ouest.add(jl_joueur2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 7;
		jp_ouest.add(jl_porteav2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 8;
		jp_ouest.add(jl_croiseur2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 9;
		jp_ouest.add(jl_destr2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 10;
		jp_ouest.add(jl_ssmarin2,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 11;
		jp_ouest.add(jl_ligne,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 12;
		jp_ouest.add(jl_placez,gc_ouest);
		gc_ouest.gridx = 0;
		gc_ouest.gridy = 13;
		gc_ouest.insets=new Insets(20, 0, 0, 0);
		JPanel jp_plateau_bat = new JPanel(new GridBagLayout());
		GridBagConstraints gc_plateau_bat = new GridBagConstraints();
		taille_petitplat = tailleplat - 1;
		for (int i = 0; i < taille_petitplat; i++) {
			for (int j = 0; j < taille_petitplat; j++) {
				jb_case_petit[i][j] = new JButton(Integer.toString(i) +" "+ Integer.toString(j));
				jb_case_petit[i][j].setBackground(bleu);
				jb_case_petit[i][j].setPreferredSize(new Dimension(40,40));
				jb_case_petit[i][j].setMinimumSize(new Dimension(20,20));
				gc_plateau_bat.gridx = i;
				gc_plateau_bat.gridy = j;
				jp_plateau_bat.setBackground(new Color(255, 255, 255, 175));
				jp_plateau_bat.add(jb_case_petit[i][j],gc_plateau_bat);
				
				
				
			}
			
			jp_ouest.setBackground(new Color(255, 255, 255, 175));
			jp_ouest.add(jp_plateau_bat,gc_ouest);
			this.add(jp_ouest,BorderLayout.WEST);
			JPanel jp_plateau = new JPanel(new GridBagLayout());
			jp_plateau.setBackground(new Color(255, 255, 255, 175));
			
			plateau(jp_plateau,1); 
			this.add(jp_plateau,BorderLayout.CENTER);
			jp_plateau.setBorder(BorderFactory.createLoweredSoftBevelBorder());
			jp_ouest.setBorder(BorderFactory.createLoweredSoftBevelBorder()); 
		}
		/* ---------------- Fin affichage -----------------*/
		
		Plateau p1 = new Plateau(nom_j1, tailleplat, nbbateaux, longueurs);
		Plateau p2 = new Plateau(nom_j2, tailleplat, nbbateaux, longueurs);
		placerBateaux(p1);
		
		
		
		
		
	}

	public void PlacerBateaux2(Plateau p){
		Plateau p2 = new Plateau(null, taille_petitplat, nbbateaux, longueurs);
		for (int i = 0; i < nbbateaux; i++) {
			
		}
		
	}
		public void placerBateaux(Plateau p){
			//Variables
			
			//Placement bateaux premiere table
			Plateau p1 = new Plateau("placeur bateau", taille_petitplat +1, nbbateaux, longueurs);
			for (int i = 0; i < nbbateaux; i+=2) {				
					p1.placerBateau(i, 0, true, p.getBateaux(i));
			}
			System.out.println(p1);
			for (int i = 0; i < taille_petitplat + 1 ; i++) {
				for (int j = 0; j < taille_petitplat + 1; j++) {
					if (p1.getCase(i, j).isEstOccupe()) {
						jb_case_petit[i][j].setBackground(Color.BLACK);
						
						
						jb_case_petit[i][j].setLocation(i, 0);
						Point pos_bateau = jb_case_petit[i][j].getLocation();
						 
						
						jb_case_petit[i][j].addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								 bateau_choisi = p1.getCase((int)pos_bateau.getX(),(int)pos_bateau.getY()).getEstOccupePar();
								
							}
						});
					}
				}
			}
			
			for (int i = 1; i < tailleplat ; i++) {
				for (int j = 1; j < tailleplat ; j++) {
					jb_case[i][j].setLocation(i, j);
					Point position = jb_case[i][j].getLocation();
					jb_case[i][j].addActionListener(new ActionListener() {
						
						public void actionPerformed(ActionEvent e) {
							
							if (bateau_choisi != null) {
								boolean autorisation = true;
								if (p.getCase((int) position.getX(), (int) position.getY()).isEstOccupe()) {
									autorisation = false;
								}
								if (autorisation) {
									p.placerBateau((int) position.getX(), (int) position.getY(), true, bateau_choisi);
									for (int k = 0; k < bateau_choisi.getLongueur(); k++) {
										jb_case[(int) position.getX()+k][(int) position.getY()].setBackground(Color.BLACK);
									}
									
								} 
							}
						}
					});
				}
			

		}	
		


	


	/* ---------------------------------------------------METHODE------------------------------------------------------ */


		
	}
	


	/**
	 * 
	 */
	public void plateau(JPanel jp_plateau,int idJoueur) {
		/* GRIDBAGCONSTRAINT */
		GridBagConstraints gc_plateau = new GridBagConstraints();
		
		for (int i = 0; i < tailleplat; i++) {
			

			for (int j = 0; j < tailleplat; j++) {
				
				jb_case[i][j] = new JButton("");
				jb_case[i][j].setBackground(bleu);
				gc_plateau.gridx = i;
				gc_plateau.gridy = j;
				jb_case[i][j].setPreferredSize(new Dimension(50, 50));
				
				jp_plateau.add(jb_case[i][j],gc_plateau);
			}
		}
	}


	
	
	/* --------------------------------------------------------------------------------------------------------- */
	
	

	/**
	 * @param i
	 * @param j
	 */
	
		
			
		
	
	/**
	 * @return the jb_case
	 */
	public JButton[][] getJb_case() {
		return jb_case;
	}
	/**
	 * @param jb_case the jb_case to set
	 */
	public void setJb_case(JButton[][] jb_case) {
		this.jb_case = jb_case;
	}
	/**
	 * @return the jb_case_petit
	 */
	public JButton[][] getJb_case_petit() {
		return jb_case_petit;
	}
	/**
	 * @param jb_case_petit the jb_case_petit to set
	 */
	public void setJb_case_petit(JButton[][] jb_case_petit) {
		this.jb_case_petit = jb_case_petit;
	}
	
}

