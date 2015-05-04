package bean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class OpdrachtTest {

	private final String TESTKORTEOMSCHRIJVING = "testKorteOmschrijving";
	private final String TESTOMSCHRIJVING = "testOmschrijving";
	private final String TESTBEHEERDER = "testBeheerder";

	@Test
	public void testOpdracht() {
		assertNotNull(new Opdracht());
	}

	@Test
	public void testOpdrachtStringStringString() {
		assertNotNull(new Opdracht(TESTKORTEOMSCHRIJVING, TESTOMSCHRIJVING, TESTBEHEERDER));
	}

	@Test
	public void testOpdrachtOpdracht() {
		Opdracht opdracht = new Opdracht();
		opdracht.setKorteOmschrijving(TESTKORTEOMSCHRIJVING);
		opdracht.setOmschrijving(TESTOMSCHRIJVING);
		opdracht.setBeheerder(TESTBEHEERDER);
		Opdracht nieuweOpdracht = new Opdracht(opdracht);
		assertNotNull(nieuweOpdracht);
		assertTrue(opdracht.getKorteOmschrijving() == nieuweOpdracht.getKorteOmschrijving());
		assertTrue(opdracht.getOmschrijving().equals(nieuweOpdracht.getOmschrijving()));
		assertTrue(opdracht.getBeheerder().equals(nieuweOpdracht.getBeheerder()));
	}

	@Test
	public void testEqualsObject() {
		// Opdracht gelijk aan zichzelf
		Opdracht opdracht = new Opdracht();
		opdracht.setId(8);
		opdracht.setKorteOmschrijving(TESTKORTEOMSCHRIJVING);
		opdracht.setOmschrijving(TESTOMSCHRIJVING);
		opdracht.setBeheerder(TESTBEHEERDER);
		assertTrue(opdracht.equals(opdracht));
	}

}
