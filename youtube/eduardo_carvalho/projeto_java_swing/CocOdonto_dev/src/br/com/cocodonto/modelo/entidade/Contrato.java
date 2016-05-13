package br.com.cocodonto.modelo.entidade;

public class Contrato {

	private int id;
	private Paciente contratante;
	private Dentista contratada;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Paciente getContratante() {
		return contratante;
	}

	public void setContratante(Paciente contratante) {
		this.contratante = contratante;
	}

	public Dentista getContratada() {
		return contratada;
	}

	public void setContratada(Dentista contratada) {
		this.contratada = contratada;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((contratada == null) ? 0 : contratada.hashCode());
		result = prime * result + ((contratante == null) ? 0 : contratante.hashCode());
		result = prime * result + id;
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
		Contrato other = (Contrato) obj;
		if (contratada == null) {
			if (other.contratada != null)
				return false;
		} else if (!contratada.equals(other.contratada))
			return false;
		if (contratante == null) {
			if (other.contratante != null)
				return false;
		} else if (!contratante.equals(other.contratante))
			return false;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contrato [id=").append(id).append(", contratante=").append(contratante).append(", contratada=")
				.append(contratada).append("]");
		return builder.toString();
	}

}
