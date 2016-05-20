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
	/**
	 * singleton attribut permettant de mettre en oeuvre le design pattern
	 * singleton
	 */
	private static volatile MairieDAO singleton;
	/**
	 * Permet de récupérer l'instance unique de la classe MessageDAO cf design
	 * pattern singleton
	 * 
	 * @return
	 */
	public static MairieDAO getInstance() {
		if (MairieDAO.singleton == null) {
			synchronized (MairieDAO.singleton) {
				if (MairieDAO.class == null) {
					singleton = new MairieDAO();
				}
			}
		}
		return singleton;
	}

	public static String getInsee() {
		String code = "";
		return code;
	}
	/**
	 * Permet de créer l'objet Mairie à partir des fichiers xml
	 * @param String 
	 * 			code INSEE
	 * @param String
	 * 			racine du projet
	 * @retun Mairie
	 * 	Retourne un objet de type mairie corespondant au caractéristiques d'une ville
	 */
	public static Mairie getMairieFromINSEE(String INSEE, String racineProj) {
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
		if (INSEE != null) {
			final DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();

			try {
				//On recupère les données du xml concerné celon le code INSEE entré en parametre
				final DocumentBuilder builder = factory.newDocumentBuilder();

				final Document document = builder.parse(new File(racineProj + "WEB-INF" + File.separator + "Ressources"
						+ File.separator + "cleanDatas" + File.separator + INSEE + ".xml"));

				final Element racine = document.getDocumentElement();

				if (racine.getElementsByTagName("Nom").getLength() != 0)
					nom = racine.getElementsByTagName("Nom").item(0).getTextContent();

				if (racine.getElementsByTagName("Ligne").getLength() != 0)
					adresse = racine.getElementsByTagName("Ligne").item(0).getTextContent();

				if (racine.getElementsByTagName("CodePostal").getLength() != 0)
					codePostal = racine.getElementsByTagName("CodePostal").item(0).getTextContent();

				if (racine.getElementsByTagName("Url").getLength() != 0)
					site = racine.getElementsByTagName("Url").item(0).getTextContent();

				if (racine.getElementsByTagName("NomCommune").getLength() != 0)
					ville = racine.getElementsByTagName("NomCommune").item(0).getTextContent();

				if (racine.getElementsByTagName("Latitude").getLength() != 0)
					latitude = racine.getElementsByTagName("Latitude").item(0).getTextContent();

				if (racine.getElementsByTagName("Longitude").getLength() != 0)
					longitude = racine.getElementsByTagName("Longitude").item(0).getTextContent();

				if (racine.getElementsByTagName("Téléphone").getLength() != 0)
					telephone = racine.getElementsByTagName("Téléphone").item(0).getTextContent();

				if (racine.getElementsByTagName("Email").getLength() != 0)
					mail = racine.getElementsByTagName("Email").item(0).getTextContent();

				if (racine.getElementsByTagName("PlageJ").getLength() != 0) {
					racine.getAttribute("PlageJ");

					for (int i = 0; i < racine.getElementsByTagName("PlageJ").getLength(); i++) {
						Element myElement = (Element) racine.getElementsByTagName("PlageJ").item(i);
						plages.add("Ouverture du " + myElement.getAttribute("début") + " au "
								+ myElement.getAttribute("fin"));
						for (int j = 0; j < myElement.getElementsByTagName("PlageH").getLength(); j++) {
							Element hElement = (Element) myElement.getElementsByTagName("PlageH").item(j);
							plages.add("  " + hElement.getAttribute("début") + " - " + hElement.getAttribute("fin"));
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
			//On construit l'objet mairie a retourné
			Mairie mairie = new Mairie(nom, adresse, mail, site, INSEE, codePostal, telephone, plages, ville, latitude,
					longitude);

			return mairie;
		} else
			return null;
	}
}
