package sistema.beans;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Curso;
import sistema.modelos.Disciplina;
import sistema.service.CursoService;
import sistema.service.DisciplinaService;

@ManagedBean(name = "disciplinaManagedBean")
@ViewScoped
public class DisciplinaManagedBean extends sistema.beans.ManagedBean<Disciplina> {

	private CursoService cursoService = new CursoService();
	
	public DisciplinaManagedBean() {
		super(new DisciplinaService());
	}

	public Disciplina getDisciplina() {
		return model;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.model = disciplina;
	}

	public List<Disciplina> getDisciplinas() {
		return getList();
	}
	
	public List<Curso> getCursos() {
		return cursoService.getList();
	}
}
