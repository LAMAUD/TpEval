package fr.treeptik.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import fr.treeptik.pojo.Utilisateur;


@ManagedBean
@SessionScoped
public class deconnectionController {
	

    private Utilisateur current;

    @SuppressWarnings("static-access")
	public String logout() {
    	FacesContext context = FacesContext.getCurrentInstance().getCurrentInstance();	
    	HttpSession session = (HttpSession) context.getExternalContext().getSession(true);
    	session.invalidate();
    	return null;
    }

}
