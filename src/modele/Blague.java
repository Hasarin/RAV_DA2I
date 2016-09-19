package modele;

public class Blague {
	
	private String titre;
	private String auteur;
	private String texte;
	
	
	private int id;
	
	

/*----------------GETTERS -----------------------------------*/
	public String getTitre() {
		return titre;
	}
	
	public String getAuteur() {
		return auteur;
	}
	
	public String getTexte() {
		return texte;
	}
	
	public int getId() {
		return id;
	}
	
	/*----------------SETTERS -----------------------------------*/

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public void setAuteur(String auteur) {
		this.auteur = auteur;
	}

	public void setTexte(String texte) {
		this.texte = texte;
	}

	public void setId(int id) {
		this.id = id;
	}
	
}
