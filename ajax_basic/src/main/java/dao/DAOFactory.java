package dao;

public abstract class DAOFactory {
	public static final int MYSQL = 1;

	public abstract KlantDAO getKlantDAO();

	public abstract AdresDAO getAdresDAO();

	public abstract ContactDAO getContactDAO();

	public static DAOFactory getDAOFactory(int choice) {
		switch (choice) {
		case MYSQL:
			return new MySQLDAOFactory();
		default:
			return null;
		}
	}
}
