package dao;

import java.util.List;

import bean.Adres;

public interface AdresDAO {
	List<Adres> findAll();

	List<Adres> findById(int id);

	List<Adres> findByStraat(String straat);

	boolean insertAdres(Adres adres);

	boolean updateAdres(Adres adres);

	boolean deleteAdres(Adres adres);
}
