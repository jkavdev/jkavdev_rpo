package br.com.caelum.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import br.com.caelum.model.Loja;
import br.com.caelum.model.Produto;

@Repository
public class ProdutoDao {

	@PersistenceContext
	private EntityManager em;

	public List<Produto> getProdutos() {
		return em.createQuery("from Produto", Produto.class).getResultList();
	}

	public Produto getProduto(Integer id) {
		Produto produto = em.find(Produto.class, id);
		return produto;
	}

	public List<Produto> getProdutos(String nome, Integer categoriaId, Integer lojaId) {

		// prover a query a ser criada e metodos adicionais como igual, maior,
		// menor
		CriteriaBuilder criteriaBuilder = em.getCriteriaBuilder();

		// posso informar qual sera o tipo de retorno da query
		CriteriaQuery<Produto> query = criteriaBuilder.createQuery(Produto.class);

		// Obtendo acesso ao tipo da classe
		Root<Produto> root = query.from(Produto.class);

		// obtendo acesso aos atributos classe
		Path<String> nomePath = root.<String>get("nome");

		// acessando o atributo id no relacionamento com categorias
		// precisamos relizar um join, há uma associacao entre as entidades
		Path<Integer> categoriaPath = root.join("categorias").<Integer>get("id");

		// acessando o atributo id de loja
		Path<Integer> lojaPath = root.<Loja>get("loja").<Integer>get("id");

		// criando lista de predicados
		// para armazenar os predicas e passar como array no where da query
		List<Predicate> predicates = new ArrayList<>();

		// criando filtro
		// verificando variaveis passadas
		if (!nome.isEmpty()) {
			Predicate nomeIgual = criteriaBuilder.like(nomePath, nome);
			predicates.add(nomeIgual);
		}

		if (categoriaId != null) {
			Predicate categoriaIgual = criteriaBuilder.equal(categoriaPath, categoriaId);
			predicates.add(categoriaIgual);
		}

		if (lojaId != null) {
			Predicate lojaIgual = criteriaBuilder.equal(lojaPath, lojaId);
			predicates.add(lojaIgual);
		}

		// adiciona filtro a query
		query.where((Predicate[]) predicates.toArray(new Predicate[0]));

		TypedQuery<Produto> typedQuery = em.createQuery(query);
		return typedQuery.getResultList();

	}

	public void insere(Produto produto) {
		if (produto.getId() == null)
			em.persist(produto);
		else
			em.merge(produto);
	}

}
