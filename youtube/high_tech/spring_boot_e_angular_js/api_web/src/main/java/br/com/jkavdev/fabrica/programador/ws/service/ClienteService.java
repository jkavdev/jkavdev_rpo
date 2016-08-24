package br.com.jkavdev.fabrica.programador.ws.service;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import br.com.jkavdev.fabrica.programador.ws.model.Cliente;

@Service
public class ClienteService {
	
	private Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
	private Integer proximoId = 0;

	public Cliente cadastrar(Cliente cliente) {

		cliente.setId(++proximoId);

		clientes.put(cliente.getId(), cliente);

		return cliente;
	}

	public Collection<Cliente> buscarTodos() {
		return clientes.values();
	}

	public void excluir(Cliente cliente) {
		clientes.remove(cliente.getId());
	}

	public Cliente buscarPorId(Integer id) {
		return clientes.get(id);
	}

	public Cliente alterar(Cliente cliente){
		clientes.put(cliente.getId(), cliente);
		
		return cliente;
	}

}
