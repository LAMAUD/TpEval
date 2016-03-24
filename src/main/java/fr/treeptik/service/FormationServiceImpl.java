package fr.treeptik.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import fr.treeptik.dao.FormationDAOJPA;
import fr.treeptik.pojo.Formation;


@Stateless
public class FormationServiceImpl  {

	@EJB
	private FormationDAOJPA dao;

	
	public List<Formation> findAll() {
		return dao.findAll();
	}

	
	public Formation create(Formation formation) {
		return dao.save(formation);
	}

	public Formation delete(Integer id) {
		return dao.delete(id);
	}
	
	public Formation findOne(Integer id) {
		return dao.findOne(id);
	}
}
