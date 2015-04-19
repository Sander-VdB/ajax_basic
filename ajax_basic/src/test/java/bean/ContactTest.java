package bean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import util.ContactTypeNotFoundException;
import dao.DAOFactory;

public class ContactTest {

	private static String TESTCONTACTEMAIL = "email@test.be";
	private static int TESTCONTACTTYPEEMAIL = 0;

	@Test
	public void testContact() {
		assertNotNull(new Contact());
	}

	@Test
	public void testContactContact() throws ContactTypeNotFoundException {
		DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO().updateLocalContactTypes();
		Contact contact = new Contact();
		contact.setContact(TESTCONTACTEMAIL);
		contact.setContactType(TESTCONTACTTYPEEMAIL);
		Contact nieuweContact = new Contact(contact);
		assertNotNull(nieuweContact);
		assertTrue(nieuweContact.getContact().equals(contact.getContact()));
		Contact.getContactTypes();
		assertTrue(nieuweContact.getContactType() == contact.getContactType());
	}

	@Test(expected = ContactTypeNotFoundException.class)
	public void testSetContactType() throws ContactTypeNotFoundException {
		DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO().updateLocalContactTypes();
		int falseContactType = Contact.getContactTypes().keySet().size() + 1000;
		Contact contact = new Contact();
		contact.setContactType(falseContactType);
	}

	@Test
	public void testEqualsObject() throws ContactTypeNotFoundException {
		DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO().updateLocalContactTypes();
		Contact contact = new Contact();
		contact.setContact(TESTCONTACTEMAIL);
		contact.setContactType(TESTCONTACTTYPEEMAIL);

		Contact zelfdecontact = new Contact(contact);
		zelfdecontact.setId(contact.getId());

		assertTrue(contact.equals(zelfdecontact));
	}

}
