import controller.BlagueController;
import modele.Blague;
import view.BlagueView;

public class MVCPatternBlague {

	public static void main(String[] args) {

		Blague model = retriveBlagueFromDatabase();

		BlagueView view = new BlagueView();

		BlagueController controller = new BlagueController(model, view);

		controller.updateView();

	}

	private static Blague retriveBlagueFromDatabase() {
		Blague blague = new Blague();
		blague.setAuteur("Matthias");
		blague.setTitre("Blague test");
		blague.setTexte("Ceci est une blague");
		blague.setId(1);
		return blague;
	}

}
