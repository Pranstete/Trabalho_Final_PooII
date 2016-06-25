package sistema.beans.datamodel;

import java.util.List;

import javax.faces.model.ListDataModel;
import org.primefaces.model.SelectableDataModel;
import sistema.modelos.Empresa;
import sistema.service.EmpresaService;


public class EmpresaDataModel extends ListDataModel<Empresa> implements SelectableDataModel<Empresa> 
{
	private EmpresaService servico = new EmpresaService();
	
	public EmpresaDataModel()
	{
		
	}

	public EmpresaDataModel(List <Empresa> list)
	{
	   super(list);	
	}

	
	public Empresa getRowData(String rowKey) {
		
		for(Empresa f: servico.getEmpresas())
		   if(Integer.parseInt(rowKey) ==  f.getCodigo())
			   return f;
		
		return null;
	}

	public Object getRowKey(Empresa empresa) {
		return empresa.getCodigo();
	}
	
}