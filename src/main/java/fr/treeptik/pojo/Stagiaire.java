package fr.treeptik.pojo;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@NamedQueries({ @NamedQuery(name = "findAllStagiaires", query = "SELECT a FROM Stagiaire a") })
public class Stagiaire extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Stagiaire() {

	}

	@ManyToMany
	//@LazyCollection(LazyCollectionOption.FALSE)
	private List<Session> sessions;
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}

	@Override
	public String toString() {
		return  nom + " " + prenom + " (Stagiaire)";
	}

	
	

}
