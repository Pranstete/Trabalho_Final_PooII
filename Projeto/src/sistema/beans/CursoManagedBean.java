package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Curso;
import sistema.service.CursoService;

@ManagedBean
@ViewScoped
public class CursoManagedBean {

	private Curso curso = new Curso();
	private List<Curso> cursos;
	private CursoService service = new CursoService();

	
	//Edição de um curso na tabela
	public void onRowEdit(RowEditEvent event) {

		Curso a = ((Curso) event.getObject());
		service.alterar(a);
	}

	
	
	public void salvar() {
		service.salvar(curso);

		if (cursos != null)
			cursos.add(curso);

		curso = new Curso();

	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	//Retorna a lista de cursos para a tabela
	public List<Curso> getCursos() {
		if (cursos == null)
			cursos = service.getCursos();

		return cursos;
	}

	public void remover(Curso curso) {
		service.remover(curso);
		cursos.remove(curso);

	}

}
