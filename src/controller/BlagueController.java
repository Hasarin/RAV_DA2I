package controller;

import modele.Blague;
import view.BlagueView;

public class BlagueController {
	private Blague model;
	private BlagueView view;

	public BlagueController(Blague model, BlagueView view) {
		this.model = model;
		this.view = view;
	}

	public String getBlagueTitre() {
		return model.getTitre();
	}

	public String getBlagueAuteur() {
		return model.getAuteur();
	}

	public String getBlagueTexte() {
		return model.getTexte();
	}

	public int getBlagueId() {
		return model.getId();
	}

	public void setBlagueTitre(String titre) {
		model.setTitre(titre);
	}

	public void setBlagueAuteur(String auteur) {
		model.setAuteur(auteur);
	}

	public void setBlagueTexte(String texte) {
		model.setTexte(texte);
	}

	public void setBlagueId(int id) {
		model.setId(id);
	}

	public void updateView() {
		view.printBlague(model.getId(), model.getAuteur(), model.getTitre(), model.getTexte());
	}
}
