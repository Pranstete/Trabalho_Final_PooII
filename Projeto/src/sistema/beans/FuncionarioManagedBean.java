package sistema.beans;


import java.util.List;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import org.primefaces.event.RowEditEvent;

import sistema.modelos.Empresa;
import sistema.modelos.Funcionario;
import sistema.service.EmpresaService;
import sistema.service.FuncionarioService;




@ManagedBean(name="produtoManagedBean")
@ViewScoped
public class FuncionarioManagedBean {

	private Funcionario funcionario = new Funcionario();
	private Empresa empresa;
    private FuncionarioService funcService = new FuncionarioService();
    private EmpresaService empService = new EmpresaService();
    private List <Funcionario> funcionarios;
    
	
	public void salvar()
	{
		empresa.addFuncionario(funcionario);
		funcionario.setEmpresa(empresa);
		funcionarios.add(funcionario);
		
		funcService.salvar(funcionario);
		
		funcionario = new Funcionario();
		empresa = null;
		
	}
	
	
	
	public List <Empresa> getEmpresas()
	{
		return empService.getEmpresas();
		
	}
	
	
	public Empresa getEmpresa() {
		return empresa;
	}


	public void remove(Funcionario funcionario)
	{
		funcionarios.remove(funcionario);
		funcService.remover(funcionario);
		
	}
	
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}
	public void setFuncionario(Funcionario funcionario) {
		this.funcionario = funcionario;
	}
	
	public List<Funcionario> getFuncionarios() {
		if(funcionarios == null)
			funcionarios = funcService.getFuncionarios();
		
		return funcionarios;
	}
	
	
	public void onRowEdit(RowEditEvent event) {

		Funcionario p = ((Funcionario) event.getObject());
		funcService.alterar(p);
	}

	
	
	
}
