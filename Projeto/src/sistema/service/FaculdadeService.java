package sistema.service;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import sistema.modelos.Faculdade;
import sistema.modelos.Professor;


public class FaculdadeService extends Service<Faculdade> implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	public List<Faculdade> getFaculdadesPorProfessor(Professor professor) {
		String query = "Select f From Faculdade f where f In "
				+ "(Select c.faculdade From Curso c where c In "
					+ "(Select d.curso From Disciplina d where d In "
						+ "(Select t.disciplina From Turma t where t.professor.codigo = :codigoProfessor))) order by f.nome";
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("codigoProfessor", professor.getCodigo());
		return getList(query, parameters);
	}
	
}