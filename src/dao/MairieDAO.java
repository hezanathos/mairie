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

	public static String getInsee(){
		String code = "";
		
		
		
		return code;
	}
	
	public static Mairie getMairieFromINSEE(String INSEE,String racineProj) {
		String nom = "";
		String adresse = "";
		String mail = "";
		String site = "";
		String ville = "";
		String latitude = "";
		String longitude = "";
		String codePostal = "";
		String telephone = "";
		List<String> plages = new ArrayList<String>();
		String temp = "";


		
		if (INSEE != null){
		final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

		try {
			
			final DocumentBuilder builder = factory.newDocumentBuilder();
			
		
			final Document document = builder.parse(new File(racineProj+"WEB-INF"+File.separator+"lib"+File.separator+"cleanDatas"+File.separator+ INSEE + ".xml"));
		//		System.out.println(racineProj+"WEB-INF"+File.separator+"lib"+File.separator+"cleanDatas"+File.separator+ INSEE + ".xml");
			
			final Element racine = document.getDocumentElement();
		
			
			if(racine.getElementsByTagName("Nom").getLength() !=0)
				nom =  racine.getElementsByTagName("Nom").item(0).getTextContent();
		
			
			if(racine.getElementsByTagName("Ligne").getLength() !=0)
				adresse =  racine.getElementsByTagName("Ligne").item(0).getTextContent();
	
			
			if(racine.getElementsByTagName("CodePostal").getLength() !=0)
				codePostal =  racine.getElementsByTagName("CodePostal").item(0).getTextContent();
			
			
			if(racine.getElementsByTagName("Url").getLength() !=0)
				site =  racine.getElementsByTagName("Url").item(0).getTextContent();
		
			
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

				for (int i = 0; i < racine.getElementsByTagName("PlageJ").getLength(); i++) {
					Element myElement = (Element) racine.getElementsByTagName("PlageJ").item(i);
					plages.add("Ouverture du "+myElement.getAttribute("début")+" au "+myElement.getAttribute("fin"));
					for (int j = 0; j < myElement.getElementsByTagName("PlageH").getLength(); j++){
						Element hElement = (Element) myElement.getElementsByTagName("PlageH").item(j);
						plages.add("  "+hElement.getAttribute("début")+" - "+hElement.getAttribute("fin"));
					}
				}
			}
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
		
		return mairie;
		}
		else return null;
	}

	public static void main(final String[] args) {
//		Mairie mairie = getMairieFromINSEE("58142");
//		System.out.println(mairie.toString());		
//		Mairie mairie2 = getMairieFromINSEE("58210");
//		System.out.println(mairie2.toString());
	}

}
