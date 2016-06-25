package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import org.primefaces.event.RowEditEvent;

import sistema.modelos.Faculdade;
import sistema.service.FaculdadeService;

@ManagedBean
@ViewScoped
public class FaculdadeManagedBean {

	private Faculdade faculdade = new Faculdade();
	private List<Faculdade> faculdades;
	private FaculdadeService service = new FaculdadeService();

	
	//Edição de um faculdade na tabela
	public void onRowEdit(RowEditEvent event) {

		Faculdade a = ((Faculdade) event.getObject());
		service.alterar(a);
	}

	
	
	public void salvar() {
		service.salvar(faculdade);

		if (faculdades != null)
			faculdades.add(faculdade);

		faculdade = new Faculdade();

	}

	public Faculdade getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(Faculdade faculdade) {
		this.faculdade = faculdade;
	}

	//Retorna a lista de faculdades para a tabela
	public List<Faculdade> getFaculdades() {
		if (faculdades == null)
			faculdades = service.getFaculdades();

		return faculdades;
	}

	public void remover(Faculdade faculdade) {
		service.remover(faculdade);
		faculdades.remove(faculdade);

	}

}
