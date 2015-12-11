package br.com.javaparaweb.comercio;

import java.sql.Date;
import java.sql.Time;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;

import br.com.javaparaweb.comercio.entidade.Categoria;
import br.com.javaparaweb.comercio.entidade.Cliente;
import br.com.javaparaweb.comercio.entidade.Empregado;
import br.com.javaparaweb.comercio.entidade.Endereco;
import br.com.javaparaweb.comercio.entidade.Pedido;
import br.com.javaparaweb.comercio.entidade.Produto;
import br.com.javaparaweb.comercio.util.HibernateUtil;

public class Comercio {

	private Session sessao = null;

	public Comercio(Session sessao) {
		this.sessao = sessao;
	}

	private Produto criaProdutoFilmeHobbit() {
		Categoria categoriaFilmes = new Categoria("Filmes",
				"Categoria de Filme");
		sessao.save(categoriaFilmes);

		Produto produto = new Produto();
		produto.setDescricao("O Hobbit");
		produto.setPreco(29.99f);
		produto.setCategoria(categoriaFilmes);

		sessao.save(produto);
		return produto;
	}

	private Produto criaProdutoLivroPeregrino() {
		Categoria categoriaLivros = new Categoria("Livro", "Categoria de Livro");
		sessao.save(categoriaLivros);

		Produto produto = new Produto();
		produto.setDescricao("O Peregrino");
		produto.setPreco(15.75f);
		produto.setCategoria(categoriaLivros);

		sessao.save(produto);
		return produto;
	}

	private Produto criaProdutoAlimentoMistoQuente() {
		Categoria categoriaAlimentos = new Categoria("Alimento",
				"Categoria de Alimento");
		sessao.save(categoriaAlimentos);

		Produto produto = new Produto();
		produto.setDescricao("Misto Quente");
		produto.setPreco(1.99f);
		produto.setCategoria(categoriaAlimentos);

		sessao.save(produto);
		return produto;
	}

	private Cliente criaClienteJhonatan() {
		Cliente cliente = new Cliente();
		cliente.setNome("jhonatan");
		Endereco endereco = new Endereco();
		endereco.setRua("Qr 12 Casa 15");
		endereco.setCidade("Planaltina");
		endereco.setCliente(cliente);
		cliente.setEndereco(endereco);
		sessao.save(cliente);
		return cliente;
	}

	private Cliente criaClienteLucas() {
		Cliente cliente = new Cliente();
		cliente.setNome("lucas");
		Endereco endereco = new Endereco();
		endereco.setRua("Qr 13 Casa 16");
		endereco.setCidade("Planaltina");
		endereco.setCliente(cliente);
		cliente.setEndereco(endereco);
		sessao.save(cliente);
		return cliente;
	}

	private Empregado criaEmpregadoMelo() {
		Empregado chefe = new Empregado();
		chefe.setNome("chefe");
		sessao.save(chefe);
		Empregado empregado = new Empregado();
		empregado.setNome("Melo");
		empregado.setChefe(chefe);
		sessao.save(empregado);
		return empregado;
	}

	private Empregado criaEmpregadoLuckow() {
		Empregado empregado = new Empregado();
		empregado.setNome("Melo");
		sessao.save(empregado);
		return empregado;
	}

	private void criaPedidos() {
		Produto filmeHobbit = criaProdutoFilmeHobbit();
		Produto livroPeregrino = criaProdutoLivroPeregrino();
		Produto alimentoMistoQuente = criaProdutoAlimentoMistoQuente();
		Empregado empregadoLuckow = criaEmpregadoLuckow();
		Empregado empregadoMelo = criaEmpregadoMelo();

		Cliente clienteJhonatan = criaClienteJhonatan();
		Pedido pedido = new Pedido();
		pedido.setCliente(clienteJhonatan);
		pedido.setEmpregado(empregadoLuckow);
		pedido.setDescricao("Pedido do sr Jhonatan");
		pedido.setDataPedido(new Date(System.currentTimeMillis()));
		pedido.setHoraPedido(new Time(System.currentTimeMillis()));
		Set<Produto> produtos = new HashSet<>();
		pedido.setProduto(produtos);
		produtos.add(filmeHobbit);
		produtos.add(livroPeregrino);

		Cliente clienteLucas = criaClienteLucas();
		pedido = new Pedido();
		pedido.setCliente(clienteLucas);
		pedido.setEmpregado(empregadoMelo);
		pedido.setDescricao("Pedido do sr Lucas");
		pedido.setDataPedido(new Date(System.currentTimeMillis()));
		pedido.setHoraPedido(new Time(System.currentTimeMillis()));
		produtos = new HashSet<>();
		pedido.setProduto(produtos);
		produtos.add(filmeHobbit);
		produtos.add(alimentoMistoQuente);

	}
	
	public static void main(String[] args) {
		
		 Session sessao = HibernateUtil.getSessionFactory().openSession();
		 
		 Comercio comercio = new Comercio(sessao);
		 
		 comercio.criaPedidos();
		 
		 System.out.println("Cadastrou!");
		
	}
}
