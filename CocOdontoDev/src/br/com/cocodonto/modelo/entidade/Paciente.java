package br.com.cocodonto.modelo.entidade;

public class Paciente {

	private Long id;
	private String nome;
	private String rg;
	private String cpf;
	private SexoType sexo;
	private Endereco endereco;
	private Contato contato;

	public Paciente(Long id, String nome, String rg, String cpf, SexoType sexo, Endereco endereco, Contato contato) {
		this(id, nome, rg, cpf, sexo);
		this.endereco = endereco;
		this.contato = contato;
	}

	public Paciente(Long id, String nome, String rg, String cpf, SexoType sexo) {
		this(nome, rg, cpf, sexo);
		this.id = id;
	}

	public Paciente(String nome, String rg, String cpf, SexoType sexo) {
		this();
		this.nome = nome;
		this.rg = rg;
		this.cpf = cpf;
		this.sexo = sexo;
	}	

	public Paciente() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public SexoType getSexo() {
		return sexo;
	}

	public void setSexo(SexoType sexo) {
		this.sexo = sexo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Contato getContato() {
		return contato;
	}

	public void setContato(Contato contato) {
		this.contato = contato;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + ((rg == null) ? 0 : rg.hashCode());
		result = prime * result + ((sexo == null) ? 0 : sexo.hashCode());
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
		Paciente other = (Paciente) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (rg == null) {
			if (other.rg != null)
				return false;
		} else if (!rg.equals(other.rg))
			return false;
		if (sexo != other.sexo)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Paciente [id=").append(id).append(", nome=").append(nome).append(", rg=").append(rg)
				.append(", cpf=").append(cpf).append(", sexo=").append(sexo).append(", endereco=").append(endereco)
				.append(", contato=").append(contato).append("]");
		return builder.toString();
	}

}
