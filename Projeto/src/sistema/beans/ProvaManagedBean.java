package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Disciplina;
import sistema.modelos.Faculdade;
import sistema.modelos.Pergunta;
import sistema.modelos.Prova;
import sistema.modelos.Turma;
import sistema.modelos.Conteudo;
import sistema.service.DisciplinaService;
import sistema.service.FaculdadeService;
import sistema.service.PerguntaService;
import sistema.service.TurmaService;
import sistema.service.ConteudoService;

@ManagedBean(name = "provaManagedBean")
@ViewScoped
public class ProvaManagedBean {

	private Prova prova = new Prova();

	private List<Faculdade> faculdades;

	private List<Turma> turmas;

	private List<Disciplina> disciplinas;

	private List<Conteudo> conteudos;

	private List<Pergunta> perguntas;
	
	private FaculdadeService faculdadeService = new FaculdadeService();
	
	private TurmaService turmaService = new TurmaService();
	
	private DisciplinaService disciplinaService = new DisciplinaService();
	
	private ConteudoService conteudoService = new ConteudoService();
	
	private PerguntaService perguntaService = new PerguntaService();


	public void salvar() {
		/*
		 * disciplina.addConteudo(conteudo); conteudo.setDisciplina(disciplina);
		 * conteudos.add(conteudo);
		 * 
		 * prodService.salvar(conteudo);
		 * 
		 * conteudo = new Conteudo(); disciplina = null;
		 */
	}
	
	public List<Faculdade> getFaculdades() {
		return faculdadeService.getFaculdades();
	}
	
	public List<Turma> getTurmas() {
		return turmaService.getTurmas();
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinaService.getDisciplinas();
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
	}

	public List<Conteudo> getConteudos() {
		return conteudos;
	}

	public void setConteudos(List<Conteudo> conteudos) {
		this.conteudos = conteudos;
	}

	public List<Pergunta> getPerguntas() {
		return perguntas;
	}

	public void setPerguntas(List<Pergunta> perguntas) {
		this.perguntas = perguntas;
	}

	public void setFaculdades(List<Faculdade> faculdades) {
		this.faculdades = faculdades;
	}

	public void setTurmas(List<Turma> turmas) {
		this.turmas = turmas;
	}

	public void setDisciplinas(List<Disciplina> disciplinas) {
		this.disciplinas = disciplinas;
	}
	
	

}
