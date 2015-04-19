package bean;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ContactTest {

	private static String TESTCONTACTEMAIL = "email@test.be";
	private static Contact.ContactType TESTCONTACTTYPEEMAIL = Contact.ContactType.EMAIL;

	@Test
	public void testContact() {
		assertNotNull(new Contact());
	}

	@Test
	public void testContactContact() {
		Contact contact = new Contact();
		contact.setContact(TESTCONTACTEMAIL);
		contact.setContactType(TESTCONTACTTYPEEMAIL);
		Contact nieuweContact = new Contact(contact);
		assertNotNull(nieuweContact);
		assertTrue(nieuweContact.getContact().equals(contact.getContact()));
		assertTrue(nieuweContact.getContactType() == contact.getContactType());
	}

	@Test
	public void testEqualsObject() {
		Contact contact = new Contact();
		contact.setContact(TESTCONTACTEMAIL);
		contact.setContactType(TESTCONTACTTYPEEMAIL);

		Contact zelfdecontact = new Contact(contact);
		zelfdecontact.setId(contact.getId());

		assertTrue(contact.equals(zelfdecontact));
	}

}
