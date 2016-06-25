package sistema.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import sistema.modelos.Pergunta;

public class PerguntaService extends Service {

	public void salvar(Pergunta pergunta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(pergunta);
		em.getTransaction().commit();
		em.close();

	}

	@SuppressWarnings("unchecked")
	public List<Pergunta> getPerguntas() {
		List<Pergunta> perguntas;

		EntityManager em = emf.createEntityManager();
		Query q = em.createQuery("Select f From Pergunta f");
		perguntas = q.getResultList();
		em.close();

		return perguntas;
	}

	public void alterar(Pergunta pergunta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(pergunta);
		em.getTransaction().commit();
		em.close();
	}

	public void remover(Pergunta pergunta) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		pergunta = em.find(Pergunta.class, pergunta.getCodigo());
		em.remove(pergunta);
		em.getTransaction().commit();
		em.close();
	}
}
