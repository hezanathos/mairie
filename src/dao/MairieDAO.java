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
		List plages = new ArrayList<String>();
		
		String chemin = "data/theFiles/organismes/cleanDatas/";

		chemin += INSEE + ".xml";
		//System.out.println(chemin);
		
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			
			final DocumentBuilder builder = factory.newDocumentBuilder();
			final Document document = builder.parse(new File(chemin));
			final Element racine = document.getDocumentElement();
			final NodeList racineNoeuds = racine.getChildNodes();


			//System.out.println(racine.getChildNodes());
			
			if(racine.getElementsByTagName("Nom").getLength() !=0)
				nom =  racine.getElementsByTagName("Nom").item(0).getTextContent();
			//else nom = "";
			
			if(racine.getElementsByTagName("Ligne").getLength() !=0)
				adresse =  racine.getElementsByTagName("Ligne").item(0).getTextContent();
			//else adresse = "";
			
			if(racine.getElementsByTagName("CodePostal").getLength() !=0)
				codePostal =  racine.getElementsByTagName("CodePostal").item(0).getTextContent();
			//else codePostal = "";
			
			if(racine.getElementsByTagName("Url").getLength() !=0)
				site =  racine.getElementsByTagName("Url").item(0).getTextContent();
			//else site = "";
			
			if(racine.getElementsByTagName("NomCommune").getLength() !=0)
				ville =  racine.getElementsByTagName("NomCommune").item(0).getTextContent();
			//else ville = "Non communiqué";
			
			if(racine.getElementsByTagName("Latitude").getLength() !=0)
				latitude =  racine.getElementsByTagName("Latitude").item(0).getTextContent();
			//else latitude = "Non communiqué";
			
			if(racine.getElementsByTagName("Longitude").getLength() !=0)
				longitude =  racine.getElementsByTagName("Longitude").item(0).getTextContent();
			//else longitude = "Non communiqué";
			
			if(racine.getElementsByTagName("Téléphone").getLength() !=0)
				telephone =  racine.getElementsByTagName("Téléphone").item(0).getTextContent();
			//else telephone = "Non communiqué";
			
			if(racine.getElementsByTagName("Email").getLength() !=0)
				mail =  racine.getElementsByTagName("Email").item(0).getTextContent();
			//else mail = "Non communiqué";
			
			if(racine.getElementsByTagName("PlageJ").getLength() !=0){
				racine.getAttribute("PlageJ");
				/*for (Node plage : racine.getElementsByTagName("PlageJ")) {
					
				}*/
				System.out.println(racine.getElementsByTagName("PlageJ").getLength());
				for (int i = 0; i < racine.getElementsByTagName("PlageJ").getLength(); i++) {
					Element myElement = (Element) racine.getElementsByTagName("PlageJ").item(i);
					plages.add("Ouverture du "+myElement.getAttribute("début")+" au "+myElement.getAttribute("fin"));
					//System.out.println(plages.get(i*2));
					//System.out.println(myElement.getTagName());
					for (int j = 0; j < myElement.getElementsByTagName("PlageH").getLength(); j++){
						Element hElement = (Element) myElement.getElementsByTagName("PlageH").item(j);
						//System.out.println(hElement.getTagName());
						plages.add("  "+hElement.getAttribute("début")+" - "+hElement.getAttribute("fin"));
					}
					//System.out.println("********");
					
				}
				for(int i=0 ;  i<plages.size(); i++){
					System.out.println(plages.get(i));
				}
				//System.out.println(racine.getElementsByTagName("PlageJ"));
			}
/*			System.out.println(nom);
			System.out.println(adresse);
			System.out.println(codePostal);
			System.out.println(site);
			System.out.println(ville);
			System.out.println(longitude);
			System.out.println(latitude);
			System.out.println(telephone);
			System.out.println(mail);*/
			
			
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

		Mairie mairie = new Mairie(nom, adresse, mail, site, INSEE, codePostal, telephone, plages, ville, latitude, longitude);
		
		//return mairie;
	}

	public static void main(final String[] args) {
		getMairieFromINSEE("58142");
		//getMairieFromINSEE("58179");
	}

}
