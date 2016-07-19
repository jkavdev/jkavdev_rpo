package br.com.jkavdev.livraria.model;

public enum RolesEnum {
	
	MANTER_USUARIOS("ROLE_MANTER_USUARIOS", "hasRole('MANTER_USUARIOS')", "/admin/user/**", "Manter usuários sistema"), 
	MANTER_PERFIS("ROLE_MANTER_PERFIS", "hasRole('MANTER_PERFIS')", "/admin/perfil/**", "Manter perfis sistema");

	private String role;
	private String roleAcess;
	private String url;
	private String descricao;

	RolesEnum(String role, String roleAcess, String url, String descricao) {
		this.role = role;
		this.roleAcess = roleAcess;
		this.url = url;
		this.descricao = descricao;
	}

	public String getUrl() {
		return url;
	}

	public String getRole() {
		return role;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getRoleAcess() {
		return roleAcess;
	}

}