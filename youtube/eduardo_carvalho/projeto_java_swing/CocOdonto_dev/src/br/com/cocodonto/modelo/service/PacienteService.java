package br.com.cocodonto.modelo.service;

import java.util.List;

import br.com.cocodonto.modelo.dao.PacienteDao;
import br.com.cocodonto.modelo.entidade.Paciente;

public class PacienteService {

	private PacienteDao pacienteDao;

	public PacienteService() {
		pacienteDao = new PacienteDao();
	}

	public void salvar(Paciente paciente) {
		if (paciente.getId() != 0) {
			pacienteDao.atualizar(paciente);
		} else {
			pacienteDao.inserir(paciente);
		}
	}

	public List<Paciente> getPacientes() {
		return pacienteDao.listaTodosPacientes();
	}

}
