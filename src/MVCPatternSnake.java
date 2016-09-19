import controller.SnakeController;
import modele.Snake;
import view.SnakeView;

public class MVCPatternSnake {

	public static void main(String[] args) {

		Snake model = retriveSnakeFromDatabase();

		SnakeView view = new SnakeView();

		SnakeController controller = new SnakeController(model, view);

		controller.updateView();

	}

	private static Snake retriveSnakeFromDatabase() {
		Snake Snake = new Snake();
		Snake.setAuteur("Matthias");
		Snake.setTitre("Snake test");
		Snake.setTexte("Ceci est une Snake");
		Snake.setId(1);
		return Snake;
	}

}
