package sistema.beans;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import sistema.modelos.Faculdade;
import sistema.service.FaculdadeService;

@ManagedBean(name = "faculdadeManagedBean")
@ViewScoped
public class FaculdadeManagedBean extends sistema.beans.ManagedBean<Faculdade> {

	public FaculdadeManagedBean() {
		super(new FaculdadeService());
	}

	public Faculdade getFaculdade() {
		return model;
	}

	public void setFaculdade(Faculdade faculdade) {
		this.model = faculdade;
	}
	
	public List<Faculdade> getFaculdades() {
		return getList();
	}
}
