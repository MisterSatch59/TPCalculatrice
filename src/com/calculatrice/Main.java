package com.calculatrice;

import com.calculatrice.model.Calculatrice;
import com.calculatrice.model.Signe;

public class Main {

	public static void main(String[] args) {
		Calculatrice c = new Calculatrice();
		System.out.println("Début : ValAff = " + c.getValAff());
		for (int i = 0; i < 4; i++) {
			c.chiffre(i + 1);
			System.out.println("je tape " + (i + 1) + " ValAff = " + c.getValAff());
		}
		c.point();
		System.out.println("je tape POINT  ValAff = " + c.getValAff());
		for (int i = 5; i < 9; i++) {
			c.chiffre(i + 1);
			System.out.println("je tape " + (i + 1) + "ValAff = " + c.getValAff());
		}

		c.calcul(Signe.ADDITION);
		System.out.println("après PLUS ValAff = " + c.getValAff());

		for (int i = 0; i < 2; i++) {
			c.chiffre(i + 1);
			System.out.println("je tape " + (i + 1) + " ValAff = " + c.getValAff());
		}
		c.point();
		System.out.println("je tape POINT  ValAff = " + c.getValAff());
		for (int i = 7; i < 9; i++) {
			c.chiffre(i + 1);
			System.out.println("je tape " + (i + 1) + " ValAff = " + c.getValAff());
		}

		c.calcul(Signe.SOUSTRACTION);
		System.out.println("après MOINS ValAff = " + c.getValAff());

		for (int i = 7; i > 4; i--) {
			c.chiffre(i + 1);
			System.out.println("je tape " + (i + 1) + " ValAff = " + c.getValAff());
		}
		c.point();
		System.out.println("je tape POINT  ValAff = " + c.getValAff());
		for (int i = 7; i < 9; i++) {
			c.chiffre(i + 1);
			System.out.println("je tape " + (i + 1) + " ValAff = " + c.getValAff());
		}

		c.egal();
		System.out.println("je tape EGAL  ValAff = " + c.getValAff());

		c.chiffre(1);
		System.out.println("je tape " + (1) + " ValAff = " + c.getValAff());
		c.calcul(Signe.ADDITION);
		System.out.println("après PLUS ValAff = " + c.getValAff());
		c.chiffre(1);
		System.out.println("je tape " + (1) + " ValAff = " + c.getValAff());
		c.egal();
		System.out.println("je tape EGAL  ValAff = " + c.getValAff());
		c.egal();
		System.out.println("je tape EGAL  ValAff = " + c.getValAff());
		c.egal();
		System.out.println("je tape EGAL  ValAff = " + c.getValAff());

	}

}
