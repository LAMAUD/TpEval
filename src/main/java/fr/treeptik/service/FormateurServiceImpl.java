package fr.treeptik.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.transaction.Transactional;

import fr.treeptik.dao.FormateurDAOJPA;
import fr.treeptik.pojo.Formateur;


@Stateless
public class FormateurServiceImpl {

	@EJB
	private FormateurDAOJPA dao;

	
	public List<Formateur> findAll() {
		return dao.findAll();
	}

	@Transactional
	public Formateur create(Formateur formateur) {
		return dao.save(formateur);
	}

	@Transactional
	public Formateur delete(Integer id) {
		Formateur formateur = null;
		
			formateur = dao.delete(id);

		return formateur;
	}

	
	public Formateur findOne(Integer id) {
		Formateur formateur = null;
			formateur = dao.findOne(id);

		return formateur;
	}

}
