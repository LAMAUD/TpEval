package fr.treeptik.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.SelectEvent;

import fr.treeptik.pojo.Session;
import fr.treeptik.service.SessionServiceImpl;

@ManagedBean
@RequestScoped
public class SessionController {

	@EJB
	private SessionServiceImpl service;
	
	private Session session = new Session();
	private List<Session> sessions;

	public String sess(){
		return "/protected/session?faces-redirect=true";
	}
	

	public String doSave() {
		this.service.create(session);
		return "/protected/session?faces-redirect=true";
	}
	
	public String doDelete(Session session) {
		this.service.delete(session.getId());
		return "/protected/session?faces-redirect=true";
	}

	@PostConstruct
	public void listAll() {
		sessions=service.findAll();
	}

    public void onDateSelect(SelectEvent event) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
        facesContext.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Date Selected", format.format(event.getObject())));
    }
	
	/* ------------------------------ */

	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	public List<Session> getSessions() {
		return sessions;
	}

	public void setSessions(List<Session> sessions) {
		this.sessions = sessions;
	}


}
