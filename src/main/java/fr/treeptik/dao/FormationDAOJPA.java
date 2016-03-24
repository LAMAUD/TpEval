package fr.treeptik.dao;

import javax.ejb.Stateless;
import fr.treeptik.pojo.Formation;

@Stateless
public class FormationDAOJPA extends GenericDAOJPA<Formation, Integer>
		 {

	public FormationDAOJPA(){
		super(Formation.class);
	}
}
