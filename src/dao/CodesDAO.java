package dao;

import dto.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe d'accès aux données contenues dans la table message
 * 
 * @author serais
 */
public class CodesDAO {

	/**
	 * Paramètres de connexion à la base de données
	 */
	final static String URL = "jdbc:mysql://localhost/codes";
	final static String LOGIN = "root";
	final static String PASS = "";
	/**
	 * singleton attribut permettant de mettre en oeuvre le design pattern
	 * singleton
	 */
	private static volatile CodesDAO singleton;

	/**
	 * Constructeur (privé) de la classe Privé car utilisation du design pattern
	 * singleton
	 */
	public CodesDAO() {
		// Chargement du pilote Mysql
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e2) {
			System.out.println(
					"Impossible de charger le pilote de BDD, ne pas oublier d'importer le fichier mysql-connector-java-XXXX.jar dans le projet");
		}
	}
	/**
	 * Permet de récupérer l'instance unique de la classe MessageDAO cf design
	 * pattern singleton
	 * 
	 * @return
	 */
	public static  CodesDAO getInstance() {
		if (CodesDAO.singleton == null){
			synchronized (CodesDAO.class) {
				if (CodesDAO.singleton == null) {

			singleton = new CodesDAO();
				}
			}
		}
		return singleton;
	}

	/**
	 * Permet de récupérer le code Insee d'une commune à partir de son code
	 * postal
	 * 
	 * @param string
	 *            le code postal de la commune
	 * @return 
	 * @return un objet Possibilities avec un attribut inseeList contenant les codes insee corespondants
	 *        
	 */
	public List<Possibility> getPossFromPostal(String string)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Possibility> retour=null;

	
		//connexion a la base de données
		try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT * FROM `ville` WHERE `CodePostal` like ? GROUP BY INSEE");
			ps.setString(1,string+"%");
						
			//on execute la requete 
			rs=ps.executeQuery();
		

				retour= new ArrayList<Possibility>();

			
			
			while(rs.next()){
				retour.add(new Possibility( rs.getString("INSEE"),rs.getString("CodePostal"),rs.getString("nom")));
			
			}


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
	public List<Possibility> getPossFromName(String name)
	{
		
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		List<Possibility> retour=null;

	
		//connexion a la base de données
		try {
			
			con = DriverManager.getConnection(URL, LOGIN, PASS);
			ps = con.prepareStatement("SELECT  * FROM `ville` WHERE `Nom` like ? GROUP BY INSEE");
			ps.setString(1,name+"%");
						
			//on execute la requete 
			rs=ps.executeQuery();
		

				retour= new ArrayList<Possibility>();

			
			
			while(rs.next()){
				retour.add(new Possibility( rs.getString("INSEE"),rs.getString("CodePostal"),rs.getString("nom")));
			
			}


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
	// main permettant de tester la classe
	public static void main(String[] args){
		CodesDAO codesDAO=new CodesDAO();

		//test de la méthode getCode


		List<Possibility> poss =codesDAO.getPossFromPostal("27");
		System.out.println(poss);
		
		List<Possibility> poss2 =codesDAO.getPossFromName("Rouen");
		System.out.println(poss2);
		
		
	}

}
