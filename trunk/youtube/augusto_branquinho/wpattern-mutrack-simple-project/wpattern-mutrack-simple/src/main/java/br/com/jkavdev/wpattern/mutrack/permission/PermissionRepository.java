package br.com.jkavdev.wpattern.mutrack.permission;

import org.springframework.data.jpa.repository.JpaRepository;

//Repositorio de permissao

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

}
