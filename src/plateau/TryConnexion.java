package plateau;

import java.sql.Connection;
import java.sql.DriverManager;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class TryConnexion {
	Connection connexion = null;
	public static int i = 0;

	public TryConnexion() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://92.131.191.39/blague2fou", "da2i",
					"da2igroupe1");
			
			/* Ici, nous placerons nos requêtes vers la BDD */
			String req = "SELECT * FROM blague";
			Statement statement = connexion.createStatement();
			ResultSet rs = statement.executeQuery(req);

			while (rs.next()) {
				i++;
			}
			System.out.println("ok");
			/* ... */
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (connexion != null)
				try {
					/* Fermeture de la connexion */
					connexion.close();
				} catch (SQLException ignore) {
					/*
					 * Si une erreur survient lors de la fermeture, il suffit de
					 * l'ignorer.
					 */
				}
		}
	}

	public static void main(String[] args) throws Exception {
		TryConnexion tc = new TryConnexion();
	}
}
