import java.sql.Connection;
import java.util.Date;
import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;

public class ConnexionBlague {
	Connection connexion = null;
	public static int i = 0;

	public ConnexionBlague() throws Exception {

		try {
			Class.forName("com.mysql.jdbc.Driver");
			connexion = DriverManager.getConnection("jdbc:mysql://92.131.191.39/blague2fou", "da2i",
					"da2igroupe1");
			
			
			/* ... */
		} catch (SQLException e) {
			e.printStackTrace();
		} 
	}
	
	public Connection getConnection(){
		return this.connexion;
	}
	
	public static void closeConnection(ConnexionBlague tc) throws SQLException{
		tc.getConnection().close();
	}
	
	public static void afficheBlagues(ConnexionBlague tc) throws SQLException{
		/* Ici, nous placerons nos requÃªtes vers la BDD */
		String req = "SELECT * FROM blague";
		Connection c = tc.getConnection();
		Statement statement = c.createStatement();
		ResultSet rs = statement.executeQuery(req);

		while (rs.next()) {
			String auteur = rs.getString("auteur");
			String text = rs.getString("texte");
			String dt = rs.getString("date");
			
			System.out.println(text + "\n ");
			System.out.println("Auteur : " + auteur + "\n ");
			System.out.println("Envoyé le : " + dt + "\n ");
			System.out.println("________________________________________________________________________________________________________________________________________");
			i++;
		}
	}
	
	public static void afficheBlaguesParCateg(ConnexionBlague tc, String categ) throws SQLException{
		/* Ici, nous placerons nos requÃªtes vers la BDD */
		String req = "SELECT * FROM blague WHERE categorie=(SELECT id FROM categorie WHERE libelle='" + categ + "');";
		Connection c = tc.getConnection();
		Statement statement = c.createStatement();
		ResultSet rs = statement.executeQuery(req);

		while (rs.next()) {
			String auteur = rs.getString("auteur");
			String text = rs.getString("texte");
			String dt = rs.getString("date");
			
			System.out.println("\n" + text + "\n ");
			System.out.println("Auteur : " + auteur + "\n ");
			System.out.println("Envoyé le : " + dt + "\n ");
			System.out.println("________________________________________________________________________________________________________________________________________");
			i++;
		}
	}
	
	public static Integer ajouteBlague(ConnexionBlague tc, String titre, String texte, String auteur, String categorie) throws SQLException{
		/* Ici, nous placerons nos requÃªtes vers la BDD */
		Integer categ =0;
		Integer i;
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
		String dateStr = simpleDateFormat.format(new Date());
				
		String req2="SELECT id FROM categorie WHERE libelle='" + categorie + "'";
		Connection c = tc.getConnection();
		Statement statement = c.createStatement();
		ResultSet rs = statement.executeQuery(req2);
		
		while (rs.next()) {
		categ = rs.getInt("id");
		}
		String req = "INSERT INTO blague(id, auteur, date, texte, categorie, titre) VALUES(NULL,'" + auteur + "' , '" + dateStr + "', '"+ texte + "', " + categ + ",'" + titre +"');";
		return i = statement.executeUpdate(req);
	}

	public static void main(String[] args) throws Exception {
		ConnexionBlague tc = new ConnexionBlague();
		if(tc.getConnection() !=null){
			System.out.println("Connexion réussie !\n");
			System.out.println("Menu : ");
			System.out.println("A : Toutes les blagues");
			System.out.println("B : Une catégorie spécifique");
			System.out.println("C : Ajouter une blague");
			Scanner sc = new Scanner(System.in);
			System.out.println("Entrez votre choix :");
			String chx = sc.nextLine();
			System.out.println(chx);
			if(chx.contains("A")){
				System.out.println("choix A");
				afficheBlagues(tc);
			}
			if(chx.contains("B")){
				System.out.println("choix B");
				Scanner sc1 = new Scanner(System.in);
				System.out.println("Entrez la categorie désirée : ");
				String chx1 = sc1.nextLine();
				afficheBlaguesParCateg(tc, chx1);
			}
			if(chx.contains("C")){
				System.out.println("choix C");
				Scanner sc2 = new Scanner(System.in);
				System.out.println("Entrez la blague : ");
				String blg = sc2.nextLine();
				Scanner sc3 = new Scanner(System.in);
				System.out.println("Entrez le titre : ");
				String tr = sc3.nextLine();
				Scanner sc4 = new Scanner(System.in);
				System.out.println("Entrez l'auteur : ");
				String aut = sc4.nextLine();
				Scanner sc5 = new Scanner(System.in);
				System.out.println("Entrez la catégorie : ");
				String cat = sc5.nextLine();
				Integer i = ajouteBlague(tc, tr, blg, aut, cat);
				if (i ==1){
					System.out.println("Blague ajoutée !");
				}else{
					System.out.println("ÉCHEC !");
				}
			}
		}
	}
}
