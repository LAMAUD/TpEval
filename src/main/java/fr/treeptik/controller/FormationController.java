package fr.treeptik.controller;

import java.io.IOException;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.treeptik.converter.SessionConverter;
import fr.treeptik.pojo.Formateur;
import fr.treeptik.pojo.Formation;
import fr.treeptik.pojo.Session;
import fr.treeptik.service.FormateurServiceImpl;
import fr.treeptik.service.FormationServiceImpl;
import fr.treeptik.service.SessionServiceImpl;

@ManagedBean
@RequestScoped
public class FormationController {

	@EJB
	private FormationServiceImpl service;


	private SessionConverter converter;
	private Formation formation = new Formation();
	private Session selectedSession = new Session();
	private Formateur selectedFormateur = new Formateur();
	private Date dateDebut;
	private Date dateFin;
	
	private List<Formation> formations;

	

	public String format(){
		return "/protected/formation?faces-redirect=true";
	}

	public String doSave() throws ClassNotFoundException, IOException {
		dateDebut=selectedSession.getDateDebut();
		dateFin=selectedSession.getDateFin();
		
		formation.setSession(selectedSession);
		formation.setFormateur(selectedFormateur);
		service.create(formation);

		return "/protected/formation?faces-redirect=true";
	}
	
	public String doDelete(Formation formation){
		service.delete(formation.getId());
		
		return "/protected/formation?faces-redirect=true";
	}

	@PostConstruct
	public void listAll(){
		formations=service.findAll();

		
	}


	/* ------------------------------ */

	public Formation getFormation() {
		return formation;
	}

	public void setFormation(Formation formation) {
		this.formation = formation;
	}

	public List<Formation> getFormations() {
		return formations;
	}

	public void setFormations(List<Formation> formations) {
		this.formations = formations;
	}

	public SessionConverter getConverter() {
		return converter;
	}

	public void setConverter(SessionConverter converter) {
		this.converter = converter;
	}

	public Session getSelectedSession() {
		return selectedSession;
	}

	public void setSelectedSession(Session selectedSession) {
		this.selectedSession = selectedSession;
	}

	public Formateur getSelectedFormateur() {
		return selectedFormateur;
	}

	public void setSelectedFormateur(Formateur selectedFormateur) {
		this.selectedFormateur = selectedFormateur;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(Date dateDebut) {
		this.dateDebut = dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}



}
