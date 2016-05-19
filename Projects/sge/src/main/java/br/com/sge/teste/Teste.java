package br.com.sge.teste;

import br.com.sge.dao.UsuarioDao;
import br.com.sge.modelo.Usuario;

public class Teste {
	
	public static void main(String[] args) {
		
		Usuario usuario = new Usuario();
		usuario.setLogin("Felipe");
		
		
		new UsuarioDao().existe(usuario);
		
	}

}
