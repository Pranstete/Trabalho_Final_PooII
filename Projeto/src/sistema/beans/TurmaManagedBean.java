package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Turma;
import sistema.service.TurmaService;

@ManagedBean
@ViewScoped
public class TurmaManagedBean {

	private Turma turma = new Turma();
	private List<Turma> turmas;
	private TurmaService service = new TurmaService();

	
	//Edição de um turma na tabela
	public void onRowEdit(RowEditEvent event) {

		Turma a = ((Turma) event.getObject());
		service.alterar(a);
	}

	
	
	public void salvar() {
		service.salvar(turma);

		if (turmas != null)
			turmas.add(turma);

		turma = new Turma();

	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	//Retorna a lista de turmas para a tabela
	public List<Turma> getTurmas() {
		if (turmas == null)
			turmas = service.getTurmas();

		return turmas;
	}

	public void remover(Turma turma) {
		service.remover(turma);
		turmas.remove(turma);

	}

}
