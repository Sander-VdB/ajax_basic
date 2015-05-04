package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Opdracht;

import com.mysql.jdbc.Statement;

public class MySQLOpdrachtDAO implements OpdrachtDAO {

	public MySQLOpdrachtDAO() {

	}

	@Override
	public List<Opdracht> findAll() {
		final String SQL_SELECT = "SELECT Id,K_Id, KorteOmschrijving,Omschrijving,Geopend,Afgesloten,Beheerder FROM Opdracht";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			ResultSet set = statementSelect.executeQuery();

			List<Opdracht> opdrachtLijst = new ArrayList<Opdracht>();
			while (set.next()) {
				Opdracht opdracht = new Opdracht();
				opdracht.setId(set.getInt("Id"));
				opdracht.getKlant().setId(set.getInt("K_id"));
				opdracht.setKorteOmschrijving(set.getString("KorteOmschrijving"));
				opdracht.setOmschrijving(set.getString("Omschrijving"));
				opdracht.setGeopend(set.getDate("Geopend"));
				opdracht.setAfgesloten(set.getDate("Afgesloten"));
				opdracht.setBeheerder(set.getString("Beheerder"));

				opdrachtLijst.add(opdracht);
			}
			return opdrachtLijst;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Opdracht> findById(int id) {
		final String SQL_SELECT = "SELECT Id,K_Id, KorteOmschrijving,Omschrijving,Geopend,Afgesloten,Beheerder FROM Opdracht WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setInt(1, id);
			ResultSet set = statementSelect.executeQuery();

			List<Opdracht> opdrachtLijst = new ArrayList<Opdracht>();
			while (set.next()) {
				Opdracht opdracht = new Opdracht();
				opdracht.setId(set.getInt("Id"));
				opdracht.getKlant().setId(set.getInt("K_id"));
				opdracht.setKorteOmschrijving(set.getString("KorteOmschrijving"));
				opdracht.setOmschrijving(set.getString("Omschrijving"));
				opdracht.setGeopend(set.getDate("Geopend"));
				opdracht.setAfgesloten(set.getDate("Afgesloten"));
				opdracht.setBeheerder(set.getString("Beheerder"));

				opdrachtLijst.add(opdracht);
			}
			return opdrachtLijst;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public List<Opdracht> findByName(String naam) {
		final String SQL_SELECT = "SELECT Id,K_id, KorteOmschrijving,Omschrijving,Geopend,Afgesloten,Beheerder FROM Opdracht WHERE KorteOmschrijving=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementSelect = connection.prepareStatement(SQL_SELECT)) {
			statementSelect.setString(1, naam);
			ResultSet set = statementSelect.executeQuery();

			List<Opdracht> opdrachtenLijst = new ArrayList<Opdracht>();
			while (set.next()) {
				Opdracht opdracht = new Opdracht();
				opdracht.setId(set.getInt("Id"));
				opdracht.getKlant().setId(set.getInt("K_id"));
				opdracht.setKorteOmschrijving(set.getString("KorteOmschrijving"));
				opdracht.setOmschrijving(set.getString("Omschrijving"));
				opdracht.setGeopend(set.getDate("Geopend"));
				opdracht.setAfgesloten(set.getDate("Afgesloten"));
				opdracht.setBeheerder(set.getString("Beheerder"));

				opdrachtenLijst.add(opdracht);
			}
			return opdrachtenLijst;
		} catch (SQLException ex) {
			System.console().printf(ex.getMessage());
		}
		return null;
	}

	@Override
	public int insertOpdracht(Opdracht opdracht) {
		final String SQL_INSERT = "INSERT INTO opdracht (K_Id, KorteOmschrijving,Omschrijving,Geopend,Afgesloten,Beheerder) VALUES (?,?,?,?,?,?)";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT, Statement.RETURN_GENERATED_KEYS)) {
			connection.setAutoCommit(false);
			statementInsert.setInt(1, opdracht.getKlant().getId());
			statementInsert.setString(2, opdracht.getKorteOmschrijving());
			statementInsert.setString(3, opdracht.getOmschrijving());
			statementInsert.setDate(4, new java.sql.Date(opdracht.getGeopend().getTime()));
			statementInsert.setDate(5, new java.sql.Date(opdracht.getAfgesloten().getTime()));
			statementInsert.setString(6, opdracht.getBeheerder());

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
	public boolean updateOpdracht(Opdracht opdracht) {
		final String SQL_UPDATE = "UPDATE Opdracht SET K_Id=?, KorteOmschrijving=?, Omschrijving=?, Geopend=?, Afgesloten=?, Beheerder=? WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementUpdate = connection.prepareStatement(SQL_UPDATE)) {
			connection.setAutoCommit(false);
			statementUpdate.setInt(1, opdracht.getKlant().getId());
			statementUpdate.setString(2, opdracht.getKorteOmschrijving());
			statementUpdate.setString(3, opdracht.getOmschrijving());
			statementUpdate.setDate(4, new java.sql.Date(opdracht.getGeopend().getTime()));
			statementUpdate.setDate(5, new java.sql.Date(opdracht.getAfgesloten().getTime()));
			statementUpdate.setString(6, opdracht.getBeheerder());
			statementUpdate.setInt(7, opdracht.getId());

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
	public boolean deleteOpdracht(Opdracht opdracht) {
		final String SQL_INSERT = "DELETE FROM Opdracht WHERE Id=?";
		try (Connection connection = MySQLDAOFactory.createConnection();
				PreparedStatement statementInsert = connection.prepareStatement(SQL_INSERT)) {
			connection.setAutoCommit(false);
			statementInsert.setInt(1, opdracht.getId());

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
