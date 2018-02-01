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

	private boolean resetAff = false;// Permet la remise à zéro de l'affichage au prochain chiffre insérer après
										// avoir taper un signe
	private boolean reset = false;// Permet la remise à zéro après avoir tapé égal.

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
		resetAff = false;
		reset = false;
		this.updateObservateur();
	}

	public void calcul(Signe s) {
		reset = false;
		if (!resetAff) {
			if (valEnr == null) {
				valEnr = Double.valueOf(valAff);
			} else {
				calculer();
			}
			resetAff = true;
			this.updateObservateur();
		}
		signeEnr = s;
	}

	public void egal() {
		if (valEnr != null) {
			calculer();
			valEnr = null;
			reset = true;
		}
		this.updateObservateur();
	}

	public void chiffre(int i) {
		if (resetAff||reset) {
			valAff = "0";
			resetAff = false;
		}

		if (valAff.equalsIgnoreCase("0"))
			valAff = "" + i;
		else
			valAff += i;
		this.updateObservateur();
	}

	public void point() {
		if (resetAff) {
			valAff = "0";
			resetAff = false;
		}
		if (!valAff.contains("."))
			valAff += ".";
		this.updateObservateur();
	}

	public void addObservateur(Observateur obs) {
		this.listObservateur.add(obs);
	}

	public void delObservateur() {
		this.listObservateur = new ArrayList<Observateur>();
	}

	public void updateObservateur() {
		for (Observateur obs : this.listObservateur)
			obs.update(valAff);
	}
}
