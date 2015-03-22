package bean;

import java.util.HashMap;

import util.ContactTypeNotFoundException;
import dao.DAOFactory;

public class Contact {

	private static HashMap<Integer, String> contactTypes = new HashMap<Integer, String>();

	private int id;
	private String contact;
	private int contactType;
	private Klant klant;

	public Contact() {
		DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO().updateLocalContactTypes();
		this.setId(-1);
	}

	public Contact(Contact _contact) throws ContactTypeNotFoundException {
		// TODO: exception when contacttype not available in contacttypes hashmap
		this.setContact(_contact.getContact());
		this.setContactType(_contact.getContactType());
		this.setId(-1);
	}

	public static HashMap<Integer, String> getContactTypes() {
		return contactTypes;
	}

	// public static void addContactType(String contactType) {
	// if (!Contact.contactTypes.containsValue(contactType)) {
	// Contact.contactTypes.put(Contact.contactTypes.size() + 1, contactType);
	// // DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO().updateContactTypes();
	// }
	// }

	public Klant getKlant() {
		return klant;
	}

	public void setKlant(Klant klant) {
		this.klant = klant;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public int getContactType() {
		return contactType;
	}

	public void setContactType(int contactType) throws ContactTypeNotFoundException {
		if (this.getContactTypes().containsKey(contactType)) {
			this.contactType = contactType;
		} else {
			throw new ContactTypeNotFoundException("specified contacttype not available");
		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object object) {
		if (object instanceof Contact) {
			Contact classobject = (Contact) object;
			return classobject.getId() == this.getId() && classobject.getContact().equals(this.getContact())
					&& classobject.getContactType() == this.getContactType();
		} else {
			return false;
		}
	}
}
