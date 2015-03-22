package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bean.Klant;

public class KlantDAOTest {
	private final String TESTNAME = "testCustomer";
	private final String TESTBTW = "123456789";
	private final String TESTBTW1 = "0000001234";

	@Test
	public void testMySQLKlantDAO() {
		assertNotNull(new MySQLKlantDAO());
	}

	@Test
	public void testFindAll() {
		assertNotNull(new MySQLKlantDAO().findAll());
	}

	@Test
	public void testFindById() {
		Klant eersteklant = new MySQLKlantDAO().findAll().get(0);
		Klant gevonden = new MySQLKlantDAO().findById(eersteklant.getId()).get(0);
		assertTrue(eersteklant.equals(gevonden));
	}

	@Test
	public void testFindByName() {
		Klant eersteklant = new MySQLKlantDAO().findAll().get(0);
		Klant gevonden = new MySQLKlantDAO().findByName(eersteklant.getNaam()).get(0);
		assertTrue(eersteklant.equals(gevonden));
	}

	@Test
	public void testInsertKlant() {
		MySQLKlantDAO dao = new MySQLKlantDAO();
		Klant testKlant = new Klant();
		testKlant.setNaam(TESTNAME + "insert");
		testKlant.setBtw(TESTBTW);
		assertTrue(dao.insertKlant(testKlant));
		testKlant = dao.findByName(TESTNAME + "insert").get(0);
		dao.deleteKlant(testKlant);
	}

	@Test
	public void testUpdateKlant() {
		MySQLKlantDAO dao = new MySQLKlantDAO();
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
		MySQLKlantDAO dao = new MySQLKlantDAO();
		Klant newKlant = new Klant();
		newKlant.setNaam(TESTNAME + "delete");
		newKlant.setBtw(TESTBTW);
		dao.insertKlant(newKlant);
		Klant testKlant = dao.findByName(TESTNAME + "delete").get(0);
		assertTrue(dao.deleteKlant(testKlant));
	}

}
