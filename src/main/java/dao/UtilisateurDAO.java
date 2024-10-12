package dao;

import java.util.List;

import beans.Utilisateur;

public interface UtilisateurDAO {
 
	 public List<Utilisateur> lister() throws DaoException;
	 public void CreateUserAccount(Utilisateur a)  throws DaoException;
	 public Utilisateur authenticate(String username, String password) throws DaoException;
	 public void deleteUser(int userId) throws DaoException;
         
}