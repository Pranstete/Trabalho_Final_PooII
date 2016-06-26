package sistema.beans;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Prova;
import sistema.service.ProvaService;

@ManagedBean(name = "provaManagedBean")
@ViewScoped
public class ProvaManagedBean extends sistema.beans.ManagedBean<Prova> {

	public ProvaManagedBean() {
		super(new ProvaService());
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
