package bean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class KlantTest {

	private final String TESTNAME = "testCustomer";
	private final String TESTBTW = "123456789";

	@Test
	public void testKlant() {
		assertNotNull(new Adres());
	}

	@Test
	public void testKlantKlant() {
		Klant klant = new Klant();
		klant.setNaam(TESTNAME);
		klant.setBtw(TESTBTW);
		Klant nieuweKlant = new Klant(klant);
		assertNotNull(nieuweKlant);
		assertTrue(klant.getNaam() == nieuweKlant.getNaam());
		assertTrue(klant.getBtw().equals(nieuweKlant.getBtw()));
	}

	@Test
	public void testEquals() {
		// een klant is gelijk aan zichzelf
		Klant klant = new Klant();
		klant.setId(8);
		klant.setNaam(TESTNAME);
		klant.setBtw(TESTBTW);
		assertTrue(klant.equals(klant));
	}

}
