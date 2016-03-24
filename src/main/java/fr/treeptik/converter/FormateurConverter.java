package fr.treeptik.converter;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import fr.treeptik.pojo.Formateur;
import fr.treeptik.service.FormateurServiceImpl;

@ManagedBean(name = "formateurConverter")
@RequestScoped
@FacesConverter(forClass = Formateur.class, value = "formateurConverter")
public class FormateurConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private FormateurServiceImpl service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Integer id = Integer.valueOf(value);
		Formateur formateur = null;
			formateur = service.findOne(id);

		return formateur;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Formateur) value).getId();
		return String.valueOf(id);
	}
}