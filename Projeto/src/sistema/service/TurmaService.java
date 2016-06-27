package sistema.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sistema.modelos.Disciplina;
import sistema.modelos.Turma;

public class TurmaService extends Service<Turma> implements Serializable {

	private static final long serialVersionUID = 1L;

	public List<Turma> getTurmaPorDisciplina(Disciplina disciplina) {
		String query = "Select f From Turma f where f.disciplina.codigo = :codigoDisciplina order by f.nome";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoDisciplina", disciplina.getCodigo());
		return getList(query, parameters);
	}
}
