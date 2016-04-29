package dao;

import java.util.List;
import dto.Mairie;
import java.io.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.IOException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class MairieDAO {

	private static MairieDAO singleton;

	public static MairieDAO getInstance() {
		if (MairieDAO.singleton == null)
			singleton = new MairieDAO();
		return singleton;
	}

	// Mairie(String adresse, String mail, String site, String iNSEE, String
	// codePostal, String telephone, List<String> horaire
	public static void getMairieFromINSEE(String INSEE) {
		String nom = "";
		String adresse = "";
		String mail = "";
		String site = "";
		String ville = "";
		String latitude = "";
		String longitude = "";
		String codePostal = "";
		String telephone = "";
		ArrayList horaires = new ArrayList();
		String chemin = "";

		chemin += "data/theFiles/organismes/";

		String dos = INSEE.substring(0, 2);
		if (dos.equals("97") || dos.equals("98"))
			dos = INSEE.substring(0, 3);

		if (dos.equals("75")) {
			chemin += dos + "/paris_mairie_arrondissement-" + INSEE + "-01";
			if (dos.equals("75056")) {
				chemin += dos + "/paris_mairie-" + INSEE + "-01";
			}
		} else
			chemin += dos + "/mairie-" + INSEE + "-01.xml";
		System.out.println(chemin);
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {

			/*
			 * Etape 2 : création d'un parseur
			 */

			final DocumentBuilder builder = factory.newDocumentBuilder();

			/*
			 * Etape 3 : création d'un Document
			 */

			final Document document = builder.parse(new File(chemin));

			/*
			 * Etape 4 : récupération de l'Element racine
			 */

			final Element racine = document.getDocumentElement();

			// Affichage de l'élément racine

			// System.out.println(racine.getNodeName());

			/*
			 * 
			 * Etape 5 : récupération des personnes
			 * 
			 */

			final NodeList racineNoeuds = racine.getChildNodes();

			//final int nbRacineNoeuds = racineNoeuds.getLength();

			if(!racine.getElementsByTagName("Nom").item(0).getTextContent().isEmpty())
				nom =  racine.getElementsByTagName("Nom").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("Ligne").item(0).getTextContent().isEmpty())
				adresse =  racine.getElementsByTagName("Ligne").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("CodePostal").item(0).getTextContent().isEmpty())
				codePostal =  racine.getElementsByTagName("CodePostal").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("Url").item(0).getTextContent().isEmpty())
				site =  racine.getElementsByTagName("Url").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("NomCommune").item(0).getTextContent().isEmpty())
				ville =  racine.getElementsByTagName("NomCommune").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("Latitude").item(0).getTextContent().isEmpty())
				latitude =  racine.getElementsByTagName("Latitude").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("Longitude").item(0).getTextContent().isEmpty())
				longitude =  racine.getElementsByTagName("Longitude").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("Téléphone").item(0).getTextContent().isEmpty())
				telephone =  racine.getElementsByTagName("Téléphone").item(0).getTextContent();
			
			if(!racine.getElementsByTagName("Email").item(0).getTextContent().isEmpty())
				mail =  racine.getElementsByTagName("Email").item(0).getTextContent();
			
			System.out.println(nom);
			System.out.println(adresse);
			System.out.println(codePostal);
			System.out.println(site);
			System.out.println(ville);
			System.out.println(longitude);
			System.out.println(latitude);
			System.out.println(telephone);
			System.out.println(mail);
			
			
			/*
			List<String> horaires = null;*/
		}

		catch (final ParserConfigurationException e) {

			e.printStackTrace();

		}

		catch (final SAXException e) {

			e.printStackTrace();

		}

		catch (final IOException e) {

			e.printStackTrace();

		}

		Mairie mairie = new Mairie(nom, adresse, mail, site, INSEE, codePostal, telephone, horaires, ville, latitude, longitude);
		
		//return mairie;
	}

	public static void main(final String[] args) {
		/*Mairie mairie = new getMairieFromINSEE("02021");
		affiche();*/
		getMairieFromINSEE("27240");
	}

}
