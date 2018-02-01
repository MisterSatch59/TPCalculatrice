package com.calculatrice.vue;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;

import com.calculatrice.model.Calculatrice;
import com.calculatrice.model.Signe;

public class BoutonClicListener implements MouseListener {

	Calculatrice calc;

	public BoutonClicListener(Calculatrice calc) {
		this.calc = calc;
	}

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource().getClass() == JButton.class) {
			String textBouton = ((JButton) (e.getSource())).getText();

			try {
				calc.chiffre(Integer.valueOf(textBouton));
			} catch (NumberFormatException ex) {
				switch (textBouton) {
				case ".":
					calc.point();
					break;
				case "=":
					calc.egal();
					break;
				case "+":
					calc.calcul(Signe.ADDITION);
					break;
				case "-":
					calc.calcul(Signe.SOUSTRACTION);
					break;
				case "X":
					calc.calcul(Signe.MULTIPLICATION);
					break;
				case "/":
					calc.calcul(Signe.DIVISION);
					break;
				case "C":
					calc.reset();
					break;
				default:
					System.out.println("ERREUR");
					break;
				}
			}
		}
	}

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
