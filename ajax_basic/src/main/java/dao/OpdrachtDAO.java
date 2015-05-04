package dao;

import java.util.List;

import bean.Opdracht;

public interface OpdrachtDAO {
	List<Opdracht> findAll();

	List<Opdracht> findById(int id);

	List<Opdracht> findByName(String name);

	/**
	 * @param opdracht
	 * @return id of inserted opdracht
	 */
	int insertOpdracht(Opdracht opdracht);

	boolean updateOpdracht(Opdracht opdracht);

	boolean deleteOpdracht(Opdracht opdracht);
}
