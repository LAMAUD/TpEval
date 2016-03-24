package fr.treeptik.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;


import fr.treeptik.dao.AdministrateurDAOJPA;
import fr.treeptik.pojo.Administrateur;


@Stateless
public class AdministrateurServiceImpl {

	@EJB
	private AdministrateurDAOJPA dao;

	
	public List<Administrateur> findAll() {
		return dao.findAll();
	}

	
	public Administrateur create(Administrateur administrateur) {
		return dao.save(administrateur);
	}

	
	public Administrateur delete(Integer id) {
		Administrateur admin = null;
		
			admin = dao.delete(id);

		return admin;
	}

}
