package sistema.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Pergunta implements Serializable, Comparable<Pergunta> {

	private static final long serialVersionUID = -4247759259576529210L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long codigo;

	@Column(nullable = false)
	private String texto;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private TipoPergunta tipo;

	@JoinColumn(name = "cod_conteudo", nullable = false)
	private Conteudo conteudo;

	@ManyToOne
	@JoinColumn(name = "ParentPergunta")
	private Pergunta parentPergunta;

	private int ordem;

	// @OneToMany(cascade = CascadeType.ALL, mappedBy = "pergunta")
	// private List<Alternativa> alternativas = new ArrayList<Alternativa>();

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public TipoPergunta getTipo() {
		return tipo;
	}

	public void setTipo(TipoPergunta tipo) {
		this.tipo = tipo;
	}

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
	// public List<Alternativa> getAlternativas() {
	// return alternativas;
	// }
	//
	// public void setAlternativas(List<Alternativa> alternativas) {
	// this.alternativas = alternativas;
	// }

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
		Pergunta other = (Pergunta) obj;
		if (codigo != other.codigo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Pergunta [codigo=" + codigo + ", texto=" + texto + ", tipo=" + tipo + ", conteudo=" + conteudo + "]";
	}

	public Pergunta getParentPergunta() {
		return parentPergunta;
	}

	public void setParentPergunta(Pergunta parentPergunta) {
		this.parentPergunta = parentPergunta;
	}

	public int getOrdem() {
		return ordem;
	}

	public void setOrdem(int ordem) {
		this.ordem = ordem;
	}

	public int compareTo(Pergunta pergunta) {
		if (this.ordem > pergunta.ordem) {
			return -1;
		} else if (this.ordem < pergunta.ordem) {
			return 1;
		}

		return 0;
	}
}
