package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bean.Adres;

public class AdresDAOTest {
	private final String TESTSTRAAT = "teststraat";
	private final String TESTNR = "123456789";
	private final String TESTNR1 = "0000001234";
	private final String TESTPOSTCODE = "3000";
	private final String TESTWOONPLAATS = "Woonplaats";
	private final String TESTLAND = "Land";
	private final boolean TESTACTIEF = true;

	AdresDAO dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getAdresDAO();

	@Test
	public void testMySQLAdresDAO() {
		assertNotNull(dao);
	}

	@Test
	public void testFindAll() {
		assertNotNull(dao.findAll());
	}

	@Test
	public void testFindById() {
		Adres eersteAdres = dao.findAll().get(0);
		Adres gevonden = dao.findById(eersteAdres.getId()).get(0);
		assertTrue(eersteAdres.equals(gevonden));
	}

	@Test
	public void testFindBySTRAAT() {
		Adres eersteAdres = dao.findAll().get(0);
		Adres gevonden = dao.findByStraat(eersteAdres.getStraat()).get(0);
		assertTrue(eersteAdres.equals(gevonden));
	}

	@Test
	public void testInsertAdres() {
		Adres testAdres = new Adres();
		testAdres.setStraat(TESTSTRAAT + "insert");
		testAdres.setNr(TESTNR);
		testAdres.setPostcode(TESTPOSTCODE);
		testAdres.setWoonplaats(TESTWOONPLAATS);
		testAdres.setLand(TESTLAND);
		testAdres.setActief(TESTACTIEF);
		assertTrue(dao.findById(dao.insertAdres(testAdres)).get(0).equals(testAdres));
		testAdres = dao.findByStraat(TESTSTRAAT + "insert").get(0);
		dao.deleteAdres(testAdres);
	}

	@Test
	public void testUpdateAdres() {
		Adres newAdres = new Adres();
		newAdres.setStraat(TESTSTRAAT + "update");
		newAdres.setNr(TESTNR);
		newAdres.setPostcode(TESTPOSTCODE);
		newAdres.setWoonplaats(TESTWOONPLAATS);
		newAdres.setLand(TESTLAND);
		newAdres.setActief(TESTACTIEF);
		dao.insertAdres(newAdres);
		Adres testAdres = dao.findByStraat(TESTSTRAAT + "update").get(0);
		testAdres.setNr(TESTNR1);
		dao.updateAdres(testAdres);
		testAdres = dao.findByStraat(TESTSTRAAT + "update").get(0);
		assertTrue(testAdres.getNr().equals(TESTNR1));
		dao.deleteAdres(testAdres);
	}

	@Test
	public void testDeleteAdres() {
		Adres newAdres = new Adres();
		newAdres.setStraat(TESTSTRAAT + "delete");
		newAdres.setNr(TESTNR);
		newAdres.setPostcode(TESTPOSTCODE);
		newAdres.setWoonplaats(TESTWOONPLAATS);
		newAdres.setLand(TESTLAND);
		newAdres.setActief(TESTACTIEF);
		dao.insertAdres(newAdres);
		Adres testAdres = dao.findByStraat(TESTSTRAAT + "delete").get(0);
		assertTrue(dao.deleteAdres(testAdres));
	}

}
