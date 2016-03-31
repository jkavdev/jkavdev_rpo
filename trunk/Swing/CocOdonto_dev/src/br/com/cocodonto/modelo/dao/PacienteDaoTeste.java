package br.com.cocodonto.modelo.dao;

import java.util.List;

import br.com.cocodonto.framework.dao.CreateDaoException;
import br.com.cocodonto.modelo.entidade.Contato;
import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDaoTeste {

	public static void main(String[] args) throws CreateDaoException {

//		Paciente paciente = new Paciente("Douglas", "3148567", "2118289100", SexoType.M);		
//		Endereco endereco = new Endereco("Qr12 casa 15", "Planaltina de Goiais", "Itapua", "73754012");
//		Contato contato = new Contato("jhonatan@gmail.com", "99346554", "36376687", "jhonatan@gmaicl.com");
//		
//		paciente.setEndereco(endereco);
//		paciente.setContato(contato);
		
		PacienteDao dao = new PacienteDao();
		
//		dao.inserir(paciente);
//		
//		System.out.println("Inseriu");
		
		List<Paciente> pacientes = dao.listaTodosPacientes();
		for (Paciente paciente2 : pacientes) {
			System.out.println(paciente2);
		}

	}

}
