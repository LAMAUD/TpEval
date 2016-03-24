package fr.treeptik.dao;

import javax.ejb.Stateless;
import fr.treeptik.pojo.Formateur;

@Stateless
public class FormateurDAOJPA extends GenericDAOJPA<Formateur, Integer>{

	public FormateurDAOJPA(){
		super(Formateur.class);
	}
}
