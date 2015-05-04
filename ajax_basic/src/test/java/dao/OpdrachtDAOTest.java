package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

import bean.Klant;
import bean.Opdracht;

public class OpdrachtDAOTest {
	private final String TESTKORTEOMSCHRIJVING = "testKorteOmschrijving";
	private final String TESTOMSCHRIJVING = "testOmschrijving";
	private final String TESTBEHEERDER = "testBeheerder";
	private final Klant TESTKLANT = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getKlantDAO().findAll().get(0);
	private final Date TESTGEOPEND = new Date();
	private final Date TESTGESLOTEN = new Date();
	MySQLOpdrachtDAO dao = new MySQLOpdrachtDAO();

	@Test
	public void testMySQLOpdrachtDAO() {
		assertNotNull(dao);
	}

	@Test
	public void testFindAll() {
		assertNotNull(dao.findAll());
	}

	@Test
	public void testFindById() {
		Opdracht eersteopdracht = dao.findAll().get(0);
		Opdracht gevonden = dao.findById(eersteopdracht.getId()).get(0);
		assertTrue(eersteopdracht.equals(gevonden));
	}

	@Test
	public void testFindByName() {
		Opdracht eersteopdracht = dao.findAll().get(0);
		Opdracht gevonden = dao.findByName(eersteopdracht.getKorteOmschrijving()).get(0);
		assertTrue(eersteopdracht.equals(gevonden));
	}

	@Test
	public void testInsertOpdracht() {
		Opdracht testOpdracht = new Opdracht();
		testOpdracht.setKorteOmschrijving(TESTKORTEOMSCHRIJVING + "toinsert");
		testOpdracht.setOmschrijving(TESTOMSCHRIJVING);
		testOpdracht.setKlant(TESTKLANT);
		testOpdracht.setBeheerder(TESTBEHEERDER);
		testOpdracht.setGeopend(TESTGEOPEND);
		testOpdracht.setAfgesloten(TESTGESLOTEN);
		assertTrue(dao.findById(dao.insertOpdracht(testOpdracht)).get(0).equals(testOpdracht));
		testOpdracht = dao.findByName(TESTKORTEOMSCHRIJVING + "toinsert").get(0);
		dao.deleteOpdracht(testOpdracht);
	}

	@Test
	public void testUpdateOpdracht() {
		Opdracht newOpdracht = new Opdracht();
		newOpdracht.setKorteOmschrijving(TESTKORTEOMSCHRIJVING + "toupdate");
		newOpdracht.setOmschrijving(TESTOMSCHRIJVING);
		newOpdracht.setKlant(TESTKLANT);
		newOpdracht.setBeheerder(TESTBEHEERDER);
		newOpdracht.setGeopend(TESTGEOPEND);
		newOpdracht.setAfgesloten(TESTGESLOTEN);
		dao.insertOpdracht(newOpdracht);
		Opdracht testOpdracht = dao.findByName(TESTKORTEOMSCHRIJVING + "toupdate").get(0);
		testOpdracht.setOmschrijving(TESTBEHEERDER);
		dao.updateOpdracht(testOpdracht);
		testOpdracht = dao.findByName(TESTKORTEOMSCHRIJVING + "toupdate").get(0);
		assertTrue(testOpdracht.getOmschrijving().equals(TESTBEHEERDER));
		dao.deleteOpdracht(testOpdracht);
	}

	@Test
	public void testDeleteOpdracht() {
		Opdracht newOpdracht = new Opdracht();
		newOpdracht.setKorteOmschrijving(TESTKORTEOMSCHRIJVING + "todelete");
		newOpdracht.setOmschrijving(TESTOMSCHRIJVING);
		newOpdracht.setKlant(TESTKLANT);
		newOpdracht.setBeheerder(TESTBEHEERDER);
		newOpdracht.setGeopend(TESTGEOPEND);
		newOpdracht.setAfgesloten(TESTGESLOTEN);
		dao.insertOpdracht(newOpdracht);
		Opdracht testOpdracht = dao.findByName(TESTKORTEOMSCHRIJVING + "todelete").get(0);
		assertTrue(dao.deleteOpdracht(testOpdracht));
	}

}
