package br.com.jkavdev.frameworks.jsf.primefaces.support.user;

import java.util.ResourceBundle;

import javax.faces.application.Application;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.jkavdev.frameworks.jsf.primefaces.model.UserEntity;
import br.com.jkavdev.frameworks.jsf.primefaces.model.repositories.IUserRepository;
import br.com.jkavdev.frameworks.jsf.primefaces.model.utils.BaseBeans;

@Scope(value = WebApplicationContext.SCOPE_REQUEST)
@Named(value = "userAddEditBean")
public class UserAddEditBean extends BaseBeans {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext context;
	@Inject
	private IUserRepository userRepository;
	@Inject
	private UserBean userBean;
	private UserEntity user;
	private String title;
	
	public UserAddEditBean() {
		this.user = new UserEntity();
	}

	public void add() {
		this.title = this.getResourceProperty("labels", "user_add");
	}

	public void update() {
		this.title = this.getResourceProperty("labels", "user_update");
		this.user = this.userBean.getSelectedUser();
	}
	
	public void save(){
		if(this.user != null){
			if(this.user.getId() == null){
				this.userRepository.save(this.user);
			}else{
				this.userRepository.save(this.user);
			}
		}
	}
	
	public void cancel(){
		this.userBean.unselectUser();
	}
	
	private String getResourceProperty(String resource, String label) {
		Application application = this.context.getApplication();
		ResourceBundle bundle = application.getResourceBundle(this.context, resource);

		return bundle.getString(label);
	}

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
