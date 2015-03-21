package be.groept;

import java.sql.DriverManager;
import java.util.List;

public class MySQLKlantDAO implements KlantDAO {
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost/ajax_basic";
	private static final String USER = "root";
	private static final String PASSWORD = "java";

	public MySQLKlantDAO() {
		try {
			Class.forName(DRIVER).newInstance();
			DriverManager.getConnection(URL, USER, PASSWORD);
		} catch (Exception ex) {
			// TODO
		}
	}

	public List<Klant> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Klant> findById() {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Klant> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean insertKlant(Klant klant) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean updateKlant(Klant klant) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean deleteKlant(Klant klant) {
		// TODO Auto-generated method stub
		return false;
	}

}
