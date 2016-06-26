package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Faculdade;
import sistema.service.FaculdadeService;

@FacesConverter("faculdadeConverter")
public class FaculdadeConverter implements Converter {

	private FaculdadeService server = new FaculdadeService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			  for(Faculdade f : server.getList())
				 if(f.getNome().equals(value))
				  	return f;
		}
		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object faculdade) {
		if (faculdade == null || faculdade.equals("")) {
			return null;
		} else {
			return ((Faculdade) faculdade).getNome();
		}
	}
}
