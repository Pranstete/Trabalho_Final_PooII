package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Prova;

public class ProvaService extends Service {

	public void salvar(Prova prova)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(prova);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Prova> getProvas()
	{
		
		List <Prova> provas;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Prova a order by dataProva a.desc");
		provas = q.getResultList();
		em.close();
		
		return provas;
		
	}

}
