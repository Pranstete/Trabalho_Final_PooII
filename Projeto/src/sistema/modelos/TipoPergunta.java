package sistema.modelos;

import java.io.Serializable;

public enum TipoPergunta implements Serializable {

	DISSERTATIVA("Dissertaviva"),
	BOOLEANA("Verdadeiro/Falso"),
	ALTERNATIVA("Alternativa");
	
	private TipoPergunta(String descricao) {
		this.descricao = descricao;
	}

	private final String descricao;
	
	public String getDescricao() {
		return descricao;
	}
	
}
