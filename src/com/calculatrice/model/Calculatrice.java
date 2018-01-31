package com.calculatrice.model;

import java.util.ArrayList;

import com.calculatrice.observer.Observable;
import com.calculatrice.observer.Observateur;

public class Calculatrice implements Observable {

	// La collection d'observateurs
	private ArrayList<Observateur> listObservateur = new ArrayList<Observateur>();

	private String valAff = "0";// Valeur afficher
	private Double valEnr = null;
	private Signe signeEnr = null;

	private boolean resetAff = false;// Permet la remise à zéro de l'affichage au prochain chiffre insérer

	private void calculer() {
		// Effectue le calcul entre la valeur enregistrée et la valeur affichée avec le
		// signe enregistré
		switch (signeEnr) {
		case ADDITION:
			valEnr += Double.valueOf(valAff);
			break;
		case SOUSTRACTION:
			valEnr -= Double.valueOf(valAff);
			break;
		case MULTIPLICATION:
			valEnr = valEnr * Double.valueOf(valAff);
			break;
		case DIVISION:
			valEnr = valEnr / Double.valueOf(valAff);
			break;
		default:
			System.out.println("erreur dans calculer");
			break;
		}
		valAff = "" + valEnr;
	}

	public void reset() {
		valAff = "0";
		valEnr = null;
		signeEnr = null;
	}

	public void calcul(Signe s) {
		if (valEnr == null) {
			valEnr = Double.valueOf(valAff);
		} else {
			calculer();
		}
		signeEnr = s;
		resetAff = true;
	}

	public void egal() {
		if (valEnr != null) {
			calculer();
			valEnr = null;
			resetAff = true;
		}
	}

	public void chiffre(int i) {
		if (resetAff) {
			valAff = "0";
			resetAff = false;
		}

		if (valAff.equalsIgnoreCase("0"))
			valAff = "" + i;
		else
			valAff += i;
	}

	public void point() {
		if (resetAff) {
			valAff = "0";
			resetAff = false;
		}
		if (!valAff.contains("."))
			valAff += ".";
	}

	public String getValAff() {
		return valAff;
	}

	// Ajoute un observateur à la liste
	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}

	// Retire tous les observateurs de la liste
	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}

	// Avertit les observateurs que l'objet observable a changé
	// et invoque la méthode update() de chaque observateur
	public void updateObservateur() {
		for (Observateur obs : this.listObservateur)
			obs.update(valAff);
	}
}
