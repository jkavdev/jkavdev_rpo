package br.com.jkavdev.comercio.modelo.crud;

import java.sql.Time;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jkavdev.comercio.modelo.entidade.Categoria;
import br.com.jkavdev.comercio.modelo.entidade.Cliente;
import br.com.jkavdev.comercio.modelo.entidade.Empregado;
import br.com.jkavdev.comercio.modelo.entidade.Endereco;
import br.com.jkavdev.comercio.modelo.entidade.Pedido;
import br.com.jkavdev.comercio.modelo.entidade.Produto;
import br.com.jkavdev.hibernate.conexao.HibernateUtil;

public class Comercio {

	private Session session = null;

	public Comercio(Session session) {
		this.session = session;
	}

	private Produto criarProdutoFilmeHobbit() {
		Categoria categoria = new Categoria("Filmes", "Categoria de Filmes");
		this.session.save(categoria);
		
		Produto produto = new Produto();
		produto.setDescricao("O Hobbit");
		produto.setPreco(29.99f);
		produto.setCategoria(categoria);
		this.session.save(produto);
		
		return produto;
	}

	private Produto criarProdutoLivroPeregrino() {
		Categoria categoria = new Categoria("Livros", "Categoria de Livros");
		this.session.save(categoria);
		
		Produto produto = new Produto();
		produto.setDescricao("O Peregrino");
		produto.setPreco(15.75f);
		produto.setCategoria(categoria);
		this.session.save(produto);
		
		return produto;
	}

	private Produto criarProdutoAlimentoMistoQuente() {
		Categoria categoria = new Categoria("Alimentos", "Categoria de Alimentos");
		this.session.save(categoria);
		
		Produto produto = new Produto();
		produto.setDescricao("Misto Quente");
		produto.setPreco(10.99f);
		produto.setCategoria(categoria);
		this.session.save(produto);
		
		return produto;
	}

	private Cliente criarClienteJhonatan() {
		Cliente cliente = new Cliente();
		cliente.setNome("Jhonatan");
		
		Endereco endereco = new Endereco();
		endereco.setRua("QR 12 CASA 15");
		endereco.setCidade("Planaltina");
		endereco.setCliente(cliente);
		
		cliente.setEndereco(endereco);		
		this.session.save(endereco);
		
		return cliente;
	}

	private Cliente criarClienteLucas() {
		Cliente cliente = new Cliente();
		cliente.setNome("Lucas");
		
		Endereco endereco = new Endereco();
		endereco.setRua("QR 12 CASA 15");
		endereco.setCidade("Planaltina");
		endereco.setCliente(cliente);
		
		cliente.setEndereco(endereco);
		this.session.save(endereco);
		
		return cliente;
	}

	private Empregado criarEmpregadoJhonatan() {
		Empregado chefe = new Empregado();
		chefe.setNome("Chefe");
		this.session.save(chefe);

		Empregado empregado = new Empregado();
		empregado.setNome("Jhonatan");
		empregado.setChefe(chefe);
		this.session.save(empregado);

		return empregado;
	}

	private Empregado criarEmpregadoLucas() {
		Empregado empregado = new Empregado();
		empregado.setNome("Lucas");
		this.session.save(empregado);

		return empregado;
	}

	public void criarPedidos(){
		Produto hobbit = criarProdutoFilmeHobbit();
		Produto pregrino = criarProdutoLivroPeregrino();
		Produto mistoQuente = criarProdutoAlimentoMistoQuente();
		
		Empregado jhonatan = criarEmpregadoJhonatan();
		Empregado lucas = criarEmpregadoLucas();
		
		Cliente clienteJhonatan = criarClienteJhonatan();
		
		Pedido pedido = new Pedido();
		pedido.setCliente(clienteJhonatan);
		pedido.setEmpregado(jhonatan);
		pedido.setDescricao("Pedido do Jhonatan");
		pedido.setDataPedido(new Date(System.currentTimeMillis()));
		pedido.setHoraPedido(new Time(System.currentTimeMillis()));
		
		Set<Produto> produtosJhonatan = new HashSet<Produto>();
		pedido.setProdutos(produtosJhonatan);
		produtosJhonatan.add(hobbit);
		produtosJhonatan.add(mistoQuente);
		this.session.save(pedido);
		
		Cliente clienteLucas = criarClienteLucas();
		
		pedido = new Pedido();
		pedido.setCliente(clienteLucas);
		pedido.setEmpregado(lucas);
		pedido.setDescricao("Pedido do Lucas");
		pedido.setDataPedido(new Date(System.currentTimeMillis()));
		pedido.setHoraPedido(new Time(System.currentTimeMillis()));
		
		Set<Produto> produtos = new HashSet<Produto>();
		pedido.setProdutos(produtos);
		produtos.add(hobbit);
		produtos.add(pregrino);
		this.session.save(pedido);
	}

	public static void main(String[] args) {
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = sessao.beginTransaction();
		
		Comercio comercio = new Comercio(sessao);
		comercio.criarPedidos();
		
		transaction.commit();
		
		System.out.println("Cadastrado!");
		
	}
	
}
