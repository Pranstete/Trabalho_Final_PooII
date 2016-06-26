package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Disciplina;
import sistema.modelos.Conteudo;
import sistema.service.DisciplinaService;
import sistema.service.ConteudoService;

@ManagedBean(name = "conteudoManagedBean")
@ViewScoped
public class ConteudoManagedBean extends sistema.beans.ManagedBean<Conteudo> {

	private DisciplinaService disciplinaService = new DisciplinaService();

	public ConteudoManagedBean() {
		super(new ConteudoService());
	}
	
	public Conteudo getConteudo() {
		return model;
	}

	public void setConteudo(Conteudo conteudo) {
		this.model = conteudo;
	}

	public List<Conteudo> getConteudos() {
		return getList();
	}

	public List<Disciplina> getDisciplinas() {
		return disciplinaService.getList();
	}
}