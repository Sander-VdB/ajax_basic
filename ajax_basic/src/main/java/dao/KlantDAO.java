package dao;

import java.util.List;

import bean.Klant;

public interface KlantDAO {
	List<Klant> findAll();

	List<Klant> findById(int id);

	List<Klant> findByName(String name);

	boolean insertKlant(Klant klant);

	boolean updateKlant(Klant klant);

	boolean deleteKlant(Klant klant);
}
