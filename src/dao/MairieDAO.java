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
		List<String> horaires = null;
		String chemin = "data/theFiles/organismes/cleanDatas/";

		chemin += INSEE + ".xml";
		System.out.println(chemin);
		
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File(chemin));
			final Element racine = document.getDocumentElement();
			final NodeList racineNoeuds = racine.getChildNodes();


			System.out.println(racine.getChildNodes());
			
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
		getMairieFromINSEE("74315");
	}

}
