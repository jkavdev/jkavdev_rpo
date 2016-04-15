package br.com.jkavdev.frameworks.jsf.primefaces.support.user;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.CategoryEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.UserEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.IUserRepository;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_SESSION)
@Named(value = "userBean")
public class UserBean extends BaseBeans {

	private static final long serialVersionUID = 1L;
	private Logger logger = Logger.getLogger(getClass());

	@Inject
	private IUserRepository userRepository;
	private List<UserEntity> users;
	private UserEntity selectedUser;
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

	public UserEntity getSelectedUser() {
		return selectedUser;
	}

	public void setSelectedUser(UserEntity selectedUser) {
		this.selectedUser = selectedUser;
	}
	
	public void selectUser(SelectEvent event) {
		try {
			if (event.getObject() != null) {
				this.selectedUser = (UserEntity) event.getObject();
			} else {
				this.unselectUser();
			}
		} catch (Exception e) {
			this.unselectUser();

			logger.error(e.getMessage(), e);
		}
	}

	public void unselectUser() {
		this.selectedUser = null;
	}
	
	public void delete(){
		if(this.selectedUser != null){
			this.userRepository.delete(this.selectedUser);
		}
	}

}
