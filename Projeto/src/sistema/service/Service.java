package sistema.service;

import java.lang.reflect.ParameterizedType;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Service<T> {

	protected static EntityManagerFactory emf;

	public Service() {
		emf = Persistence.createEntityManagerFactory("ProjetoMavenJSFPrimeFaces");
	}

	private void message(Object msg) {
		System.out.println(msg);
		FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover disciplina","Disciplina possui conteudos!"));
	}

	public void save(T model) {
		EntityManager em = emf.createEntityManager();
		message("Saving...");
		message(model);
		try {
			em.getTransaction().begin();
			em.persist(model);
			em.getTransaction().commit();
			message("Saved successfully: " + model);
		} catch (Exception e) {
			message("Failed to save.");
			message(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void update(T model) {
		EntityManager em = emf.createEntityManager();
		message("Updating...");
		message(find(model, em) + " => " + model);
		try {
			em.getTransaction().begin();
			em.merge(model);
			em.getTransaction().commit();
			message("Updated successfully: " + model);
		} catch (Exception e) {
			message("Failed to update.");
			message(e.getMessage());
		} finally {
			em.close();
		}
	}

	public void delete(T model) {
		EntityManager em = emf.createEntityManager();
		message("Deleting...");
		message(model);
		try {
			em.getTransaction().begin();
			em.remove(find(model, em));
			em.getTransaction().commit();
			message("Deleted successfully: " + model);
		} catch (Exception e) {
			message("Failed to delete.");
			message(e.getMessage());
		} finally {
			em.close();
		}
	}

	@SuppressWarnings("unchecked")
	protected T find(T model, EntityManager em) {
		Boolean close = em == null;
		em = close ? emf.createEntityManager() : em;
		message("Finding...");
		message(model);
		try {
			model = (T) em.find(model.getClass(), emf.getPersistenceUnitUtil().getIdentifier(model));
			message(model == null ? "Not found." : "Found successfully: " + model);
			message(model);
		} catch (Exception e) {
			message("Failed to find.");
			message(e.getMessage());
		} finally {
			if (close)
				em.close();
		}
		return model;
	}

	public T find(T model) {
		return find(model, null);
	}

	@SuppressWarnings("unchecked")
	protected List<T> getList(Query query) {
		List<T> list;
		EntityManager em = emf.createEntityManager();
		list = query.getResultList();
		em.close();
		return list;
	}

	@SuppressWarnings("unchecked")
	protected List<T> getList(String stringQuery, Map<String, Object> parameters) {
		List<T> list;
		parameters = parameters == null ? new HashMap<String, Object>() : parameters;
		EntityManager em = emf.createEntityManager();
		Query query = em.createQuery(stringQuery);
		for (Map.Entry<String, Object> parameter : parameters.entrySet()) {
			query.setParameter(parameter.getKey(), parameter.getValue());
		}
		list = query.getResultList();
		em.close();
		return list;
	}

	protected List<T> getList(String stringQuery) {
		return getList(stringQuery, null);
	}

	public List<T> getList() {
		return getList(String.format("Select f From %s f", getGenericName()));
	}

	@SuppressWarnings("unchecked")
	protected String getGenericName() {
		return ((Class<T>)((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0]).getSimpleName();
	}
}