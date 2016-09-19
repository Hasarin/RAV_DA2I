package controller;

import modele.Snake;
import view.SnakeView;

public class SnakeController {
	private Snake model;
	private SnakeView view;

	public SnakeController(Snake model, SnakeView view) {
		this.model = model;
		this.view = view;
	}

	public String getSnakeTitre() {
		return model.getTitre();
	}

	public String getSnakeAuteur() {
		return model.getAuteur();
	}

	public String getSnakeTexte() {
		return model.getTexte();
	}

	public int getSnakeId() {
		return model.getId();
	}

	public void setSnakeTitre(String titre) {
		model.setTitre(titre);
	}

	public void setSnakeAuteur(String auteur) {
		model.setAuteur(auteur);
	}

	public void setSnakeTexte(String texte) {
		model.setTexte(texte);
	}

	public void setSnakeId(int id) {
		model.setId(id);
	}

	public void updateView() {
		view.printSnake(model.getId(), model.getAuteur(), model.getTitre(), model.getTexte());
	}
}
