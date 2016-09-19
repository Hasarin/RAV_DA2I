package bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Bdd {
	public Bdd() {

		/* Chargement du driver JDBC pour MySQL */
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		/* Connexion à la base de données */

		String url = "jdbc:mysql://cclem62.ddns.net/phpmyadmin";
		String utilisateur = "da2i";
		String motDePasse = "da2igroupe1";

		Connection connexion = null;
		try {
			connexion = DriverManager.getConnection(url, utilisateur, motDePasse);
			/* Ici, nous placerons nos requêtes vers la BDD */
			String req = "SELECT * FROM blague where id = 3";

			/* Création de l'objet gérant les requêtes */
			Statement statement = connexion.createStatement();

			/* Exécution d'une requête de lecture */
			ResultSet resultat = statement.executeQuery(req);

			int idBlague = resultat.getInt(1);
			String auteur = resultat.getString(2);
			String texte = resultat.getString(4);
			String titre = resultat.getString(6);

			System.out.println(idBlague);
			/* ... */
		} catch (SQLException e) {
			System.out.println("c'est la merde");
		} finally {
			if (connexion != null)
				try {
					/* Fermeture de la connexion */
					connexion.close();
				} catch (SQLException ignore) {
					System.out.println("c'est la merde2");
				}
		}
	}

	public static void main(String[] args) {
		Bdd bdd = new Bdd();
	}
}
