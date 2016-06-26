package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Professor;
import sistema.service.ProfessorService;

@FacesConverter("professorConverter")
public class ProfessorConverter implements Converter {

	private ProfessorService server = new ProfessorService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			  for(Professor f : server.getList())
				 if(f.getNome().equals(value))
				  	return f;
		}
		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object professor) {
		if (professor == null || professor.equals("")) {
			return null;
		} else {
			return ((Professor) professor).getNome();
		}
	}
}
