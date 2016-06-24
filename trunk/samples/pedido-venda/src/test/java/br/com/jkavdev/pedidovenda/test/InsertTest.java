package br.com.jkavdev.pedidovenda.test;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.pedidovenda.model.Categoria;
import br.com.jkavdev.pedidovenda.model.Cliente;
import br.com.jkavdev.pedidovenda.model.Endereco;
import br.com.jkavdev.pedidovenda.model.EnderecoEntrega;
import br.com.jkavdev.pedidovenda.model.FormaPagamento;
import br.com.jkavdev.pedidovenda.model.Grupo;
import br.com.jkavdev.pedidovenda.model.ItemPedido;
import br.com.jkavdev.pedidovenda.model.Pedido;
import br.com.jkavdev.pedidovenda.model.Produto;
import br.com.jkavdev.pedidovenda.model.StatusPedido;
import br.com.jkavdev.pedidovenda.model.TipoPessoa;
import br.com.jkavdev.pedidovenda.model.Usuario;

public class InsertTest {

	private EntityManagerFactory factory;
	private EntityManager manager;

	@Before
	public void init() {
		this.factory = Persistence.createEntityManagerFactory("pedidoPU");
		this.manager = this.factory.createEntityManager();
	}

	@After
	public void close() {
		this.manager.close();
		this.factory.close();
	}

	@Test
	public void insertCliente() {

		Cliente jhonatan = criaCliente("Jhonatan", "jhonatan@gmail.com", TipoPessoa.FISICA, "04488289100");
		Endereco itapua = criaEndereco("73754012", "Planaltina", "Casa", "QR 12 CASA 15", "15", "GO");

		jhonatan.adicionaEndereco(itapua);

		beginTransaction();

		this.manager.persist(jhonatan);

		commit();
	}

	@Test
	public void insertGrupo() {
		Grupo administrador = criaGrupo("Administrador", "Administrador de Rede");
		Grupo gerente = criaGrupo("Gerente", "Gerente do Sistema");
		Grupo usuario = criaGrupo("Usuario", "Usuario normal");

		beginTransaction();
		this.manager.persist(usuario);
		this.manager.persist(gerente);
		this.manager.persist(administrador);
		commit();
	}

	@Test
	public void insertUsuario() {
		List<Grupo> grupos = this.manager.createQuery("from Grupo", Grupo.class).getResultList();

		Usuario ian = criaUsuario("ian@gmail.com", "ian", "123456");
		Usuario felipe = criaUsuario("felipe@gmail.com", "felipe", "212");
		Usuario jhonatan = criaUsuario("jhonatan@gmail.com", "jhonatan", "12344");

		beginTransaction();

		for (Grupo grupo : grupos) {
			if (grupo.getNome().equals("Administrador")) {
				ian.getGrupos().add(grupo);
			} else if (grupo.getNome().equals("Gerente")) {
				ian.getGrupos().add(grupo);
				felipe.getGrupos().add(grupo);
			} else if (grupo.getNome().equals("Usuario")) {
				jhonatan.getGrupos().add(grupo);
			}

			System.out.println(grupo.getDescricao());
		}

		this.manager.persist(jhonatan);
		this.manager.persist(ian);
		this.manager.persist(felipe);

		commit();
	}

	@Test
	public void insertProduto() {

		List<Categoria> categorias = this.manager.createQuery("from Categoria", Categoria.class).getResultList();

		beginTransaction();

		for (Categoria categoria : categorias) {
			if (categoria.getDescricao().equals("Monitores")) {
				Produto monitor = criaProduto(categoria, "Monitor", 100, "LL1254", BigDecimal.valueOf(256));
				this.manager.persist(monitor);
			} else if (categoria.getDescricao().equals("Computadores")) {
				Produto computador = criaProduto(categoria, "Computador", 100, "LL1264", BigDecimal.valueOf(1256));
				this.manager.persist(computador);
			} else if (categoria.getDescricao().equals("Acessórios")) {
				Produto teclado = criaProduto(categoria, "Teclado", 100, "LL1274", BigDecimal.valueOf(26));
				Produto fonte = criaProduto(categoria, "Fonte", 100, "LL1284", BigDecimal.valueOf(26));
				Produto mouse = criaProduto(categoria, "Mouse", 100, "LL1294", BigDecimal.valueOf(56));
				this.manager.persist(teclado);
				this.manager.persist(fonte);
				this.manager.persist(mouse);
			}
		}

		commit();
	}

