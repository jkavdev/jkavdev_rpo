package br.com.jkavdev.frameworks.jsf.primefaces.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.jkavdev.frameworks.jsf.primefaces.model.UserEntity;

public interface IUserRepository extends JpaRepository<UserEntity, Long> {

	public UserEntity findByUsernameAndPassword(String username, String password);

}
