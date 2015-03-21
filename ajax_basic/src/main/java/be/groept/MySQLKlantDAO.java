package be.groept;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateKlant(Klant klant) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteKlant(Klant klant) {
		// TODO Auto-generated method stub
		return false;
	}

}
