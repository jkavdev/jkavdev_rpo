package br.com.cocodonto.modelo.dao.teste;

import java.util.Date;

import br.com.cocodonto.framework.dao.CreateDAOException;
import br.com.cocodonto.modelo.dao.PacienteDAO;
import br.com.cocodonto.modelo.entidade.Endereco;
import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDAOTest {
	
	public static void main(String[] args) throws CreateDAOException {
		
		Paciente paciente = new Paciente("Maria", "3168227", "0448828554", SexoType.F);
		paciente.setCricacao(new Date());
		Endereco endereco = new Endereco("qr 12 casa 15", "planaltina", "itapua 1", "73754012");
		
		paciente.setEndereco(endereco);
		
		PacienteDAO dao = new PacienteDAO();		
		dao.inserir(paciente);
		
		System.out.println(paciente.toString());
		
		System.out.println("Inserido");
		
	}

}
