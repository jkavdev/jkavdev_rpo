package la.foton.modelo;

public class Metodo {

	private String path; 
	private int qtdLinhas;
	
	public Metodo(String path, int qtdLinhas) {
		super();
		this.path = path;
		this.qtdLinhas = qtdLinhas;
	}
	//getters and setters
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public int getQtdLinhas() {
		return qtdLinhas;
	}
	public void setQtdLinhas(int qtdLinhas) {
		this.qtdLinhas = qtdLinhas;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Caminho: " + path +"- Tamanho= " + qtdLinhas;
	}
}
