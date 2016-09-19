package view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class BlagueView extends JFrame {
	

	public BlagueView() {

	}

	public void AffichageGraphique(int id, String auteur, String titre, String texte) {
		JFrame f = new JFrame("Blague2Fou");
		f.setSize(400, 300);
		f.setLocationRelativeTo(null);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel pan = new JPanel();
		JTextArea text = new JTextArea(5, 20);
		text.append("Titre: " + titre + "\n\n");
		text.append("Auteur: " + auteur + "\n\n");
		text.append("Texte: " + texte + "\n\n");
		text.setEditable(false);
		pan.add(text);
		f.add(pan);

		f.setVisible(true);
	}

	public void printBlague(int id, String auteur, String titre, String texte) {
		BlagueView bv = new BlagueView();
		bv.AffichageGraphique(id, auteur, titre, texte);

	}
}
