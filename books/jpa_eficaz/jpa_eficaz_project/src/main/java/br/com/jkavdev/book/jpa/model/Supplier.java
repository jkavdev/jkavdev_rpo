package br.com.jkavdev.book.jpa.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.Table;

//a base de uma entidade é
//ser anotada com @Entity, ter um construtor vazio,
//e ter uma chave primaria

@Entity
@Table(name = "suppliers" // nome da tabela
)
public class Supplier {

	private int id;
	private String nome;

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	// optional - indica que se o atributo pode ou nao estar nulo
	// fetch - indica se o atributo sera carregado juntamente com a entidade
	@Basic(optional = false, fetch = FetchType.EAGER)
	// indicando nome, tamanho e unicidade e se o valor pode ser nulo do atributo
	@Column(
			name = "nome", 
			length = 100, 
			unique = true, 
			nullable = false 
			)
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

}
