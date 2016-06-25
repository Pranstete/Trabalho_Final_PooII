package sistema.beans.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Disciplina;
import sistema.service.DisciplinaService;



@FacesConverter("disciplinaConverter")
public class DisciplinaConverter implements Converter {

	private DisciplinaService servico = new DisciplinaService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Disciplina f : servico.getDisciplinas())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	public String getAsString(FacesContext fc, UIComponent uic,
			Object disciplina) {
		if (disciplina == null || disciplina.equals("")) {
			return null;
		} else {
			return ((Disciplina) disciplina).getNome();

		}
	}

}
