package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import sistema.modelos.Curso;
import sistema.modelos.Disciplina;
import sistema.modelos.Faculdade;
import sistema.modelos.Professor;
import sistema.modelos.Turma;
import sistema.service.DisciplinaService;
import sistema.service.FaculdadeService;
import sistema.service.ProfessorService;
import sistema.service.TurmaService;

@ManagedBean(name = "turmaManagedBean")
@ViewScoped
public class TurmaManagedBean extends sistema.beans.ManagedBean<Turma> {

	private ProfessorService professorService = new ProfessorService();
	private FaculdadeService faculdadeService = new FaculdadeService();
	private DisciplinaService disciplinaService = new DisciplinaService();
	private Faculdade faculdade;
	private Curso curso;

	public TurmaManagedBean() {
		super(new TurmaService());
	}

	public Turma getTurma() {
		return model;
	}

	public void setTurma(Turma turma) {
		this.model = turma;
	}

	public Faculdade getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public List<Faculdade> getFaculdades() {
		return faculdadeService.getList();
	}

	public List<Turma> getTurmas() {
		return getList();
	}

	public List<Professor> getProfessores() {
		return professorService.getList();
	}
	
	public List<Curso> getCursos() {
		return faculdade == null ? null : faculdade.getCursos();
	}

	public List<Disciplina> getDisciplinas() {
		return curso == null ? null : disciplinaService.getDisciplinasPorCurso(curso);
	}
	
	@Override
	public void save() {
		this.model.getDisciplina().setCurso(curso);
		super.save();
	}
}
