package dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDAOFactory extends DAOFactory {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/ajax_basic";
	private static final String USER = "root";
	private static final String PASSWORD = "java";

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
	public KlantDAO getKlantDAO() {
		return new MySQLKlantDAO();
	}

	@Override
	public AdresDAO getAdresDAO() {
		return new MySQLAdresDAO();
	}

	@Override
	public ContactDAO getContactDAO() {
		return new MySQLContactDAO();
	}
}
