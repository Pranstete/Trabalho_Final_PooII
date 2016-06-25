package sistema.beans;



import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import sistema.beans.datamodel.DisciplinaDataModel;
import sistema.modelos.Disciplina;
import sistema.modelos.Conteudo;
import sistema.service.DisciplinaService;





@ManagedBean
@ViewScoped
public class DisciplinaManagedBean implements Serializable {

	private static final long serialVersionUID = -1574274326258807219L;
	
	private Disciplina disciplina = new Disciplina();
	private Disciplina disciplinaSelecionado;
    private DisciplinaService servico = new DisciplinaService();
    private List <Disciplina> disciplinas;
	

	/**
	 * @return the disciplinaSelecionado
	 */
	public Disciplina getDisciplinaSelecionado() {
		return disciplinaSelecionado;
	}

	/**
	 * @param disciplinaSelecionado the disciplinaSelecionado to set
	 */
	public void setDisciplinaSelecionado(Disciplina disciplinaSelecionado) {
		this.disciplinaSelecionado = disciplinaSelecionado;
	}

	public void salvar()
	{
		servico.salvar(disciplina);
		
		if(disciplinas != null)
			disciplinas.add(disciplina);
		
		
		disciplina = new Disciplina();
		
	}
	
	public DataModel<Disciplina> getDisciplinas()
	{
		if(disciplinas == null)
			disciplinas = servico.getDisciplinas();
		
		return new DisciplinaDataModel(disciplinas);
	}
	
	
	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void remove(Disciplina disciplina)
	{
		if(servico.pesquisarConteudosDisciplina(disciplina).size() > 0)
		{
		   FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover disciplina","Disciplina possui conteudos!"));
		}
		else
		{
			servico.remover(disciplina);
			disciplinas.remove(disciplina);
		}
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public List <Conteudo> getConteudosDisciplina()
	{
		if(disciplinaSelecionado != null)
		{
			return servico.pesquisarConteudosDisciplina(disciplinaSelecionado);
		}
		else
			return null;
	}
	
	
	public void onRowEdit(RowEditEvent event) {

		Disciplina f = ((Disciplina) event.getObject());
		servico.alterar(f);
	}

	
	
}
