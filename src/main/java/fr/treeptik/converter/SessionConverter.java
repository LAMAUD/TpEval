package fr.treeptik.converter;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import fr.treeptik.pojo.Session;
import fr.treeptik.service.SessionServiceImpl;

@ManagedBean(name = "sessionConverter")
@RequestScoped
@FacesConverter(forClass = Session.class, value = "sessionConverter")
public class SessionConverter implements Converter, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@EJB
	private SessionServiceImpl service;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		Integer id = Integer.valueOf(value);
		Session session = null;
			session = service.findOne(id);

		return session;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		int id = ((Session) value).getId();
		return String.valueOf(id);
	}
}