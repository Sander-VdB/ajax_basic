package dao;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class DAOFactoryTest {

	@Test
	public void testDAOFactoryMySQL() {
		assertNotNull(DAOFactory.getDAOFactory(DAOFactory.MYSQL));
	}

	@Test
	public void testDAOFactorygetKlantDAOMySQL() {
		assertNotNull(DAOFactory.getDAOFactory(DAOFactory.MYSQL).getKlantDAO());
	}

	@Test
	public void testDAOFactorygetContactDAOMySQL() {
		assertNotNull(DAOFactory.getDAOFactory(DAOFactory.MYSQL).getContactDAO());
	}

	@Test
	public void testDAOFactorygetAdresDAOMySQL() {
		assertNotNull(DAOFactory.getDAOFactory(DAOFactory.MYSQL).getAdresDAO());
	}

	@Test
	public void testDAOFactorygetOpdrachtDAOMySQL() {
		assertNotNull(DAOFactory.getDAOFactory(DAOFactory.MYSQL).getOpdrachtDAO());
	}
}
