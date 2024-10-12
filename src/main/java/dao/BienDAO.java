package dao;

import java.util.List;

import beans.Bien;

public interface BienDAO {
	
	public List<Bien> getBiensByCategory(int categoryId)throws DaoException;
}
