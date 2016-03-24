package fr.treeptik.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;


import fr.treeptik.dao.StagiaireDAOJPA;
import fr.treeptik.pojo.Stagiaire;


@Stateless
public class StagiaireServiceImpl {

	@EJB
	private StagiaireDAOJPA dao;

	
	public List<Stagiaire> findAll() {
		return dao.findAll();
	}

	
	@Transactional
	public Stagiaire create(Stagiaire stagiaire) {
		return dao.save(stagiaire);
	}

	@Transactional
	public Stagiaire delete(Integer id){
		Stagiaire stagiaire = null;
		
			stagiaire = dao.delete(id);

		return stagiaire;
	}

}
