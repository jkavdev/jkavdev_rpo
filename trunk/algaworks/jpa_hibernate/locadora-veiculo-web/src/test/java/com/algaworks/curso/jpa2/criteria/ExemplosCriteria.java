package com.algaworks.curso.jpa2.criteria;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Tuple;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Order;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.persistence.criteria.Subquery;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.algaworks.curso.jpa2.modelo.Aluguel;
import com.algaworks.curso.jpa2.modelo.Carro;
import com.algaworks.curso.jpa2.modelo.Carro_;
import com.algaworks.curso.jpa2.modelo.ModeloCarro;
import com.algaworks.curso.jpa2.modelo.ModeloCarro_;

public class ExemplosCriteria {

	private static EntityManagerFactory factory;
	private EntityManager manager;

	@BeforeClass
	public static void init() {
		factory = Persistence.createEntityManagerFactory("locadoraVeiculoPU");
	}

	@Before
	public void setUp() {
		this.manager = factory.createEntityManager();
	}

	@After
	public void tearDown() {
		this.manager.close();
	}

	@Test
	public void projecoes() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<String> criteriaQuery = builder.createQuery(String.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(carro.<String> get("placa"));

		TypedQuery<String> query = manager.createQuery(criteriaQuery);
		List<String> placas = query.getResultList();

		for (String placa : placas) {
			System.out.println(placa);
		}
	}

	@Test
	public void funcoesDeAgregacao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<BigDecimal> createQuery = builder.createQuery(BigDecimal.class);

		Root<Aluguel> aluguel = createQuery.from(Aluguel.class);
		createQuery.select(builder.sum(aluguel.<BigDecimal> get("valorTotal")));

		BigDecimal total = manager.createQuery(createQuery).getSingleResult();

		System.out.println("Soma de Todos os Alugueis " + total);
	}

	@Test
	public void resultadoComplexo() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Object[]> criteriaQuery = builder.createQuery(Object[].class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.multiselect(carro.get("placa"), carro.get("valorDiaria"));

		TypedQuery<Object[]> query = manager.createQuery(criteriaQuery);
		List<Object[]> resultado = query.getResultList();

		for (Object[] valores : resultado) {
			System.out.println(valores[0] + " - " + valores[1]);
		}
	}

	@Test
	public void resultadoTupla() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Tuple> criteriaQuery = builder.createTupleQuery();

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.multiselect(carro.get("placa").alias("placaCarro"), carro.get("valorDiaria").alias("valorCarro"));

		TypedQuery<Tuple> query = manager.createQuery(criteriaQuery);
		List<Tuple> resultado = query.getResultList();

		for (Tuple tuple : resultado) {
			System.out.println(tuple.get("placaCarro") + " - " + tuple.get("valorCarro"));
		}

	}

	@Test
	public void resultadoConstrutores() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<PrecoCarro> criteriaQuery = builder.createQuery(PrecoCarro.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(builder.construct(PrecoCarro.class, carro.get("placa"), carro.get("valorDiaria")));

		TypedQuery<PrecoCarro> query = manager.createQuery(criteriaQuery);
		List<PrecoCarro> resultado = query.getResultList();

		for (PrecoCarro precoCarro : resultado) {
			System.out.println(precoCarro.getPlaca() + " - " + precoCarro.getValor());
		}
	}

	@Test
	public void exemploFuncao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Predicate predicate = builder.equal(builder.upper(carro.<String> get("cor")), "azul".toUpperCase());

		criteriaQuery.select(carro);
		criteriaQuery.where(predicate);

		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();

		for (Carro carro2 : carros) {
			System.out.println(carro2.getPlaca() + " - " + carro2.getCor());
		}

	}

	@Test
	public void exemploOrdenacao() {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = builder.createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Order order = builder.desc(carro.get("valorDiaria"));

		criteriaQuery.select(carro);
		criteriaQuery.orderBy(order);

		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();

		for (Carro carro2 : carros) {
			System.out.println(carro2.getPlaca() + " - " + carro2.getValorDiaria());
		}
	}

	@Test
	public void exemploJoinEFecth() {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = criteriaBuilder.createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		// informando ao criteria para trazer o modelo, junto com o
		// carro
		// Join<Carro, ModeloCarro> modelo = (Join) carro.fetch("modelo");
		// podemos usar o join, mas ele nao traz o modelo
		// tendo que o jpa fazer todas as querys para trazelos
		// podemos usar o join, para trazer carros com uma condicao baseada no
		// modelo
		Join<Carro, ModeloCarro> modelo = (Join) carro.join("modelo");

		// trazendo apenas os carros com modelo Fiat Siena
		criteriaQuery.where(criteriaBuilder.equal(modelo.get("descricao"), "Fiat Siena"));

		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();

		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getModelo().getDescricao());
		}
	}

	@Test
	public void mediaDasDiariasDosCarros() {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Double> criteriaQuery = criteriaBuilder.createQuery(Double.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		criteriaQuery.select(criteriaBuilder.avg(carro.<Double> get("valorDiaria")));

		TypedQuery<Double> query = manager.createQuery(criteriaQuery);
		Double total = query.getSingleResult();

		System.out.println("Media Diaria: " + total);
	}
	
	@Test
	public void carrosComValoresAcimaDaMedia(){
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = criteriaBuilder.createQuery(Carro.class);
		Subquery<Double> subquery = criteriaQuery.subquery(Double.class);
		
		Root<Carro> carro = criteriaQuery.from(Carro.class);
		Root<Carro> carroSub = subquery.from(Carro.class);
		
		subquery.select(criteriaBuilder.avg(carroSub.<Double>get("valorDiaria")));
		
		criteriaQuery.select(carro);
		criteriaQuery.where(criteriaBuilder.greaterThanOrEqualTo(carro.<Double>get("valorDiaria"), subquery));
		
		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();
		
		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getValorDiaria());
		}
		
	}
	
	@Test
	public void exemploMetamodel() {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<Carro> criteriaQuery = criteriaBuilder.createQuery(Carro.class);

		Root<Carro> carro = criteriaQuery.from(Carro.class);
		
		Join<Carro, ModeloCarro> modelo = (Join) carro.fetch(Carro_.modelo);

		criteriaQuery.where(criteriaBuilder.equal(modelo.get(ModeloCarro_.descricao), "Fiat Siena"));

		TypedQuery<Carro> query = manager.createQuery(criteriaQuery);
		List<Carro> carros = query.getResultList();

		for (Carro c : carros) {
			System.out.println(c.getPlaca() + " - " + c.getModelo().getDescricao());
		}
	}

}
