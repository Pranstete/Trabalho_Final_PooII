package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Professor;


public class ProfessorService extends Service{
	
	public void salvar(Professor professor)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(professor);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Professor> getProfessores()
	{
		
		List <Professor >professores;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Professor a");
		professores = q.getResultList();
		em.close();
		
		return professores;
		
	}

	public void alterar(Professor professor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(professor);
		em.getTransaction().commit();	
	    em.close();

		
		
	}

	
	public void remover(Professor professor) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			professor = em.find(Professor.class,professor.getCodigo());
			em.remove(professor);
		em.getTransaction().commit();	
	    em.close();

		
		
	}
	
	
}
