package br.com.jkavdev.wpattern.mutrack.userpermission;

import javax.persistence.Entity;
import javax.persistence.Table;

import br.com.jkavdev.wpattern.mutrack.utils.BaseEntity;

//Entidade permissao de usuario
//nao tera nenhum atributo alem das chaves primarias

@Entity
@Table(name = "tb_user_permission")
public class UserPermissionEntity extends BaseEntity<UserPermissionKey> {

	private static final long serialVersionUID = 1L;

}
