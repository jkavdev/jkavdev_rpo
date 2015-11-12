package br.com.cocodonto.modelo.dao;

import br.com.cocodonto.modelo.entidade.Paciente;
import br.com.cocodonto.modelo.entidade.SexoType;

public class PacienteDAOTest {
	
	public static void main(String[] args) {
		
		Paciente p = new Paciente("Jhonatan Kolen", "1328433", "04488289100", SexoType.M);
		PacienteDAO dao = new PacienteDAO();
		
		dao.inserir(p);
		
	}

}
