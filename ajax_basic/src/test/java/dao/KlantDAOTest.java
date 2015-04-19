package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bean.Adres;
import bean.Klant;

public class KlantDAOTest {
	private final String TESTNAME = "testCustomer";
	private final String TESTBTW = "123456789";
	private final String TESTBTW1 = "0000001234";
	private final Adres TESTFACTURATIEADRES = new Adres();
	private final Adres TESTAFLEVERADRES = new Adres();
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
		testKlant.setNaam(TESTNAME + "toinsert");
		testKlant.setBtw(TESTBTW);
		testKlant.setFacturatieadres(TESTFACTURATIEADRES);
		testKlant.setAfleveradres(TESTAFLEVERADRES);
		assertTrue(dao.findById(dao.insertKlant(testKlant)).get(0).equals(testKlant));
		testKlant = dao.findByName(TESTNAME + "toinsert").get(0);
		dao.deleteKlant(testKlant);
	}

	@Test
	public void testUpdateKlant() {
		Klant newKlant = new Klant();
		newKlant.setNaam(TESTNAME + "toupdate");
		newKlant.setBtw(TESTBTW);
		newKlant.setFacturatieadres(TESTFACTURATIEADRES);
		newKlant.setAfleveradres(TESTAFLEVERADRES);
		dao.insertKlant(newKlant);
		Klant testKlant = dao.findByName(TESTNAME + "toupdate").get(0);
		testKlant.setBtw(TESTBTW1);
		dao.updateKlant(testKlant);
		testKlant = dao.findByName(TESTNAME + "toupdate").get(0);
		assertTrue(testKlant.getBtw().equals(TESTBTW1));
		dao.deleteKlant(testKlant);
	}

	@Test
	public void testDeleteKlant() {
		Klant newKlant = new Klant();
		newKlant.setNaam(TESTNAME + "todelete");
		newKlant.setBtw(TESTBTW);
		newKlant.setFacturatieadres(TESTFACTURATIEADRES);
		newKlant.setAfleveradres(TESTAFLEVERADRES);
		dao.insertKlant(newKlant);
		Klant testKlant = dao.findByName(TESTNAME + "todelete").get(0);
		assertTrue(dao.deleteKlant(testKlant));
	}

}
