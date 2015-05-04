package dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import bean.Contact;
import bean.Klant;

public class ContactDAOTest {

	private final String TESTCONTACT = "test@email.be";
	private final Contact.ContactType TESTTYPE = Contact.ContactType.GSM;
	private final Contact.ContactType TESTTYPE2 = Contact.ContactType.EMAIL;
	private final Klant TESTKLANT = new Klant("test");
	ContactDAO dao = DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO();

	@Test
	public void testFindAll() {
		assertNotNull(dao.findAll());
	}

	@Test
	public void testFindById() {
		Contact eersteContact = dao.findAll().get(0);
		Contact gevonden = dao.findById(eersteContact.getId()).get(0);
		assertTrue(eersteContact.equals(gevonden));
	}

	@Test
	public void testFindByValue() {
		Contact eersteContact = dao.findAll().get(0);
		Contact gevonden = dao.findByValue(eersteContact.getContact()).get(0);
		assertTrue(eersteContact.equals(gevonden));
	}

	@Test
	public void testInsertContact() {
		Contact testContact = new Contact();
		testContact.setContact("insert" + TESTCONTACT);
		testContact.setContactType(TESTTYPE);
		testContact.setKlant(TESTKLANT);
		assertTrue(dao.findById(dao.insertContact(testContact)).get(0).equals(testContact));
		testContact = dao.findByValue("insert" + TESTCONTACT).get(0);
		dao.deleteContact(testContact);
	}

	@Test
	public void testUpdateContact() {
		Contact testContact = new Contact();
		testContact.setContact("toupdate" + TESTCONTACT);
		testContact.setContactType(TESTTYPE);
		testContact.setKlant(TESTKLANT);
		dao.insertContact(testContact);
		testContact = dao.findByValue("toupdate" + TESTCONTACT).get(0);
		testContact.setContactType(TESTTYPE2);
		dao.updateContact(testContact);
		testContact = dao.findByValue("toupdate" + TESTCONTACT).get(0);
		assertTrue(testContact.getContactType() == TESTTYPE2);
		dao.deleteContact(testContact);
	}

	@Test
	public void testDeleteContact() {
		Contact testContact = new Contact();
		testContact.setContact("todelete" + TESTCONTACT);
		testContact.setContactType(TESTTYPE);
		testContact.setKlant(TESTKLANT);
		dao.insertContact(testContact);
		testContact = dao.findByValue("todelete" + TESTCONTACT).get(0);
		assertTrue(dao.deleteContact(testContact));
	}

}
