package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Contact;

import com.mysql.jdbc.Statement;

public class MySQLContactDAO implements ContactDAO {

	public MySQLContactDAO() {

	}

	@Override
	public List<Contact> findAll() {
		final String SQL_SELECT = "SELECT Id,contact,CT_id,K_id FROM Contact";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT);) {
			ResultSet set = statementSelect.executeQuery();

			List<Contact> contactList = new ArrayList<Contact>();
			while (set.next()) {
				Contact contact = new Contact();
				contact.setId(set.getInt("Id"));
				contact.setContact(set.getString("contact"));
				contact.setContactType(Contact.ContactType.values()[set.getInt("CT_id")]);

				contactList.add(contact);
			}

			return contactList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Contact> findById(int id) {
		final String SQL_SELECT = "SELECT Id,contact,CT_id,K_id FROM Contact WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setInt(1, id);
			ResultSet set = statementSelect.executeQuery();

			List<Contact> contactList = new ArrayList<Contact>();
			while (set.next()) {
				Contact contact = new Contact();
				contact.setId(set.getInt("Id"));
				contact.setContact(set.getString("contact"));
				contact.setContactType(Contact.ContactType.values()[set.getInt("CT_id")]);

				contactList.add(contact);
			}
			return contactList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Contact> findByValue(String value) {
		final String SQL_SELECT = "SELECT Id,contact,CT_id,K_id FROM Contact WHERE contact=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setString(1, value);
			ResultSet set = statementSelect.executeQuery();

			List<Contact> contactList = new ArrayList<Contact>();
			while (set.next()) {
				Contact contact = new Contact();
				contact.setId(set.getInt("Id"));
				contact.setContact(set.getString("contact"));
				contact.setContactType(Contact.ContactType.values()[set.getInt("CT_id")]);

				contactList.add(contact);
			}
			return contactList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public int insertContact(Contact contact) {
		final String SQL_INSERT = "INSERT INTO Contact (contact,CT_id,K_id) " + "VALUES (?,?,?)";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			connection.setAutoCommit(false);
			statementInsert.setString(1, contact.getContact());
			statementInsert.setInt(2, contact.getContactType().ordinal());
			statementInsert.setInt(3, contact.getKlant().getId());

			if (statementInsert.executeUpdate() == 1) {
				connection.commit();
				ResultSet keys = statementInsert.getGeneratedKeys();
				if (keys.next()) {
					return keys.getInt(1);
				}
			} else {
				connection.rollback();
			}

		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return -1;
	}

	@Override
	public boolean updateContact(Contact contact) {
		final String SQL_UPDATE = "UPDATE Contact SET contact=?,CT_id=? WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementUpdate = connection.prepareStatement(SQL_UPDATE)) {
			connection.setAutoCommit(false);
			statementUpdate.setString(1, contact.getContact());
			statementUpdate.setInt(2, contact.getContactType().ordinal());
			statementUpdate.setInt(3, contact.getId());

			if (statementUpdate.executeUpdate() == 1) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
			}

		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return false;
	}

	@Override
	public boolean deleteContact(Contact contact) {
		final String SQL_INSERT = "DELETE FROM Contact WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT)) {
			connection.setAutoCommit(false);
			statementInsert.setInt(1, contact.getId());

			if (statementInsert.executeUpdate() == 1) {
				connection.commit();
				return true;
			} else {
				connection.rollback();
			}
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return false;
	}
}
