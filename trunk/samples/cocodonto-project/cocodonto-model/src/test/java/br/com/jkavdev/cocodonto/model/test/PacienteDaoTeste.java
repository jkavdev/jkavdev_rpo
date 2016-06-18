package br.com.jkavdev.cocodonto.model.test;

import java.util.Date;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import br.com.jkavdev.cocodonto.model.dao.ContatoDao;
import br.com.jkavdev.cocodonto.model.dao.EnderecoDao;
import br.com.jkavdev.cocodonto.model.dao.PacienteDao;
import br.com.jkavdev.cocodonto.model.entidade.Contato;
import br.com.jkavdev.cocodonto.model.entidade.Endereco;
import br.com.jkavdev.cocodonto.model.entidade.Paciente;
import br.com.jkavdev.cocodonto.model.entidade.SexoType;

public class PacienteDaoTeste {

	private final Logger logger = Logger.getLogger(this.getClass());
	PacienteDao pacienteDao;
	EnderecoDao enderecoDao;
	ContatoDao contatoDao;

	@Before
	public void setUp() {
		pacienteDao = new PacienteDao();
		enderecoDao = new EnderecoDao();
		contatoDao = new ContatoDao();
	}

	@Test
	public void insertPaciente() {
		Paciente douglas = criaPaciente("Douglas", "3133547", "32158289100", SexoType.M);
		Paciente lucas = criaPaciente("Lucas", "3122357", "0415689100", SexoType.M);
		Paciente maria = criaPaciente("Maria", "3162247", "04488214100", SexoType.F);
		Paciente ismael = criaPaciente("Ismael", "3155437", "12488289100", SexoType.M);

		pacienteDao.inserir(ismael);
		pacienteDao.inserir(maria);
		pacienteDao.inserir(douglas);
		pacienteDao.inserir(lucas);

		logger.info("pacientes inseridos....");

	}

	@Test
	public void insertPacienteWithEndereco() {
		Paciente jhonatan = criaPaciente("Jhonatan", "3168437", "88788289100", SexoType.M);
		Endereco itapua = criaEndereco("Itapua I", "73754012", "Planaltina", "Qr 12 Casa 15");
		Contato contato = criaContato("99220468", "jhonatan@gmail.com", "36374568");

		jhonatan.setEndereco(itapua);
		jhonatan.setContato(contato);

		pacienteDao.inserir(jhonatan);
		
		logger.info("paciente inserido");
	}

	public void insertEndereco() {

	}

	public Paciente criaPaciente(String nome, String rg, String cpf, SexoType sexo) {
		Paciente paciente = new Paciente();
		paciente.setDataCriacao(new Date());
		paciente.setCpf(cpf);
		paciente.setNome(nome);
		paciente.setRg(rg);
		paciente.setSexo(sexo);

		return paciente;
	}

	public Endereco criaEndereco(String bairro, String cep, String cidade, String endereco) {
		Endereco endereco1 = new Endereco();
		endereco1.setBairro(bairro);
		endereco1.setCep(cep);
		endereco1.setCidade(cidade);
		endereco1.setDataCriacao(new Date());
		endereco1.setEndereco(endereco);

		return endereco1;
	}

	public Contato criaContato(String celular, String email, String telefone) {
		Contato contato = new Contato();
		contato.setCelular(celular);
		contato.setDataCriacao(new Date());
		contato.setEmail(email);
		contato.setTelefone(telefone);

		return contato;
	}
}
