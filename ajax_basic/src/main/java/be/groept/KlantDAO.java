package be.groept;

import java.util.List;

public interface KlantDAO {
	List<Klant> findAll();

	List<Klant> findById();

	List<Klant> findByName();

	boolean insertKlant(Klant klant);

	boolean updateKlant(Klant klant);

	boolean deleteKlant(Klant klant);
}
