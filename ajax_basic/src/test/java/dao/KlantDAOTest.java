package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bean.Klant;

public class KlantDAOTest {
	private final String TESTNAME = "testCustomer";
	private final String TESTBTW = "123456789";
	private final String TESTBTW1 = "0000001234";
	MySQLKlantDAO dao = new MySQLKlantDAO();

	@Test
	public void testMySQLKlantDAO() {
		assertNotNull(dao);
	}

	@Test
	public void testFindAll() {
		assertNotNull(dao.findAll());
	}

	@Test
	public void testFindById() {
		Klant eersteklant = dao.findAll().get(0);
		Klant gevonden = dao.findById(eersteklant.getId()).get(0);
		assertTrue(eersteklant.equals(gevonden));
	}

	@Test
	public void testFindByName() {
		Klant eersteklant = dao.findAll().get(0);
		Klant gevonden = dao.findByName(eersteklant.getNaam()).get(0);
		assertTrue(eersteklant.equals(gevonden));
	}

	@Test
	public void testInsertKlant() {
		Klant testKlant = new Klant();
		testKlant.setNaam(TESTNAME + "insert");
		testKlant.setBtw(TESTBTW);
		assertTrue(dao.insertKlant(testKlant));
		testKlant = dao.findByName(TESTNAME + "insert").get(0);
		dao.deleteKlant(testKlant);
	}

	@Test
	public void testUpdateKlant() {
		Klant newKlant = new Klant();
		newKlant.setNaam(TESTNAME + "update");
		newKlant.setBtw(TESTBTW);
		dao.insertKlant(newKlant);
		Klant testKlant = dao.findByName(TESTNAME + "update").get(0);
		testKlant.setBtw(TESTBTW1);
		dao.updateKlant(testKlant);
		testKlant = dao.findByName(TESTNAME + "update").get(0);
		assertTrue(testKlant.getBtw().equals(TESTBTW1));
		dao.deleteKlant(testKlant);
	}

	@Test
	public void testDeleteKlant() {
		Klant newKlant = new Klant();
		newKlant.setNaam(TESTNAME + "delete");
		newKlant.setBtw(TESTBTW);
		dao.insertKlant(newKlant);
		Klant testKlant = dao.findByName(TESTNAME + "delete").get(0);
		assertTrue(dao.deleteKlant(testKlant));
	}

}
