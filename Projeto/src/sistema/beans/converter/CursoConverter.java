package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Curso;
import sistema.service.CursoService;

@FacesConverter("cursoConverter")
public class CursoConverter implements Converter {

	private CursoService server = new CursoService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			  for(Curso f : server.getList())
				 if(f.getNome().equals(value))
				  	return f;
		}
		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object curso) {
		if (curso == null || curso.equals("")) {
			return null;
		} else {
			return ((Curso) curso).getNome();
		}
	}
}
