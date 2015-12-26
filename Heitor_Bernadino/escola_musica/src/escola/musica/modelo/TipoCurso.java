package escola.musica.modelo;

public enum TipoCurso {
	
	CORDAS("Cordas"), 
	MADEIRAS("Madeiras"), 
	METAIS("Metais"),
	PERCUSSAO("Percussão");
	
	public String descricao;
	
	private TipoCurso(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
