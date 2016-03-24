package fr.treeptik.dao;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;





public class GenericDAOJPA<T, Pk> {

	@PersistenceContext(unitName = "evalPU")
	private EntityManager em;

	private Class<T> type;

//	@SuppressWarnings("unchecked")
//	public GenericDAOJPA() {
//		ParameterizedType genericSuperClass = (ParameterizedType) getClass()
//				.getGenericSuperclass();
//		this.type = (Class<T>) genericSuperClass.getActualTypeArguments()[0];
//	}

	
	
	public List<T> findAll() {
		return this.em.createQuery("SELECT t FROM " + type.getName() + " t",
				type).getResultList();
	}

	
	public GenericDAOJPA() {
	super();
}
	


	public GenericDAOJPA(Class<T> type) {
		super();
		this.type = type;
	}


	public T findOne(Pk key) {
		T entity = this.em.find(type, key);
		
		return entity;
	}

	
	
	public T save(T entity) {
		return this.em.merge(entity);
	}

	
	
	public T update(T entity) {
		return this.save(entity);
	}

	

	public T delete(Pk key) {
		T entity = this.em.find(type, key);
		
		this.em.createQuery("DELETE FROM " + type.getName() + " WHERE id = :id")
				.setParameter("id", key).executeUpdate();
		
		return entity;
	}

}
