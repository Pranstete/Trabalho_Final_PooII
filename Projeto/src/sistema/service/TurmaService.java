package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Turma;


public class TurmaService extends Service{
	
	public void salvar(Turma turma)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(turma);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Turma> getTurmas()
	{
		
		List <Turma >turmas;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Turma a");
		turmas = q.getResultList();
		em.close();
		
		return turmas;
		
	}

	public void alterar(Turma turma) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(turma);
		em.getTransaction().commit();	
	    em.close();

		
		
	}

	
	public void remover(Turma turma) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			turma = em.find(Turma.class,turma.getCodigo());
			em.remove(turma);
		em.getTransaction().commit();	
	    em.close();

		
		
	}
	
	
}
