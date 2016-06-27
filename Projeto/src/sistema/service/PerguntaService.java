package sistema.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sistema.modelos.Disciplina;
import sistema.modelos.Pergunta;

public class PerguntaService extends Service<Pergunta> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Pergunta> getPerguntasPorDisciplina(Disciplina disciplina) {
		String query = "Select f From Pergunta f where f.conteudo.disciplina.codigo = :codigoDisciplina";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoDisciplina", disciplina.getCodigo());
		return getList(query, parameters);
	}
}
