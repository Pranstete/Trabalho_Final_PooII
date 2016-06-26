package sistema.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sistema.modelos.Curso;
import sistema.modelos.Disciplina;

public class DisciplinaService extends Service<Disciplina> implements Serializable {
	
	private static final long serialVersionUID = 1L;

	public List<Disciplina> getDisciplinasPorCurso(Curso curso) {
		String query = "Select f From Disciplina f where f.curso.codigo = :codigoCurso order by f.nome";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoCurso", curso.getCodigo());
		return getList(query, parameters);
	}
}
