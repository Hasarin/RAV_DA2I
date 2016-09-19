package modele;

public class Snake {
	
	private boolean vivant;
	private int Score;
	
	

/*----------------GETTERS -----------------------------------*/
	public boolean isVivant() {
		return vivant;
	}
	
	public int getScore() {
		return Score;
	}
	
	
	
	/*----------------SETTERS -----------------------------------*/

	public void setVivant(boolean vivant) {
		this.vivant = vivant;
	}
	
	public void setScore(int score) {
		Score = score;
	}
}
