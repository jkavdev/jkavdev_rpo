package br.com.jkavdev.hibernate.crudannotations;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.jkavdev.hibernate.conexao.HibernateUtil;
import br.com.jkavdev.hibernate.modelo.Contato;

public class ContatoCrudAnnotations {

	private Session session;

	public ContatoCrudAnnotations(Session session) {
		this.session = session;
	}

	public void salvar(Contato contato) {
		this.session.save(contato);
	}

	public void atualizar(Contato contato) {
		this.session.update(contato);
	}

	public void excluir(Contato contato) {
		this.session.delete(contato);
		this.session.flush();
	}

	@SuppressWarnings("unchecked")
	public List<Contato> listar() {
		return this.session.createQuery("from Contato").list();
	}

	public Contato buscaContato(int codigo) {
		Query consulta = this.session
				.createQuery("from Contato where codigo = :codigo");
		consulta.setInteger("codigo", codigo);

		return (Contato) consulta.uniqueResult();
	}

	public static void main(String[] args) {

		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction transaction = session.beginTransaction();

		ContatoCrudAnnotations crudAnnotations = new ContatoCrudAnnotations(session);

		Contato ian = criaContato("Ian Alves", "ian@gmail.com", "99346554", "Novo Cliente");
		crudAnnotations.salvar(ian);
//		
//		ian.setObservacao("Retomar Contato");
//		crudAnnotations.atualizar(ian);
		
		Contato italo = criaContato("Italo Alves", "italo@gmail.com", "99446554", "Novo Cliente");
		crudAnnotations.salvar(italo);
//		
		Contato felipe = criaContato("Felipe Alves", "felipe@gmail.com", "99344554", "Novo Cliente");
		crudAnnotations.salvar(felipe);
		
		System.out.println("Total de registros cadastrados: " + crudAnnotations.listar().size());		
		crudAnnotations.excluir(italo);
		System.out.println("Total de registros cadastrados: " + crudAnnotations.listar().size());

		transaction.commit();

	}

	private static Contato criaContato(String nome, String email, String telefone, String observacao) {
		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setTelefone(telefone);
		contato.setObservacao(observacao);
		contato.setDataCadastro(new Date(System.currentTimeMillis()));
		return contato;
	}

}
