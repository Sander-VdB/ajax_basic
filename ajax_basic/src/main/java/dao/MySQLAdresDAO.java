package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Adres;

public class MySQLAdresDAO implements AdresDAO {

	public MySQLAdresDAO() {

	}

	@Override
	public List<Adres> findAll() {
		final String SQL_SELECT = "SELECT * FROM Adres";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			ResultSet set = statementSelect.executeQuery();

			List<Adres> addressList = new ArrayList<Adres>();
			while (set.next()) {
				Adres address = new Adres();
				address.setId(set.getInt("Id"));
				address.setStraat(set.getString("Straat"));
				address.setNr(set.getString("Nr"));
				address.setPostcode(set.getString("Postcode"));
				address.setWoonplaats(set.getString("Woonplaats"));
				address.setLand(set.getString("Land"));
				address.setActief(set.getBoolean("Actief"));

				addressList.add(address);
			}
			return addressList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Adres> findById(int id) {
		final String SQL_SELECT = "SELECT * FROM Adres WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setInt(1, id);
			ResultSet set = statementSelect.executeQuery();

			List<Adres> addressList = new ArrayList<Adres>();
			while (set.next()) {
				Adres address = new Adres();
				address.setId(set.getInt("Id"));
				address.setStraat(set.getString("Straat"));
				address.setNr(set.getString("Nr"));
				address.setPostcode(set.getString("Postcode"));
				address.setWoonplaats(set.getString("Woonplaats"));
				address.setLand(set.getString("Land"));
				address.setActief(set.getBoolean("Actief"));

				addressList.add(address);
			}
			return addressList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Adres> findByStraat(String straat) {
		final String SQL_SELECT = "SELECT * FROM Adres WHERE Straat=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setString(1, straat);
			ResultSet set = statementSelect.executeQuery();

			List<Adres> addressList = new ArrayList<Adres>();
			while (set.next()) {
				Adres address = new Adres();
				address.setId(set.getInt("Id"));
				address.setStraat(set.getString("Straat"));
				address.setNr(set.getString("Nr"));
				address.setPostcode(set.getString("Postcode"));
				address.setWoonplaats(set.getString("Woonplaats"));
				address.setLand(set.getString("Land"));
				address.setActief(set.getBoolean("Actief"));

				addressList.add(address);
			}
			return addressList;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public boolean insertAdres(Adres address) {
		final String SQL_INSERT = "INSERT INTO Adres (Straat, Nr, Postcode, Woonplaats, Land, Actief) " + "VALUES (?,?,?,?,?,?)";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT)) {
			connection.setAutoCommit(false);
			statementInsert.setString(1, address.getStraat());
			statementInsert.setString(2, address.getNr());
			statementInsert.setString(3, address.getPostcode());
			statementInsert.setString(4, address.getWoonplaats());
			statementInsert.setString(5, address.getLand());
			statementInsert.setBoolean(6, address.isActief());

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
	public boolean updateAdres(Adres address) {
		final String SQL_UPDATE = "UPDATE Adres SET Straat=?, Nr=?, Postcode=?, Woonplaats=?, Land=?, Actief=? WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementUpdate = connection.prepareStatement(SQL_UPDATE)) {
			connection.setAutoCommit(false);
			statementUpdate.setString(1, address.getStraat());
			statementUpdate.setString(2, address.getNr());
			statementUpdate.setString(3, address.getPostcode());
			statementUpdate.setString(4, address.getWoonplaats());
			statementUpdate.setString(5, address.getLand());
			statementUpdate.setBoolean(6, address.isActief());
			statementUpdate.setInt(7, address.getId());

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
	public boolean deleteAdres(Adres address) {
		final String SQL_INSERT = "DELETE FROM Adres WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT)) {
			connection.setAutoCommit(false);
			statementInsert.setInt(1, address.getId());

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
