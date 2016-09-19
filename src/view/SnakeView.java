package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class SnakeView extends JFrame {
	JFrame f = new JFrame();
	JPanel pan = new JPanel();

	public SnakeView() {

	}

	public void ConfigFenetre() {
		f.setTitle("Snake");
		f.setSize(400, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public void Menu() {

	}

	public void AffichageGraphique(int id, String auteur, String titre, String texte) {

		JTextArea text = new JTextArea(5, 20);
		text.append("Titre: " + titre + "\n\n");
		text.append("Auteur: " + auteur + "\n\n");
		text.append("Texte: " + texte + "\n\n");
		text.setEditable(false);
		pan.add(text);
		f.add(pan);
		f.setVisible(true);
	}

	public void ClearScreen() {

	}

	public void printSnake(int id, String auteur, String titre, String texte) {
		SnakeView bv = new SnakeView();
		bv.ConfigFenetre();
		bv.AffichageGraphique(id, auteur, titre, texte);

	}
}
