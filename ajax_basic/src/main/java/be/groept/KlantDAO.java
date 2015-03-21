package be.groept;

import java.util.List;

public interface KlantDAO {
	List<Klant> findAll();

	List<Klant> findById(int id);

	List<Klant> findByName(String name);

	boolean insertKlant(Klant klant);

	boolean updateKlant(Klant klant);

	boolean deleteKlant(Klant klant);
}
