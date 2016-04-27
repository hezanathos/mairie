package dao;
import dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe d'accès aux données contenues dans la table message
 * @author serais
 * */
public class MessageDAO {
	
	/**
	 * Paramètres de connexion à la base de données
	 */
	final static String URL = "jdbc:mysql://localhost/codes";
	final static String LOGIN="root";
	final static String PASS="";
	/**
	 * singleton attribut permettant de mettre en oeuvre le design pattern singleton
	 */
	private static MessageDAO singleton;
	
	/**
	 * Constructeur (privé) de la classe
	 * Privé car utilisation du design pattern singleton
	 */
	private MessageDAO()
	{
		// chargement du pilote Mysql
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println("Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier mysql-connector-java-XXXX.jar dans le projet");
		}
		
	}
	/**
	 * Permet de récupérer l'instance unique de la classe MessageDAO
	 * cf design pattern singleton
	 * @return
	 */
	public static MessageDAO getInstance()
	{
		if(MessageDAO.singleton==null)
			singleton=new MessageDAO();
		return singleton;
	}
	
	/**
	 * Permet d'ajouter un message dans la table message
	 * @param m le message à ajouter
	 * @return le nombre de ligne ajoutées dans la table
	 */
	public int ajouter(Message m)
	{
		Connection con = null;
		PreparedStatement ps = null;
		int retour=0;
	
		//connexion a la base de données
		try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("INSERT INTO message (expediteur,message) VALUES (?,?)");
			ps.setString(1,m.getExpediteur());
			ps.setString(2,m.getMessage());
			
			//on execute la requete 
			retour=ps.executeUpdate();
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du preparedStatement et de la connexion
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return retour;
	
	}
	
	/**
	 * Permet de récupérer un message à partir de son id
	 * @param id l'id du message à récupérer
	 * @return le message
	 * @return null si aucun message ne correspond à cet id
	 */
	public Message getMessage(int id)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		Message retour=null;
	
		//connexion a la base de données
		try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM message WHERE id=?");
			ps.setInt(1,id);
						
			//on execute la requete 
			rs=ps.executeQuery();
			if(rs.next())
				retour=new Message(rs.getInt("id"),rs.getString("expediteur"),rs.getString("message"));
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du rs,preparedStatement et de la connexion
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return retour;
	
	}
	
	/**
	 * Permet de récupérer tous les messages de la table
	 * @return la liste des messages
	 */
	public List<Message> getListeMessages()
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Message> retour=new ArrayList<Message>();
	
		//connexion a la base de données
		try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM message");
									
			//on execute la requete 
			rs=ps.executeQuery();
			//on parcourt les lignes du resultat
			while(rs.next())
				retour.add(new Message(rs.getInt("id"),rs.getString("expediteur"),rs.getString("message")));
			

		} catch (Exception ee) {
			ee.printStackTrace();
		} finally {
			//fermeture du rs,preparedStatement et de la connexion
			try {if (rs != null)rs.close();} catch (Exception t) {}
			try {if (ps != null)ps.close();} catch (Exception t) {}
			try {if (con != null)con.close();} catch (Exception t) {}
		}
		return retour;
	
	}
	
	
	
	//main permettant de tester la classe
	public static void main(String[] args){
		MessageDAO messageDAO=new MessageDAO();
		//test de la méthode ajouter
		Message m=new Message(0,"Sébastien","Bonjour à tous");
		int retour=messageDAO.ajouter(m);
		System.out.println(retour+ " lignes ajoutées");
		
		//test de la méthode getMessage
		Message m2=messageDAO.getMessage(1);
		System.out.println(m2);
		
		//test de la méthode getListeMessages
		List<Message> liste=messageDAO.getListeMessages();
		System.out.println(liste);
		
	}
	
	


}
