package fr.treeptik.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import fr.treeptik.pojo.Formateur;
import fr.treeptik.pojo.Formation;
import fr.treeptik.service.FormateurServiceImpl;
import fr.treeptik.service.FormationServiceImpl;

@ManagedBean
@RequestScoped
public class FormateurController {
	
	@EJB
	private FormateurServiceImpl service;
	


	private Formateur formateur = new Formateur();
	private List<Formateur> formateurs;
	

	

	public String format(){
		return "/protected/formateur/formateur?faces-redirect=true";
	}
	
	public String doSave() {

		formateur=service.create(formateur);
		return "login?faces-redirect=true";
		
	}

	public String doDelete(Formateur formateur) {
		this.service.delete(formateur.getId());

		return "/protected/formateur/formateur?faces-redirect=true";
	}
	
	@PostConstruct
	public void listAll(){
		formateurs= service.findAll();
	}

	public String index() {
		this.formateurs = this.service.findAll();
		return "index";
	}

	public List<Formateur> getFormateurs() {
		return formateurs;
	}

	public void setFormateurs(List<Formateur> formateurs) {
		this.formateurs = formateurs;
	}

	public Formateur getFormateur() {
		return formateur;
	}

	public void setFormateur(Formateur formateur) {
		this.formateur = formateur;
	}



}
