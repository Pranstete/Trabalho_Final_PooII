package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Faculdade;


public class FaculdadeService extends Service{
	
	public void salvar(Faculdade faculdade)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(faculdade);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Faculdade> getFaculdades()
	{
		
		List <Faculdade >faculdades;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Faculdade a");
		faculdades = q.getResultList();
		em.close();
		
		return faculdades;
		
	}

	public void alterar(Faculdade faculdade) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(faculdade);
		em.getTransaction().commit();	
	    em.close();

		
		
	}

	
	public void remover(Faculdade faculdade) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			faculdade = em.find(Faculdade.class,faculdade.getCodigo());
			em.remove(faculdade);
		em.getTransaction().commit();	
	    em.close();

		
		
	}
	
	
}
