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

	public int getSnakeScore(){
		return model.getScore();
		
	}
	
	public boolean isSnakeVivant(){
		return model.isVivant();
		
	}
	public void SetSnakeScore(int score){
		model.setScore(score);
		
	}
	public void SetSnakeVivant(boolean vivant){
		model.setVivant(vivant);
		
	}
	
	public void updateView() {
		view.printSnake(model.getScore());
	}
}
