package fr.treeptik.dao;

import javax.ejb.Stateless;


import fr.treeptik.pojo.Stagiaire;

@Stateless
public class StagiaireDAOJPA extends GenericDAOJPA<Stagiaire, Integer> {
	
	public StagiaireDAOJPA(){
		super(Stagiaire.class);
	}

}
