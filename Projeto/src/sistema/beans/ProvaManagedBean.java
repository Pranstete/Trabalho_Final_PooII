package sistema.beans;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Curso;
import sistema.modelos.Disciplina;
import sistema.modelos.Faculdade;
import sistema.modelos.Pergunta;
import sistema.modelos.Professor;
import sistema.modelos.Prova;
import sistema.modelos.Turma;
import sistema.service.DisciplinaService;
import sistema.service.FaculdadeService;
import sistema.service.PerguntaService;
import sistema.service.ProfessorService;
import sistema.service.ProvaService;
import sistema.service.TurmaService;

@ManagedBean(name = "provaManagedBean")
@ViewScoped
public class ProvaManagedBean extends sistema.beans.ManagedBean<Prova> {

	private TurmaService turmaService = new TurmaService();
	private FaculdadeService faculdadeService = new FaculdadeService();
	private PerguntaService perguntaService = new PerguntaService();
	private DisciplinaService disciplinaService = new DisciplinaService();
	private ProfessorService professorService = new ProfessorService();
	private Faculdade faculdade;
	private Curso curso;
	private Professor professor;
	private Pergunta pergunta = new Pergunta();
	
	public ProvaManagedBean() {
		super(new ProvaService());
	}
	
	public Prova getProva() {
		return model;
	}
	
	public void setProva(Prova prova) {
		this.model = prova;
	}
	
	public List<Prova> getProvas() {
		return getList();
	}
	
	public Faculdade getFaculdade() {
		return faculdade;
	}
	
	public Professor getProfessor() {
		return professor;
	}
	
	public void setProfessor(Professor professor) {
		this.professor = professor;
		if (professor == null || faculdade == null)
			setFaculdade(null);
		else
			setFaculdade(faculdadeService.getFaculdadesPorProfessor(professor).isEmpty() ? null : faculdade);
	}
	
	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
		if (faculdade == null || curso == null)
			setCurso(null);
		else
			setCurso(curso.getFaculdade() == faculdade ? curso : null);
	}
	
	public Curso getCurso() {
		return curso;
	}
	
	public void setCurso(Curso curso) {
		this.curso = curso;
		if (curso == null || model.getDisciplina() == null)
			model.setDisciplina(null);
		else
			model.setDisciplina(model.getDisciplina().getCurso() == curso ? model.getDisciplina() : null);
	}
	
	public Pergunta getPergunta() {
		return pergunta;
	}
	
	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}
	
	public List<Professor> getProfessores() {
		return professorService.getList();
	}
	
	public List<Faculdade> getFaculdades() {
		return professor == null ? null : faculdadeService.getFaculdadesPorProfessor(professor);
	}

	public List<Curso> getCursos() {
		return faculdade != null ? faculdade.getCursos() : null;
	}

	public List<Disciplina> getDisciplinas() {
		return faculdade == null ? null : disciplinaService.getDisciplinasPorFaculdade(faculdade);
	}
	
	public List<Turma> getTurmas() {
		return model.getDisciplina() == null ? null : turmaService.getTurmaPorDisciplina(model.getDisciplina());
	}
	
	
	
	public List<Pergunta> getPerguntas() {
		return model.getDisciplina() == null ? null : perguntaService.getPerguntasPorDisciplina(model.getDisciplina());
	}
	
	public void addPergunta(Pergunta pergunta) {
		pergunta.setOrdem(model.getPerguntas().size() + 1);
		model.getPerguntas().add(pergunta);
		pergunta = new Pergunta();
	}
	
	public void removePergunta(Pergunta pergunta) {
		model.getPerguntas().remove(pergunta);
		pergunta = new Pergunta();
	}
	/*
	 * private Prova prova = new Prova();
	 * 
	 * private List<Faculdade> faculdades;
	 * 
	 * private List<Turma> turmas;
	 * 
	 * private List<Disciplina> disciplinas;
	 * 
	 * private List<Conteudo> conteudos;
	 * 
	 * private List<Pergunta> perguntas;
	 * 
	 * private FaculdadeService faculdadeService = new FaculdadeService();
	 * 
	 * private TurmaService turmaService = new TurmaService();
	 * 
	 * private DisciplinaService disciplinaService = new DisciplinaService();
	 * 
	 * private ConteudoService conteudoService = new ConteudoService();
	 * 
	 * private PerguntaService perguntaService = new PerguntaService();
	 * 
	 * 
	 * public void salvar() { /* disciplina.addConteudo(conteudo);
	 * conteudo.setDisciplina(disciplina); conteudos.add(conteudo);
	 * 
	 * prodService.salvar(conteudo);
	 * 
	 * conteudo = new Conteudo(); disciplina = null;
	 * 
	 * }
	 * 
	 * public List<Faculdade> getFaculdades() { return
	 * faculdadeService.getFaculdades(); }
	 * 
	 * public List<Turma> getTurmas() { return turmaService.getTurmas(); }
	 * 
	 * public List<Disciplina> getDisciplinas() { return
	 * disciplinaService.getList(); }
	 * 
	 * public Prova getProva() { return prova; }
	 * 
	 * public void setProva(Prova prova) { this.prova = prova; }
	 * 
	 * public List<Conteudo> getConteudos() { return conteudos; }
	 * 
	 * public void setConteudos(List<Conteudo> conteudos) { this.conteudos =
	 * conteudos; }
	 * 
	 * public List<Pergunta> getPerguntas() { return perguntas; }
	 * 
	 * public void setPerguntas(List<Pergunta> perguntas) { this.perguntas =
	 * perguntas; }
	 * 
	 * public void setFaculdades(List<Faculdade> faculdades) { this.faculdades =
	 * faculdades; }
	 * 
	 * public void setTurmas(List<Turma> turmas) { this.turmas = turmas; }
	 * 
	 * public void setDisciplinas(List<Disciplina> disciplinas) {
	 * this.disciplinas = disciplinas; }
	 * 
	 */

}
