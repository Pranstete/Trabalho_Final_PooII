package sistema.beans;


import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Disciplina;
import sistema.modelos.Conteudo;
import sistema.service.DisciplinaService;
import sistema.service.ConteudoService;




@ManagedBean(name="conteudoManagedBean")
@ViewScoped
public class ConteudoManagedBean {

	private Conteudo conteudo = new Conteudo();
	private Disciplina disciplina;
    private ConteudoService prodService = new ConteudoService();
    private DisciplinaService fornService = new DisciplinaService();
    private List <Conteudo> conteudos;
    
	
	public void salvar()
	{
		disciplina.addConteudo(conteudo);
		conteudo.setDisciplina(disciplina);
		conteudos.add(conteudo);
		
		prodService.salvar(conteudo);
		
		conteudo = new Conteudo();
		disciplina = null;
		
	}
	
	
	
	public List <Disciplina> getDisciplinas()
	{
		return fornService.getDisciplinas();
		
	}
	
	
	public Disciplina getDisciplina() {
		return disciplina;
	}


	public void remove(Conteudo conteudo)
	{
		conteudos.remove(conteudo);
		prodService.remover(conteudo);
		
	}
	
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	
	public List<Conteudo> getConteudos() {
		if(conteudos == null)
			conteudos = prodService.getConteudos();
		
		return conteudos;
	}
	
	
	public void onRowEdit(RowEditEvent event) {

		Conteudo p = ((Conteudo) event.getObject());
		prodService.alterar(p);
	}

	
	
	
}
