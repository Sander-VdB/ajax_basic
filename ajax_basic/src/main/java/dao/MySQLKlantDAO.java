package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Klant;

public class MySQLKlantDAO implements KlantDAO {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/ajax_basic";
	private static final String USER = "root";
	private static final String PASSWORD = "java";

	public MySQLKlantDAO() {

	}

	public static Connection createConnection() {
		try {
			Class.forName(DRIVER).newInstance();
			return DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception ex) {
			ex.getMessage();
		}
		return null;
	}

	@Override
	public List<Klant> findAll() {
		final String SQL_SELECT = "SELECT * FROM Klant";
		try (Connection connection = this.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			ResultSet set = statementSelect.executeQuery();

			List<Klant> customerList = new ArrayList<Klant>();
			while (set.next()) {
				Klant customer = new Klant();
				customer.setId(set.getInt("Id"));
				customer.setNaam(set.getString("Naam"));
				customer.setBtw(set.getString("BTW"));

				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Klant> findById(int id) {
		final String SQL_SELECT = "SELECT * FROM Klant WHERE Id=?";
		try (Connection connection = this.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setInt(1, id);
			ResultSet set = statementSelect.executeQuery();

			List<Klant> customerList = new ArrayList<Klant>();
			while (set.next()) {
				Klant customer = new Klant();
				customer.setId(set.getInt("Id"));
				customer.setNaam(set.getString("Naam"));
				customer.setBtw(set.getString("BTW"));

				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Klant> findByName(String naam) {
		final String SQL_SELECT = "SELECT * FROM Klant WHERE Naam=?";
		try (Connection connection = this.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setString(1, naam);
			ResultSet set = statementSelect.executeQuery();

			List<Klant> customerList = new ArrayList<Klant>();
			while (set.next()) {
				Klant customer = new Klant();
				customer.setId(set.getInt("Id"));
				customer.setNaam(set.getString("Naam"));
				customer.setBtw(set.getString("BTW"));

				customerList.add(customer);
			}
			return customerList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean insertKlant(Klant klant) {
		final String SQL_INSERT = "INSERT INTO Klant (Naam, BTW) VALUES (?,?)";
		try (Connection connection = this.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT)) {
			connection.setAutoCommit(false);
			statementInsert.setString(1, klant.getNaam());
			statementInsert.setString(2, klant.getBtw());

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

	@Override
	public boolean updateKlant(Klant klant) {
		final String SQL_UPDATE = "UPDATE Klant SET Naam=?, BTW=? WHERE Id=?";
		try (Connection connection = this.createConnection();
				PreparedStatement statementUpdate = connection.prepareStatement(SQL_UPDATE)) {
			connection.setAutoCommit(false);
			statementUpdate.setString(1, klant.getNaam());
			statementUpdate.setString(2, klant.getBtw());
			statementUpdate.setInt(3, klant.getId());

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
	public boolean deleteKlant(Klant klant) {
		final String SQL_INSERT = "DELETE FROM Klant WHERE Id=?";
		try (Connection connection = this.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT)) {
			connection.setAutoCommit(false);
			statementInsert.setInt(1, klant.getId());

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
