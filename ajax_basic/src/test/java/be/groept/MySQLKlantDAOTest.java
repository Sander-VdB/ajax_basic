package be.groept;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class MySQLKlantDAOTest {
	private final String TESTNAME = "JOSKE01";
	private final String TESTBTW = "123456789";
	private final String TESTBTW1 = "0000001234";

	@Test
	public void testMySQLKlantDAO() {
		assertNotNull(new MySQLKlantDAO());
	}

	@Test
	public void testCreateConnection() {
		assertNotNull(MySQLKlantDAO.createConnection());
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
		testKlant.setNaam(TESTNAME);
		testKlant.setBtw(TESTBTW);
		assertTrue(dao.insertKlant(testKlant));
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
		newKlant.setNaam(TESTNAME + "update");
		newKlant.setBtw(TESTBTW);
		dao.insertKlant(newKlant);
		Klant testKlant = dao.findByName(TESTNAME).get(0);
		assertTrue(dao.deleteKlant(testKlant));
	}

	@Test
	public void testEquals() {
		// een klant is gelijk aan zichzelf
		Klant klant = new Klant();
		klant.setId(8);
		klant.setNaam("jos");
		klant.setBtw("123456789");
		assertTrue(klant.equals(klant));
	}
}
