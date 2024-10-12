package dao;

import java.util.List;

import beans.Categorie;

public interface CategoryDAO {
	List<Categorie> getAllCategories()throws DaoException;
	Categorie getCategoryById(int categorieId)throws DaoException;
    void addCategory(Categorie categorie)throws DaoException;
    void updateCategory(Categorie categorie) throws DaoException;
    void deleteCategory(int categorieId)throws DaoException;
}
