package dao;
import dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
/**
 * Classe d'accès aux données contenues dans la table message
 * @author serais
 * */
public class CodesDAO {
	
	/**
	 * Paramètres de connexion à la base de données
	 */
	final static String URL = "jdbc:mysql://localhost/codes";
	final static String LOGIN="root";
	final static String PASS="";
	/**
	 * singleton attribut permettant de mettre en oeuvre le design pattern singleton
	 */
	private static CodesDAO singleton;
	
	/**
	 * Constructeur (privé) de la classe
	 * Privé car utilisation du design pattern singleton
	 */
	private CodesDAO()
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
	public static CodesDAO getInstance()
	{
		if(CodesDAO.singleton==null)
			singleton=new CodesDAO();
		return singleton;
	}
	

	
	/**
	 * Permet de récupérer le code Insee d'une commune à partir de son code postal
	 * @param postal le code postal de la commune
	 * @return le code insee
	 * @return 0 si aucun code postal correspondant n'existe dans la base de donnée
	 */
	public int getInseeFromPostal(int postal)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		int retour=0;
	
		//connexion a la base de données
		try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT `Code_commune_INSEE` FROM `table 1` WHERE `Code_postal` = ?");
			ps.setInt(1,postal);
						
			//on execute la requete 
			rs=ps.executeQuery();
			if(rs.next())
				retour= rs.getInt("Code_commune_INSEE");
			

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
		CodesDAO codesDAO=new CodesDAO();

		//test de la méthode getCode
		int insee=codesDAO.getInseeFromPostal(76800);
		System.out.println(insee+" est le code Insee corespondant à 76800");
		
		
		
	}
	
	


}
