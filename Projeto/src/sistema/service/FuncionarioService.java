package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;


import sistema.modelos.Funcionario;

public class FuncionarioService extends Service{
	
	public void salvar(Funcionario funcionario)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(funcionario);
		em.getTransaction().commit();	
	    em.close();
		
	}

	

	@SuppressWarnings("unchecked")
	public List <Funcionario> getFuncionarios()
	{
		
		List <Funcionario> funcionarios;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select f From Funcionario f");
		funcionarios = q.getResultList();
		em.close();
		
		return funcionarios;
	}
	
	
	public void alterar(Funcionario funcionario) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(funcionario);
		em.getTransaction().commit();	
	    em.close();
	}
	
	
	public void remover(Funcionario funcionario) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			funcionario = em.find(Funcionario.class,funcionario.getCodigo());
			em.remove(funcionario);
		em.getTransaction().commit();	
	    em.close();
	}
	
	
	
	
	
	
	
	
	
}
