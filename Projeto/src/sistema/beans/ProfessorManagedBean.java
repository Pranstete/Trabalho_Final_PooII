package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@ManagedBean
@ViewScoped
public class ProfessorManagedBean extends sistema.beans.ManagedBean<Professor> {

	public ProfessorManagedBean() {
		super(new ProfessorService());
	}

	public Professor getProfessor() {
		return model;
	}

	public void setProfessor(Professor professor) {
		this.model = professor;
	}

	public List<Professor> getProfessores() {
		return getList();
	}
}
