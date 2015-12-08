package escola.musica.modelo;

public enum TipoCurso {
	
	CORDAS("Cordas"), 
	MADEIRAS("Madeiras"),
	METAIS("Metais"), 
	PERCUSSAO("Percussão");
	
	private String descricao;
	
	private TipoCurso(String decricao) {
		this.descricao = decricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
}
