package br.com.cocodonto.modelo.entidade;

public class Contato {

	private String email;
	private String telefone;
	private String celuar;

	public Contato() {
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCeluar() {
		return celuar;
	}

	public void setCeluar(String celuar) {
		this.celuar = celuar;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((celuar == null) ? 0 : celuar.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((telefone == null) ? 0 : telefone.hashCode());
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
		Contato other = (Contato) obj;
		if (celuar == null) {
			if (other.celuar != null)
				return false;
		} else if (!celuar.equals(other.celuar))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (telefone == null) {
			if (other.telefone != null)
				return false;
		} else if (!telefone.equals(other.telefone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Contato "
				+ "[email=").append(email)
				.append(", telefone=").append(telefone)
				.append(", celuar=").append(celuar)
				.append("]");
		return builder.toString();
	}

}