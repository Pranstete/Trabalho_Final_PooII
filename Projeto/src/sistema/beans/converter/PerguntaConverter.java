package sistema.beans.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Conteudo;
import sistema.modelos.Pergunta;
import sistema.service.ConteudoService;
import sistema.service.PerguntaService;

@FacesConverter("perguntaConverter")
public class PerguntaConverter implements Converter {

	private PerguntaService server = new PerguntaService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
		if (value != null && !value.isEmpty()) {
			  for(Pergunta f : server.getList())
				 if(f.getTexto().equals(value))
				  	return f;
		}
		return null;
	}

	public String getAsString(FacesContext fc, UIComponent uic, Object pergunta) {
		if (pergunta == null || pergunta.equals("")) {
			return null;
		} else {
			return ((Pergunta) pergunta).getTexto();
		}
	}
}
