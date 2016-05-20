package daoTest;

import static org.junit.Assert.*;
import java.util.List;

import org.junit.Test;
import dao.*;
import dto.*;

public class MairieTest {

	@Test
	public void testCode() {
		CodesDAO codesDAO=new CodesDAO();

		List<Possibility> poss =codesDAO.getInstance().getPossFromPostal("27");
		assertEquals(poss.size(), 1);
		assertEquals(poss.get(0), 27);
		List<Possibility> poss2 =codesDAO.getInstance().getPossFromName("Rouen");
		assertEquals(poss.size(), 1);
		assertEquals(poss.get(0), "Rouen");
	}
	
	@Test
	public void testMairie() {
		//Mairie m = MairieDAO.getInstance().getMairieFromINSEE("41214", MairieTest.class.getProtectionDomain().getCodeSource().getLocation().getFile());
		
	}
}
