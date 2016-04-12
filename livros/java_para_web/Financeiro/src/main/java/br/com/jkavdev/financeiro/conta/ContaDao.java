package br.com.jkavdev.financeiro.conta;

import java.util.List;

import br.com.jkavdev.financeiro.usuario.Usuario;

public interface ContaDao {
	
	public void salvar(Conta conta);
	public void excluir(Conta conta);
	public Conta carregar(Integer conta);
	public List<Conta> listar(Usuario usuario);		//a conta estara relacionada a um usuario, entao buscamos as contas do usuario informado
	public Conta buscarFavorita(Usuario usuario);	//conta favorita do usuario

}
