package fr.treeptik.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.treeptik.pojo.Administrateur;
import fr.treeptik.service.AdministrateurServiceImpl;


@ManagedBean
@RequestScoped
public class AdministrateurController {
	
	@EJB
	private AdministrateurServiceImpl service;

	private Administrateur administrateur = new Administrateur();
	private List<Administrateur> administrateurs;


	public String admin(){
		return "/protected/administrateur/admin?faces-redirect=true";
	}
	
	public String doSave() {
		administrateur=this.service.create(administrateur);
		
		
		return "login?faces-redirect=true";
	}

	public String doDelete(Administrateur administrateur) {
	
			this.service.delete(administrateur.getId());

		return "/protected/administrateur/admin?faces-redirect=true";
	}

	@PostConstruct
	public void listAll(){
		administrateurs=service.findAll();
	}

	public List<Administrateur> getAdministrateurs() {
		return administrateurs;
	}

	public void setAdministrateurs(List<Administrateur> administrateurs) {
		this.administrateurs = administrateurs;
	}

	public Administrateur getAdministrateur() {
		return administrateur;
	}

	public void setAdministrateur(Administrateur administrateur) {
		this.administrateur = administrateur;
	}

}
