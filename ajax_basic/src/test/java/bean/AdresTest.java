package bean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AdresTest {

	@Test
	public void testAdres() {
		assertNotNull(new Adres());
	}

	@Test
	public void testAdresAdres() {
		Adres adres = new Adres();
		adres.setActief(true);
		adres.setLand("Land");
		adres.setNr("1a");
		adres.setPostcode("3200");
		adres.setStraat("straatnaam");
		adres.setWoonplaats("Woonplaats");
		Adres nieuwAdres = new Adres(adres);
		assertNotNull(nieuwAdres);
		assertTrue(adres.isActief() == nieuwAdres.isActief());
		assertTrue(adres.getLand().equals(nieuwAdres.getLand()));
		assertTrue(adres.getNr().equals(nieuwAdres.getNr()));
		assertTrue(adres.getPostcode().equals(nieuwAdres.getPostcode()));
		assertTrue(adres.getStraat().equals(nieuwAdres.getStraat()));
		assertTrue(adres.getWoonplaats().equals(nieuwAdres.getWoonplaats()));
	}

	@Test
	public void testEqualsObject() {
		Adres adres = new Adres();
		adres.setActief(true);
		adres.setId(1);
		adres.setLand("Land");
		adres.setNr("1a");
		adres.setPostcode("3000");
		adres.setStraat("straatnaam");
		adres.setWoonplaats("Woonplaats");

		Adres zelfdeadres = new Adres(adres);
		zelfdeadres.setId(adres.getId());

		assertTrue(adres.equals(zelfdeadres));
	}

}
