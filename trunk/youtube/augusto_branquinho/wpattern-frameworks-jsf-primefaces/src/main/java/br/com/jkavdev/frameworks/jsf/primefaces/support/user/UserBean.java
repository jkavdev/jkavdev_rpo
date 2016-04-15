package br.com.jkavdev.frameworks.jsf.primefaces.support.user;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.UserEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.IUserRepository;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "userBean")
public class UserBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	@Inject
	private IUserRepository userRepository;
	private List<UserEntity> users;
	private Long id;

	public void onLoad() {
		this.users = this.userRepository.findAll();
	}

	public List<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(List<UserEntity> users) {
		this.users = users;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
