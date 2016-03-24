package fr.treeptik.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQueries({ @NamedQuery(name = "findAllFormateurs", query = "SELECT a FROM Formateur a") })
public class Formateur extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Formateur() {

	}
	
	@OneToMany(mappedBy="formateur", fetch=FetchType.EAGER)
	private List<Formation> formations;

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return  nom + " " + prenom;
	}

	
	
}
