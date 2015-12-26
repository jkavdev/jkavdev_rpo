package escola.musica.modelo;

public enum TipoCurso {
	
	CORDAS("Cordas"), 
	MADEIRAS("Madeiras"), 
	METAIS("Metais"),
	PERCUSSAO("Percuss�o");
	
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
