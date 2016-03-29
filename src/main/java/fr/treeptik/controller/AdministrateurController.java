package fr.treeptik.controller;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.xml.ws.WebServiceRef;

import fr.treeptik.pojo.Administrateur;
import fr.treeptik.ws.AdministrateurServiceImpl;
import fr.treeptik.ws.AdministrateurServiceImplService;

@ManagedBean
@RequestScoped
public class AdministrateurController {

	@WebServiceRef
	private AdministrateurServiceImplService administrateurServiceImplService;

	private Administrateur administrateur = new Administrateur();
	private List<Administrateur> administrateurs;

	public String admin() {
		return "/protected/administrateur/admin?faces-redirect=true";
	}

	public String doSave() {
		AdministrateurServiceImpl service = (AdministrateurServiceImpl) administrateurServiceImplService
				.getAdministrateurServiceImplPort();
		administrateur = service.create(administrateur);

		return "login?faces-redirect=true";
	}

	public String doDelete(Administrateur administrateur) {
		AdministrateurServiceImpl service = (AdministrateurServiceImpl) administrateurServiceImplService
				.getAdministrateurServiceImplPort();
		service.delete(administrateur.getId());

		return "/protected/administrateur/admin?faces-redirect=true";
	}

	@PostConstruct
	public void listAll() {
		AdministrateurServiceImpl service = (AdministrateurServiceImpl) administrateurServiceImplService
				.getAdministrateurServiceImplPort();
		administrateurs = service.findAll();
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

	public AdministrateurServiceImplService getAdministrateurServiceImplService() {
		return administrateurServiceImplService;
	}

	public void setAdministrateurServiceImplService(
			AdministrateurServiceImplService administrateurServiceImplService) {
		this.administrateurServiceImplService = administrateurServiceImplService;
	}

}
