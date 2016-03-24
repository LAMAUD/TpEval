package fr.treeptik.dao;


import javax.ejb.Stateless;

import fr.treeptik.dao.GenericDAOJPA;
import fr.treeptik.pojo.Administrateur;

@Stateless
public class AdministrateurDAOJPA extends
		GenericDAOJPA<Administrateur, Integer> {
	
	public AdministrateurDAOJPA(){
		super(Administrateur.class);
	}

}
