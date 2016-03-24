package fr.treeptik.dao;

import javax.ejb.Stateless;
import fr.treeptik.pojo.Session;

@Stateless
public class SessionDAOJPA extends GenericDAOJPA<Session, Integer>{
	
	public SessionDAOJPA(){
		super(Session.class);
	}

}
