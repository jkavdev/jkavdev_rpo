package la.foton.sonar.util;

public class ProjectNameSplitter {
	private String projeto;
	private String produto;
	private String cliente;
	
	public ProjectNameSplitter(String projeto) {
		this.projeto = projeto;
		
		if (projeto.contains("-")) {
			String[] parts = projeto.split("-", 2);
			this.cliente = parts[0];
			this.produto = parts[1];
		} else {
			this.cliente = null;
			this.produto = projeto;
		}
		
	}

	public String getProjeto() {
		return projeto;
	}

	public String getProduto() {
		return produto;
	}

	public String getCliente() {
		return cliente;
	}
}
