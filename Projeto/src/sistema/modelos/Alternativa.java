package sistema.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Alternativa implements Serializable {

	private static final long serialVersionUID = 8510557246196457148L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long codigo;

	@Column(nullable = false)
	private int ordem;

	@Column(length = 100, nullable = false)
	private String enunciado;

	@ManyToOne(optional = false)
	@JoinColumn(name = "COD_PERGUNTA", insertable = true, updatable = false, nullable = false)
	private Pergunta pergunta;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public String getEnunciado() {
		return enunciado;
	}

	public void setEnunciado(String enunciado) {
		this.enunciado = enunciado;
	}

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (codigo ^ (codigo >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alternativa other = (Alternativa) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Alternativa [codigo=" + codigo + ", ordem=" + ordem + ", enunciado='" + enunciado + "']";
	}

}
