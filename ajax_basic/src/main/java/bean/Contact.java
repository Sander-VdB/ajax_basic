package bean;

public class Contact {

	// private static HashMap<Integer, String> contactTypes = new HashMap<Integer, String>();
	public static enum ContactType {
		GSM, VAST, EMAIL
	}

	private int id;
	private String contact;
	private ContactType contactType;
	private Klant klant;

	public Contact() {
		this.setId(-1);
		this.klant = new Klant();
	}

	public Contact(Contact _contact) {
		this.setContact(_contact.getContact());
		this.setContactType(_contact.getContactType());
		this.setId(-1);
	}

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

	public ContactType getContactType() {
		return contactType;
	}

	public void setContactType(ContactType contactType) {
		this.contactType = contactType;
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
			return classobject.getContact().equals(this.getContact()) && classobject.getContactType() == this.getContactType();
		} else {
			return false;
		}
	}
}
