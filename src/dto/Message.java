package dto;

public class Message {
	
	int id;				//id du message
	String expediteur;	//expéditeur du message
	String message;		//contenu du message
	
	/**
	 * Construteur sans paramètres
	 */
	public Message(){
	}
	
	/**
	 * Constructeur
	 * @param expediteur expéditeur du message
	 * @param message contenu du message
	 */
	public Message(int id,String expediteur, String message) {
		super();
		this.id=id;
		this.expediteur = expediteur;
		this.message = message;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getExpediteur() {
		return expediteur;
	}
	public void setExpediteur(String expediteur) {
		this.expediteur = expediteur;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}

	

	/**
	 * Redéfinition de la méthode toString permettant de définir la traduction de l'objet en String
	 * pour affichage par exemple
	 */
	@Override
	public String toString() {
		return "Message [id=" + id + ", expediteur=" + expediteur
				+ ", message=" + message + "]";
	}
	

}
