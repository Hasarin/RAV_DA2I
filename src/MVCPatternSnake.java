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
		return Snake;
	}

}
