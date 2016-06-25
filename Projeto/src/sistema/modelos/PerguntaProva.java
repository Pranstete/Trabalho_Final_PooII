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
public class PerguntaProva implements Serializable {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long codigo;
	
	@Column(nullable=false)
	private int ordem;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="COD_PERGUNTA", nullable=false)
	private Pergunta pergunta;

	@ManyToOne(optional=false)
	@JoinColumn(name="COD_PROVA", nullable=false)
	private Prova prova;

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

	public Pergunta getPergunta() {
		return pergunta;
	}

	public void setPergunta(Pergunta pergunta) {
		this.pergunta = pergunta;
	}

	public Prova getProva() {
		return prova;
	}

	public void setProva(Prova prova) {
		this.prova = prova;
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
		PerguntaProva other = (PerguntaProva) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}
	
	
	
	
}
