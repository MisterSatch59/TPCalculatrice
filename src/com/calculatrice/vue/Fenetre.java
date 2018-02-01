package com.calculatrice.vue;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import com.calculatrice.model.Calculatrice;
import com.calculatrice.observer.Observateur;

public class Fenetre extends JFrame implements Observateur {

	private static final long serialVersionUID = 8555776193790451978L;

	private Calculatrice calc;

	private JPanel pan = new JPanel();
		private JPanel pan1 = new JPanel();
			private JLabel label = new JLabel("0");
		private JPanel pan2 = new JPanel();
			private JPanel chiffres = new JPanel();
				private JButton[] bChiffres = new JButton[12];
		private JPanel pan3 = new JPanel();
			private JPanel signes = new JPanel();
				private JButton[] bSignes = new JButton[5];
				
	public Fenetre() {
		this.calc = new Calculatrice();
		this.calc.addObservateur(this);

		initAffichage();
		
		BoutonClicListener listener = new BoutonClicListener(calc);
		for (int i=0;i<12;i++) {
			bChiffres[i].addMouseListener(listener);
		}
		for (int i=0;i<5;i++) {
			bSignes[i].addMouseListener(listener);
		}

		this.setVisible(true);
	}
	
	private void initAffichage() {
		Dimension dFenetre = new Dimension(430, 550);
		Dimension dAffichage = new Dimension(400, 50);
		Font policeAffichage = new Font("Arial", Font.BOLD, 40);
		Dimension dBouton1 = new Dimension(100, 100);
		Dimension dBouton2 = new Dimension(80,80);
		Font policeBouton = new Font("Arial", Font.BOLD, 25);
		
		// On initialise la JFrame
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setSize(dFenetre);
		this.setLocationRelativeTo(null);
		this.setTitle("Calculatrice");
		
		this.getContentPane().add(this.pan);
		pan.setLayout(new BorderLayout());

		pan1.add(label);
		pan.add(pan1, BorderLayout.NORTH);
		pan2.add(chiffres);
		pan.add(pan2, BorderLayout.CENTER);
		pan3.add(signes);
		pan.add(pan3, BorderLayout.EAST);

		// contenu du JPanel pan1
		label.setPreferredSize(dAffichage);
		label.setBorder(BorderFactory.createLineBorder(Color.black));
		
		label.setFont(policeAffichage);
		label.setHorizontalAlignment(JLabel.RIGHT);
		pan1.add(label);

		// contenu du JPanel chiffres
		GridLayout g1 = new GridLayout(4, 3);
		g1.setHgap(10);
		g1.setVgap(10);
		chiffres.setLayout(g1);
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				bChiffres[3 * i + j] = new JButton("" + (7 - 3 * i + j));
				bChiffres[3 * i + j].setPreferredSize(dBouton1);
				bChiffres[3 * i + j].setFont(policeBouton);
				chiffres.add(bChiffres[3 * i + j]);
			}
		}
		bChiffres[9] = new JButton("0");
		bChiffres[9].setPreferredSize(dBouton1);
		bChiffres[9].setFont(policeBouton);
		chiffres.add(bChiffres[9]);
		bChiffres[10] = new JButton(".");
		bChiffres[10].setPreferredSize(dBouton1);
		bChiffres[10].setFont(policeBouton);
		chiffres.add(bChiffres[10]);
		bChiffres[11] = new JButton("=");
		bChiffres[11].setPreferredSize(dBouton1);
		bChiffres[11].setFont(policeBouton);
		chiffres.add(bChiffres[11]);

		// contenu du JPanel signes
		GridLayout g2 = new GridLayout(5, 1);
		g2.setHgap(10);
		g2.setVgap(10);
		signes.setLayout(g2);
		bSignes[0] = new JButton("C");
		bSignes[0].setForeground(Color.RED);
		bSignes[1] = new JButton("/");
		bSignes[2] = new JButton("X");
		bSignes[3] = new JButton("-");
		bSignes[4] = new JButton("+");
		for (int i = 0; i < 5; i++) {
			bSignes[i].setPreferredSize(dBouton2);
			bSignes[i].setFont(policeBouton);
			signes.add(bSignes[i]);
		}
	}

	
	
	public void update(String affichage) {
		label.setText(affichage);
	}

}
