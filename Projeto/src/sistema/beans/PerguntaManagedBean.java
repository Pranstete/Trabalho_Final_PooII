package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.model.TreeNode;

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
public class PerguntaManagedBean extends sistema.beans.ManagedBean<Pergunta> {

	private DisciplinaService disciplinaService = new DisciplinaService();
	private TipoPergunta tipoPergunta;
	private Disciplina disciplina;
//	private Alternativa alternativa = new Alternativa();
	private TreeNode t; 
	public PerguntaManagedBean() {
		super(new PerguntaService());
	}

	public Pergunta getPergunta() {
		return model;
	}

	public void setPergunta(Pergunta pergunta) {
		this.model = pergunta;
	}
	
	public Disciplina getDisciplina() {
		return disciplina;
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
//	public Alternativa getAlternativa() {
//		return alternativa;
//	}
//	
//	public void setAlternativa(Alternativa alternativa) {
//		this.alternativa = alternativa;
//	}
	
	public List<Pergunta> getPerguntas() {
		return getList();
	}
	
	public List<Conteudo> getConteudos() {
		return disciplina == null ? null : disciplina.getConteudos();
	}
	
	public List<Disciplina> getDisciplinas() {
		return disciplinaService.getList();
	}

	public TipoPergunta[] getTiposPergunta() {
		return TipoPergunta.values();
	}
	
	public TipoPergunta getTipoPergunta() {
		return tipoPergunta;
	}
	
	public void setTipoPergunta(TipoPergunta tipoPergunta) {
		this.tipoPergunta = tipoPergunta;
	}
	
	public Boolean isAlternativa() {
		return tipoPergunta == TipoPergunta.ALTERNATIVA;
	}
	
	public Boolean isDissertativa() {
		return tipoPergunta == TipoPergunta.DISSERTATIVA;
	}
	
	public Boolean isBooleana() {
		return tipoPergunta == TipoPergunta.BOOLEANA;
	}
	
	@Override
	public void save() {
		
		super.save();
	}
/*
	
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
//			conteudos = contService.getConteudosPorDisciplina((int) this.disciplina.getCodigo());
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

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public boolean isPerguntaComAlternativas() {
		return (this.pergunta.getTipo() == null) ? false : (this.pergunta.getTipo() == TipoPergunta.ALTERNATIVA);
	}
*/
}
