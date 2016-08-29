package br.com.jkavdev.wpattern.mutrack.user;

import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio de Usuario

public interface UserRepository extends JpaRepository<UserEntity, Long> {

	// realizando busca atraves do nome do metodo
	// buscando usuario baseado no email
	public UserEntity findByEmail(String email);
	
	//busca usuario por email ou nome
	public UserEntity findByEmailOrName(String email, String name);

}
