package br.com.jkavdev.wpattern.mutrack.user;

import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio de Usuario

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
