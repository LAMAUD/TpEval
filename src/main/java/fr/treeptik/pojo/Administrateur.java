package fr.treeptik.pojo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.xml.bind.annotation.XmlAccessorType;

@Entity
@XmlAccessorType
@NamedQueries({ @NamedQuery(name = "findAllAdministrateurs", query = "SELECT a FROM Administrateur a") })
public class Administrateur extends Utilisateur implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public Administrateur() {

	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
