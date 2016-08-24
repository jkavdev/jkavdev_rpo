package br.com.jkavdev.fabrica.programador.ws.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.fabrica.programador.ws.model.Cliente;

@RestController
public class ClienteController {

	Map<Integer, Cliente> clientes = new HashMap<Integer, Cliente>();
	Integer proximoId = 0;

	private Cliente cadastrar(Cliente cliente) {

		cliente.setId(++proximoId);

		clientes.put(cliente.getId(), cliente);

		return cliente;
	}

	private Collection<Cliente> buscarTodos() {
		return clientes.values();
	}

	private void excluir(Cliente cliente) {
		clientes.remove(cliente);
	}

	private Cliente buscarPorId(Integer id) {
		return clientes.get(id);
	}

	// consumes - indicamos que este metodo possa tambem ler um json
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// requestBody - indicamos que o json que contem os dados sera
	// prenchido dentro de cliente

	// retornara um ResponseEntity para json na pagina
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrado = cadastrar(cliente);

		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);

	}

	// produces - entregaremos um json
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clientesBuscados = buscarTodos();

		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	// pathVariable indica que o valor da requisicao passado sera
	// inserido na variavel id do metodo
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clienteEncontrado = buscarPorId(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(HttpStatus.OK);

	}

}
