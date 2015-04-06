package dao;

import java.util.List;

import bean.Contact;

public interface ContactDAO {
	List<Contact> findAll();

	List<Contact> findById(int id);

	List<Contact> findByValue(String value);

	/**
	 * @param contact
	 * @return id of inserted contact
	 */
	int insertContact(Contact contact);

	boolean updateContact(Contact contact);

	boolean deleteContact(Contact contact);
}
