package dto;

import java.util.List;

public class Mairie {
	private String nom;
	private String adresse;
	private String mail;
	private String site;
	private String INSEE;
	private String codePostal;
	private String telephone;
	private String ville;
	private String latitude;
	private String longitude;
	private List<String> horaires;
	
	/**
	 * Construteur avec paramètres
	 */
	public Mairie(String nom, String adresse, String mail, String site, String iNSEE, String codePostal, String telephone,  List<String> horaires, String ville, String latitude, String longitude) {
		this.latitude = latitude;
		this.longitude = longitude;
		this.ville = ville;
		this.nom = nom;
		this.adresse = adresse;
		this.mail = mail;
		this.site = site;
		this.INSEE = INSEE;
		this.codePostal = codePostal;
		this.telephone = telephone;
		this.horaires = horaires;
	}
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getlatitude() {
		return latitude;
	}	
	public String getlongitude() {
		return longitude;
	}
	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public String getSite() {
		return site;
	}

	public void setSite(String site) {
		this.site = site;
	}

	public String getINSEE() {
		return INSEE;
	}

	public void setINSEE(String iNSEE) {
		INSEE = iNSEE;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public List<String> getHoraires() {
		return horaires;
	}
	//fonction pour afficher la list d'horaires proprement
	public void affichageHoraires(){
		for(int i=0 ;  i<horaires.size(); i++){
			System.out.println(horaires.get(i));
		}
	}
	
	public void setHoraires(List<String> horaires) {
		this.horaires = horaires;
	}
	//affichage pour test dans la console
	public String toString(){
		String myString = "Ville : " + ville + " Nom : " + nom + " Adresse : " + adresse + " Mail : " + mail + " Site : " + " CodePostal : " + codePostal + " Telephone : " + telephone + " Site : " + site + " INSEE : " + INSEE;
		myString += " Latitude : " + latitude + " Longitude : " + longitude;
		for(int i=0 ;  i<horaires.size(); i++){
			myString += " "+horaires.get(i);
		}
		return  myString;
	}

}
