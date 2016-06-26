package sistema.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sistema.modelos.Conteudo;
import sistema.modelos.Disciplina;

public class ConteudoService extends Service<Conteudo> implements Serializable {

	private static final long serialVersionUID = -1362864098017792668L;

	public List<Conteudo> getConteudosPorDisciplina(Disciplina disciplina) {
		String query = "Select f From Conteudo f where f.disciplina.codigo = :codigoDisciplina order by f.descricao";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoDisciplina", disciplina.getCodigo());
		return getList(query, parameters);
	}
}
