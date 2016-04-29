package dao;
import java.util.List;
import dto.Mairie;

public class MairieDAO {

	private static MairieDAO singleton;
	
	public static MairieDAO getInstance() {
		if (MairieDAO.singleton == null)
			singleton = new MairieDAO();
		return singleton;
	}
	
	
	//Mairie(String adresse, String mail, String site, String iNSEE, String codePostal, String telephone,  List<String> horaire
	public Mairie getMairieFromINSEE(String INSEE){
		String adresse = "";
		String mail = "";
		String site = "";
		String codePostal = "";
		String telephone = "";
		List<String> horaires = null;
		String chemin = "";
		
		chemin += "../../data/theFiles/organismes/" ;
		
		String dos = INSEE.substring(0,2);
		if(dos.equals("97") || dos.equals("98"))
			dos = INSEE.substring(0,3);
		
		chemin += dos;
		
		Mairie mairie = new Mairie(adresse, mail, site, INSEE, codePostal, telephone, horaires);
		
		
		return mairie;
	}
	
	
}
