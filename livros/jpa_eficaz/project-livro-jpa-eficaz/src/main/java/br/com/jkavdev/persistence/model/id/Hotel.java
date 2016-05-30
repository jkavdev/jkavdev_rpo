package br.com.jkavdev.persistence.model.id;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "hotels")

@SequenceGenerator(
		name = Hotel.SEQUENCE_NAME,			//nome do gerador de sequencia na jpa
		sequenceName = Hotel.SEQUENCE_NAME,	//nome do gerador de sequencia no banco
		allocationSize = 50,				//quantidade de ids buscados, que ficaram na memoria
		initialValue = 1)					//valor inicial, no caso quando for persistido será com id=2

public class Hotel implements Serializable {

	private static final long serialVersionUID = 1L;
	public static final String SEQUENCE_NAME = "hotel_sequence";

	private Long id;
	private String name;
	private String address;
	private String postCode;

	//a jpa buscara um lote de ids e salvara na memoria
	//jpa persiste o objeto utilizando o id em memoria
	//ao se acabar os ids em memoria, a jpa buscara mais um lote de ids
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = SEQUENCE_NAME)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPostCode() {
		return postCode;
	}

	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}

}
