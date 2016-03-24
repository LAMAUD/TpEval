package fr.treeptik.controller;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;


@ManagedBean
@RequestScoped
public class HomeController {
	
	public String home(){
		return "/protected/home?faces-redirect=true";
	}

}
