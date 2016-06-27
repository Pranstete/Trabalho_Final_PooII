package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Turma;
import sistema.service.TurmaService;

@FacesConverter("turmaConverter")
public class TurmaConverter implements Converter {

	private TurmaService server = new TurmaService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			  for(Turma f : server.getList())
				 if(f.getNome().equals(value))
				  	return f;
		}
		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object turma) {
		if (turma == null || turma.equals("")) {
			return null;
		} else {
			return ((Turma) turma).getNome();
		}
	}
}
