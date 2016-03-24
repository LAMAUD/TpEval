package fr.treeptik.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import fr.treeptik.dao.SessionDAOJPA;
import fr.treeptik.pojo.Session;

@Stateless
public class SessionServiceImpl {

	@EJB
	private SessionDAOJPA dao;

	
	public List<Session> findAll() {
		return dao.findAll();
	}

	
	public Session findOne(Integer id) {
		Session session = null;
	
			session = dao.findOne(id);
		
		return session;
	}


	public Session create(Session session) {
		return dao.save(session);
	}
	
	public void delete(Integer id) {
		 dao.delete(id);
	}

}