	@Test
	public void insertPedido() {
		Cliente cliente = this.manager.find(Cliente.class, 1L);
		EnderecoEntrega enderecoEntrega = criaEnderecoEntrega("73754012", "Brasilia", "Empresa", "Qr12 casa15", "15", "DF");
		Usuario vendedor = this.manager.find(Usuario.class, 8L);
		Produto produto = this.manager.find(Produto.class, 1L);

		Pedido pedido = criaPedido(cliente, enderecoEntrega,
				FormaPagamento.CARTAO_CREDITO, "Nada a Consta",
				StatusPedido.ORCAMENTO, BigDecimal.valueOf(5),
				BigDecimal.valueOf(150), vendedor, BigDecimal.valueOf(500));

		ItemPedido item1 = criaItemPedido(produto, 2, BigDecimal.valueOf(150), pedido);

		pedido.adicionaItem(item1);

		beginTransaction();
		this.manager.persist(pedido);
		commit();
	}

	public void beginTransaction() {
		this.manager.getTransaction().begin();
	}

	public void commit() {
		this.manager.getTransaction().commit();
	}

	public Usuario criaUsuario(String email, String nome, String senha) {
		Usuario usuario = new Usuario();
		usuario.setEmail(email);
		usuario.setNome(nome);
		usuario.setSenha(senha);

		return usuario;
	}

	public Grupo criaGrupo(String nome, String descricao) {
		Grupo grupo = new Grupo();
		grupo.setDescricao(descricao);
		grupo.setNome(nome);

		return grupo;

	}

	public Produto criaProduto(Categoria categoria, String nome, Integer quantidadeEstoque, String sku, BigDecimal valorUnitario) {
		Produto produto = new Produto();
		produto.setCategoria(categoria);
		produto.setNome(nome);
		produto.setQuantidadeEstoque(quantidadeEstoque);
		produto.setSku(sku);
		produto.setValorUnitario(valorUnitario);

		return produto;
	}

	public ItemPedido criaItemPedido(Produto produto, Integer quantidade, BigDecimal valorUnitario, Pedido pedido) {
		ItemPedido itemPedido = new ItemPedido();
		itemPedido.setProduto(produto);
		itemPedido.setQuantidade(quantidade);
		itemPedido.setValorUnitario(valorUnitario);
		itemPedido.setPedido(pedido);

		return itemPedido;
	}

	public Pedido criaPedido(Cliente cliente, EnderecoEntrega enderecoEntrega,
			FormaPagamento formaPagamento, String observacao,
			StatusPedido statusPedido, BigDecimal valorDesconto,
			BigDecimal valorFrete, Usuario vendedor, BigDecimal valorTotal) {
		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setDataCriacao(new Date());
		pedido.setDataEntrega(new Date());
		pedido.setEnderecoEntrega(enderecoEntrega);
		pedido.setFormaPagamento(formaPagamento);
		pedido.setObservacao(observacao);
		pedido.setStatusPedido(statusPedido);
		pedido.setValorDesconto(valorDesconto);
		pedido.setValorFrete(valorFrete);
		pedido.setValorTotal(valorTotal);
		pedido.setVendedor(vendedor);
		return pedido;
	}

	public EnderecoEntrega criaEnderecoEntrega(String cep, String cidade, String complemento, String logradouro, String numero, String uf) {
		EnderecoEntrega endereco = new EnderecoEntrega();
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setUf(uf);

		return endereco;
	}

	public Endereco criaEndereco(String cep, String cidade, String complemento, String logradouro, String numero, String uf) {
		Endereco endereco = new Endereco();
		endereco.setCep(cep);
		endereco.setCidade(cidade);
		endereco.setComplemento(complemento);
		endereco.setLogradouro(logradouro);
		endereco.setNumero(numero);
		endereco.setUf(uf);

		return endereco;
	}

	private Cliente criaCliente(String nome, String email, TipoPessoa tipoPessoa, String documentoReceitaFederal) {
		Cliente cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setEmail(email);
		cliente.setTipoPessoa(tipoPessoa);
		cliente.setDocumentoReceitaFederal(documentoReceitaFederal);
		return cliente;
	}

}
