package sistema.beans;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.view.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Alternativa;
import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;
import sistema.modelos.TipoPergunta;
import sistema.service.ConteudoService;
import sistema.service.DisciplinaService;
import sistema.service.PerguntaService;

@ManagedBean(name = "perguntaManagedBean")
@ViewScoped
public class PerguntaManagedBean implements Serializable {

	private static final long serialVersionUID = -6648290512515982057L;

	private Pergunta pergunta = new Pergunta();
	private Conteudo conteudo;
	private Disciplina disciplina;
	private List<Conteudo> conteudos;

	private ConteudoService contService = new ConteudoService();
	private PerguntaService perguntaService = new PerguntaService();
	private DisciplinaService disciplinaService = new DisciplinaService();

	private Alternativa alternativa;
	
	private String enunciado;

	public void salvar() {
		// pergunta.setConteudo(conteudo);
		System.out.println(pergunta);

		perguntaService.salvar(pergunta);

		pergunta = new Pergunta();
	}

	public void remove(Conteudo conteudo) {
		conteudos.remove(conteudo);
		contService.remover(conteudo);
	}

	public void onRowEdit(RowEditEvent event) {

		Conteudo p = ((Conteudo) event.getObject());
		contService.alterar(p);
	}

	public void tipoAlterado(ValueChangeEvent e) {
		this.pergunta.setTipo((TipoPergunta) e.getNewValue());

		if (TipoPergunta.ALTERNATIVA.equals(e.getNewValue())) {
			// VErifica Se alterou tipo *para* ALTERNATIVAS
			this.alternativa = new Alternativa();
		} else if (TipoPergunta.ALTERNATIVA.equals(e.getOldValue())) {
			// VErifica Se alterou tipo *de* ALTERNATIVAS para outro tipo
			this.alternativa = null;
			pergunta.getAlternativas().clear();
		}
	}

	public void disciplinaAlterada(ValueChangeEvent e) {
		this.disciplina = (Disciplina) e.getNewValue();
	}

	public void alterarConteudos(AjaxBehaviorEvent e) {
		if (this.disciplina == null) {
			conteudos = null;
		} else {
			conteudos = contService.getConteudosPorDisciplina((int) this.disciplina.getCodigo());
		}
	}

	public void conteudoAlterado(ValueChangeEvent e) {
		pergunta.setConteudo((Conteudo) e.getNewValue());
	}

	public void alternativaEscrita(ValueChangeEvent e) {
		this.setEnunciado((String) e.getNewValue());
	}
	
	public void alternativaSaida() {
		System.out.println("PerguntaManagedBean.alternativaSaida(): ");
	}

	public void addAlternativa() {
		if (this.enunciado != null && enunciado.trim().length() > 0) {
			this.alternativa.setOrdem(this.pergunta.getAlternativas().size() + 1);
			this.alternativa.setPergunta(this.pergunta);
			this.pergunta.getAlternativas().add(this.alternativa);
			this.alternativa = new Alternativa();
		}
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public List<Conteudo> getConteudos() {
		return this.contService.getConteudos();
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinaService.getDisciplinas();
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public TipoPergunta[] getTiposPergunta() {
		return TipoPergunta.values();
	}

	public Alternativa getAlternativa() {
		return alternativa;
	}

	public void setAlternativa(Alternativa alternativa) {
		this.alternativa = alternativa;
	}
	
	

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public boolean isPerguntaComAlternativas() {
		return (this.pergunta.getTipo() == null) ? false : (this.pergunta.getTipo() == TipoPergunta.ALTERNATIVA);
	}

}
