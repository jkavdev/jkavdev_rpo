package br.com.javaparaweb.capitulo3.crudannotations;

import java.sql.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import br.com.javaparaweb.capitulo3.conexao.HibernateUtil;

public class ContatoCrudAnnotation {

	private Session sessao;

	public ContatoCrudAnnotation(Session sessao) {
		this.sessao = sessao;
	}

	public void salvar(Contato contato) {
		sessao.save(contato);
	}

	public void atualiza(Contato contato) {
		sessao.update(contato);
	}

	public void excluir(Contato contato) {
		sessao.delete(contato);
	}

	@SuppressWarnings("unchecked")
	public List<Contato> listar() {
		return sessao.createQuery("from Contato").list();
	}

	public Contato buscaContato(int codigo) {
		return (Contato) sessao
				.createQuery("from Contato where codigo = :codigo")
				.setInteger("codigo", codigo).uniqueResult();
	}

	public static void main(String[] args) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction transacao = sessao.beginTransaction();
		ContatoCrudAnnotation contatoCrudAnnotation = new ContatoCrudAnnotation(
				sessao);

		Contato jhonatan = new Contato();
		jhonatan.setNome("jhonatan");
		jhonatan.setEmail("jhonatan@gmail.com");
		jhonatan.setTelefone("99346554");
		jhonatan.setObservacao("Novo Cliente");
		jhonatan.setDataNascimento(new Date(System.currentTimeMillis()));

		contatoCrudAnnotation.salvar(jhonatan);

		Contato lucas = new Contato();
		lucas.setNome("lucas");
		lucas.setEmail("lucas@gmail.com");
		lucas.setTelefone("99220468");
		lucas.setObservacao("Novo Cliente");
		lucas.setDataNascimento(new Date(System.currentTimeMillis()));
		
		contatoCrudAnnotation.salvar(lucas);

		System.out.println("Total de registros cadastrados : "
				+ contatoCrudAnnotation.listar().size());

//		contatoCrudAnnotation.excluir(lucas);

		transacao.commit();

		System.out.println("Total de registros cadastrados : "
				+ contatoCrudAnnotation.listar().size());

	}

}
