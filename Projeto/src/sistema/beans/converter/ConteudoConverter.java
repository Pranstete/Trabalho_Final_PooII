package sistema.beans.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Conteudo;
import sistema.service.ConteudoService;



@FacesConverter("conteudoConverter")
public class ConteudoConverter implements Converter {

	private ConteudoService servico = new ConteudoService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Conteudo f : servico.getConteudos())
				 if(f.getDescricao().equals(value))
				  	return f;
					
		}

		return null;

	}

	public String getAsString(FacesContext fc, UIComponent uic,
			Object disciplina) {
		if (disciplina == null || disciplina.equals("")) {
			return null;
		} else {
			return ((Conteudo) disciplina).getDescricao();

		}
	}

}
