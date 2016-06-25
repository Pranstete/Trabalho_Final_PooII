package sistema.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;

public class ConteudoService extends Service implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1362864098017792668L;


	public void salvar(Conteudo conteudo)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(conteudo);
		em.getTransaction().commit();	
	    em.close();
		
	}

	

	@SuppressWarnings("unchecked")
	public List <Conteudo> getConteudos()
	{
		
		List <Conteudo > conteudos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select f From Conteudo f");
		conteudos = q.getResultList();
		em.close();
		
		return conteudos;
	}
	
	public List <Conteudo> getConteudosPorDisciplina(Integer codigoDisciplina)
	{
		
		List <Conteudo > conteudos;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select f From Conteudo f where f.disciplina.codigo = :codigoDisciplina order by f.descricao");
		q.setParameter("codigoDisciplina", codigoDisciplina);
		conteudos = q.getResultList();
		em.close();
		
		return conteudos;
	}
	
	
	public void alterar(Conteudo conteudo) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(conteudo);
		em.getTransaction().commit();	
	    em.close();
	}
	
	
	public void remover(Conteudo conteudo) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			conteudo = em.find(Conteudo.class,conteudo.getCodigo());
			em.remove(conteudo);
		em.getTransaction().commit();	
	    em.close();
	}
}
