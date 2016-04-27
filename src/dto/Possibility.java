package dto;

public class Possibility {


	String INSEE;
	String postalCode;
	String nom;

	/**
	 * Construteur sans paramètres
	 */
	public Possibility() {
	}
	/**
	 * Construteur avec paramètres
	 */
	public Possibility(String INSEE, String postalCode, String nom) {

		this.INSEE = INSEE;
		this.postalCode = postalCode;
		this.nom = nom;
	}
	public String getINSEE() {
		return INSEE;
	}

	public void setINSEE(String iNSEE) {
		INSEE = iNSEE;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * Redéfinition de la méthode toString permettant de définir la traduction
	 * de l'objet en String pour affichage par exemple
	 */
	@Override
	public String toString() {
		return "Possibilité [INSEE=" + INSEE + ", nom=" + nom + ", CodePostal=" + postalCode + "]";

	}
}
