package fr.treeptik.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.servlet.ServletException;

import fr.treeptik.mdb.StagiaireJMSServlet;
import fr.treeptik.pojo.Session;
import fr.treeptik.pojo.Stagiaire;
import fr.treeptik.service.StagiaireServiceImpl;

@ManagedBean
@RequestScoped
public class StagiaireController {

	@EJB
	private StagiaireServiceImpl service;
	
	private StagiaireJMSServlet servlet = new StagiaireJMSServlet();

	private Stagiaire stagiaire = new Stagiaire();
	private List<Stagiaire> stagiaires;
	
	private List<Session> selectedSessions = new ArrayList<Session>();

	public String stag(){
		return "/protected/formateur/stagiaire?faces-redirect=true";
	}

	public String doSave() {
		stagiaire.setSessions(selectedSessions);
		stagiaire = this.service.create(stagiaire);
		
		try {
			this.servlet.doGet(stagiaire);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return "login?faces-redirect=true";
	}

	public String doDelete(Stagiaire stagiaire) {
	
			this.service.delete(stagiaire.getId());

		return "/protected/formateur/stagiaire?faces-redirect=true";
	}

	@PostConstruct
	public void listAll(){
		stagiaires=service.findAll();
	}
	
	/* ------------------------------ */

	public Stagiaire getStagiaire() {
		return this.stagiaire;
	}

	public void setStagiaire(Stagiaire stagiaire) {
		this.stagiaire = stagiaire;
	}

	public List<Stagiaire> getStagiaires() {
		return this.stagiaires;
	}

	public void setStagiaires(List<Stagiaire> stagiaires) {
		this.stagiaires = stagiaires;
	}

	public List<Session> getSelectedSessions() {
		return selectedSessions;
	}

	public void setSelectedSessions(List<Session> selectedSessions) {
		this.selectedSessions = selectedSessions;
	}



}
