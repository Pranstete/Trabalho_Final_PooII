package sistema.beans.converter;



import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import sistema.modelos.Empresa;
import sistema.service.EmpresaService;



@FacesConverter("converterEmpresa")
public class EmpresaConverter implements Converter {

	private EmpresaService servico = new EmpresaService();
	
	public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

		
		if (value != null && !value.isEmpty()) {
			
			  for(Empresa f : servico.getEmpresas())
				 if(f.getNome().equals(value))
				  	return f;
					
		}

		return null;

	}

	public String getAsString(FacesContext fc, UIComponent uic,
			Object empresa) {
		if (empresa == null || empresa.equals("")) {
			return null;
		} else {
			return ((Empresa) empresa).getNome();

		}
	}

}
