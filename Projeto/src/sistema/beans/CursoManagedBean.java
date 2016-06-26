package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sistema.modelos.Curso;
import sistema.modelos.Faculdade;
import sistema.service.CursoService;
import sistema.service.FaculdadeService;

@ManagedBean(name = "cursoManagedBean")
@ViewScoped
public class CursoManagedBean extends sistema.beans.ManagedBean<Curso> {

	private FaculdadeService faculdadeService = new FaculdadeService();
	
	public CursoManagedBean() {
		super(new CursoService());
	}

	public Curso getCurso() {
		return model;
	}

	public void setCurso(Curso curso) {
		this.model = curso;
	}
	
	public List<Curso> getCursos() {
		return getList();
	}
	
	public List<Faculdade> getFaculdades() {
		return faculdadeService.getList();
	}
}