package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Empresa;
import sistema.modelos.Fornecedor;
import sistema.modelos.Funcionario;
import sistema.modelos.Produto;

public class EmpresaService extends Service{
	
	public void salvar(Empresa empresa)
	{
	    
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.persist(empresa);
		em.getTransaction().commit();	
	    em.close();
		
	}

	

	@SuppressWarnings("unchecked")
	public List <Empresa> getEmpresas()
	{
		
		List <Empresa > empresas;
		
		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select f From Empresa f");
		empresas = q.getResultList();
		em.close();
		
		return empresas;
	}
	
	
	public void alterar(Empresa empresa) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
			em.merge(empresa);
		em.getTransaction().commit();	
	    em.close();
	}
	
	
	public void remover(Empresa empresa) {

		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();	
		empresa = em.find(Empresa.class,empresa.getCodigo());
			em.remove(empresa);
		em.getTransaction().commit();	
	    em.close();
	}



	public Empresa pesquisar(Empresa empresa) {

		EntityManager em = emf.createEntityManager();
		empresa = em.find(Empresa.class,empresa.getCodigo());
		em.close();
	    
	    return empresa;
	}



	@SuppressWarnings("unchecked")
	public List<Funcionario> pesquisarFuncionariosEmpresa(Empresa empresa) {
		
		List <Funcionario> funcionarios;
		
		EntityManager em = emf.createEntityManager();
		    
		    //Torna gerenciavel a entidade
			empresa = em.merge(empresa);
		    
		    //Atualiza a entidade para não usar dados antigos no cache do JPA
		    //Ver https://wiki.eclipse.org/EclipseLink/Examples/JPA/Caching
			em.refresh(empresa);
			
			
			//Recupera a lista de produtos
			funcionarios = empresa.getFuncionarios();
			
		em.close();
	    
	    return funcionarios;	
	}
	
	
	
	
	
	
	
	
	
}
