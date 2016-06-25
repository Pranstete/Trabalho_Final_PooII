package sistema.service;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Curso;


public class CursoService extends Service{
	
	public void salvar(Curso curso)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(curso);
		em.getTransaction().commit();	
	    em.close();
		
	}
	
	
	@SuppressWarnings("unchecked")
	public List <Curso> getCursos()
	{
		
		List <Curso >cursos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select a From Curso a");
		cursos = q.getResultList();
		em.close();
		
		return cursos;
		
	}

	public void alterar(Curso curso) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(curso);
		em.getTransaction().commit();	
	    em.close();

		
		
	}

	
	public void remover(Curso curso) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			curso = em.find(Curso.class,curso.getCodigo());
			em.remove(curso);
		em.getTransaction().commit();	
	    em.close();

		
		
	}
	
	
}
