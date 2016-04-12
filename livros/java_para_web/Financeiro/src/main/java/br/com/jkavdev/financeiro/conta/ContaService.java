package br.com.jkavdev.financeiro.conta;

import java.util.Date;
import java.util.List;

import br.com.jkavdev.financeiro.usuario.Usuario;
import br.com.jkavdev.financeiro.util.DaoFactory;

public class ContaService {

	ContaDao contaDao;

	public ContaService() {
		this.contaDao = DaoFactory.criarContaDao();
	}

	public List<Conta> listar(Usuario usuario) {
		return this.contaDao.listar(usuario);
	}

	public Conta carregar(Integer conta) {
		return this.contaDao.carregar(conta);
	}

	public void salvar(Conta conta) {
		conta.setDataCadastro(new Date());								//quando a conta for salva, salva com a data atual no momento da acao 
		this.contaDao.salvar(conta);
	}

	public void excluir(Conta conta) {
		this.contaDao.excluir(conta);
	}

	public void tornarFavorita(Conta contaFavorita) {
		Conta conta = this.buscarFavorita(contaFavorita.getUsuario());	//busca conta favorita do usuario

		if (conta != null) {											//se tiver uma conta favorita
			conta.setFavorita(false);									//seta favorita como false
			this.contaDao.salvar(conta);								//salva no banco
		}

		contaFavorita.setFavorita(true);								//seta a conta informada como favorita
		this.contaDao.salvar(contaFavorita);							//salva no banco
	}

	public Conta buscarFavorita(Usuario usuario) {
		return this.contaDao.buscarFavorita(usuario);
	}

}
