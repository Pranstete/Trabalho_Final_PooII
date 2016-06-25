package sistema.beans;



import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;

import org.primefaces.event.RowEditEvent;
import org.primefaces.event.SelectEvent;
import sistema.beans.datamodel.EmpresaDataModel;
import sistema.modelos.Empresa;
import sistema.modelos.Funcionario;
import sistema.service.EmpresaService;





@ManagedBean
@ViewScoped
public class EmpresaManagedBean {

	private Empresa empresa = new Empresa();
	private Empresa empresaSelecionado;
    private EmpresaService servico = new EmpresaService();
    private List <Empresa> empresas;
	

	/**
	 * @return the EmpresaSelecionado
	 */
	public Empresa getEmpresaSelecionado() {
		return empresaSelecionado;
	}

	/**
	 * @param EmpresaSelecionado the EmpresaSelecionado to set
	 */
	public void setEmpresaSelecionado(Empresa empresaSelecionado) {
		this.empresaSelecionado = empresaSelecionado;
	}

	public void salvar()
	{
		servico.salvar(empresa);
		
		if(empresas != null)
			empresas.add(empresa);
		
		
		empresa = new Empresa();
		
	}
	
	public DataModel<Empresa> getEmpresas()
	{
		if(empresas == null)
			empresas = servico.getEmpresas();
		
		return new EmpresaDataModel(empresas);
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}


	public void remove(Empresa empresa)
	{
		if(servico.pesquisarFuncionariosEmpresa(empresa).size() > 0)
		{
		   FacesContext context = FacesContext.getCurrentInstance();
           context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO,"Não é possível remover Empresa","Empresa possui Funcionarios!"));
		}
		else
		{
			servico.remover(empresa);
			empresas.remove(empresa);
		}
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public List <Funcionario> getFuncionariosEmpresa()
	{
		if(empresaSelecionado != null)
		{
			return servico.pesquisarFuncionariosEmpresa(empresaSelecionado);
		}
		else
			return null;
	}
	
	
	public void onRowEdit(RowEditEvent event) {

		Empresa f = ((Empresa) event.getObject());
		servico.alterar(f);
	}

	
	
}

