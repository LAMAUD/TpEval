package fr.treeptik.converter;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

import fr.treeptik.pojo.Formateur;
import fr.treeptik.pojo.Formation;
import fr.treeptik.service.FormationServiceImpl;

@ManagedBean(name = "formationConverter")
@RequestScoped
@FacesConverter(forClass = Formateur.class, value = "formationConverter")
public class FormationConverter {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FormationServiceImpl service;

	
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Integer id = Integer.valueOf(value);
		Formation formation = null;
			formation = service.findOne(id);

		return formation;
	}

	
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Formation) value).getId();
		return String.valueOf(id);
	}

}
