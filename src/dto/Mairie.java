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

	public void setHoraires(List<String> horaires) {
		this.horaires = horaires;
	}
	/*	this.latitude = latitude;
		this.longitude = longitude;

		this.horaires = horaires;*/
	public String toString(Mairie mairie){
		String myString = "Ville : " + ville + "Nom : " + nom + "Adresse : " + adresse + "Mail : " + mail + "site : " + "codePostal : " + codePostal + "Telephone : " + telephone + "Site : " + site + "INSEE : " + INSEE;
		myString += "Latitude : " + latitude + "Longitude : " + longitude;
		for(int i=0 ;  i<horaires.size(); i++){
			myString += " "+horaires.get(i);
		}
		return  myString;
	}

}
