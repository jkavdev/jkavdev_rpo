package br.com.jkavdev.livraria.config;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.jkavdev.livraria.model.usuario.Permissao;
import br.com.jkavdev.livraria.model.usuario.Privilegio;
import br.com.jkavdev.livraria.model.usuario.Usuario;
import br.com.jkavdev.livraria.repository.usuario.IPermissaoRepository;
import br.com.jkavdev.livraria.repository.usuario.IPrivilegioRepository;
import br.com.jkavdev.livraria.repository.usuario.IUsuarioRepository;

@Component
public class InitialDataLoader implements ApplicationListener<ContextRefreshedEvent> {

	boolean alreadySetup = false;

	@Autowired
	private IUsuarioRepository userRepository;
	@Autowired
	private IPermissaoRepository roleRepository;
	@Autowired
	private IPrivilegioRepository privilegeRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {
		if (alreadySetup)
			return;

		Privilegio readPrivilege = createPrivilegeIfNotFound("READ_PRIVILEGE");
		Privilegio writePrivilege = createPrivilegeIfNotFound("WRITE_PRIVILEGE");
		List<Privilegio> adminPrivileges = Arrays.asList(readPrivilege, writePrivilege);
		createRoleIfNotFound("ROLE_ADMIN", adminPrivileges);
		createRoleIfNotFound("ROLE_USER", Arrays.asList(readPrivilege));

		Permissao adminRole = roleRepository.findByName("ROLE_ADMIN");
		Usuario user = new Usuario();
		// user.setFirstName("Test");
		// user.setLastName("Test");
		user.setPassword(passwordEncoder.encode("test"));
		user.setEmail("test@test.com");
		user.setPermissoes(Arrays.asList(adminRole));
		user.setEnabled(true);
		userRepository.save(user);

		alreadySetup = true;
	}

	@Transactional
	private Privilegio createPrivilegeIfNotFound(String name) {
		Privilegio privilege = privilegeRepository.findByName(name);
		if (privilege == null) {
			privilege = new Privilegio(name);
			privilegeRepository.save(privilege);
		}
		return privilege;
	}

	@Transactional
	private Permissao createRoleIfNotFound(String name, Collection<Privilegio> privileges) {
		Permissao role = roleRepository.findByName(name);
		if (role == null) {
			role = new Permissao(name);
			role.setPrivilegios(privileges);
			roleRepository.save(role);
		}
		return role;
	}
}