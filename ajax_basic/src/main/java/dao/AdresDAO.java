package dao;

import java.util.List;

import bean.Adres;

public interface AdresDAO {
	List<Adres> findAll();

	List<Adres> findById(int id);

	List<Adres> findByStraat(String straat);

	/**
	 * @param adres
	 * @return id of inserted address
	 */
	int insertAdres(Adres adres);

	boolean updateAdres(Adres adres);

	boolean deleteAdres(Adres adres);
}
