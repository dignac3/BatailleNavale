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
import java.awt.GridLayout;
import java.awt.Insets;
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
	private String nom_j1;
	private String nom_j2;
	private int nbbateaux = 0;
	private ArrayList<Integer> longueursbateaux = new ArrayList<Integer>();
	private Integer[] longueurs;

	
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
	private JSlider js_tailleplat = new JSlider(5, 30, 10);
	
	

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
				longueurs = new Integer[nbbateaux];
				longueurs = longueursbateaux.toArray(longueurs);
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
	
	public void partie(){
		this.revalidate();
		this.removeAll();
		repaint();
	}
	
}
