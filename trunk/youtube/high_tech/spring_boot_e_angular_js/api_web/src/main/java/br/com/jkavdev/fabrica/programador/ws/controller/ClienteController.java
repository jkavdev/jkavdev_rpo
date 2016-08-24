package br.com.jkavdev.fabrica.programador.ws.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.fabrica.programador.ws.model.Cliente;
import br.com.jkavdev.fabrica.programador.ws.service.ClienteService;

@RestController
public class ClienteController {

	@Autowired
	ClienteService clienteService;
	
	// consumes - indicamos que este metodo possa tambem ler um json
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// requestBody - indicamos que o json que contem os dados sera
	// prenchido dentro de cliente

	// retornara um ResponseEntity para json na pagina
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrado = clienteService.cadastrar(cliente);

		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);

	}

	// produces - entregaremos um json
	@RequestMapping(method = RequestMethod.GET, value = "/clientes", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Cliente>> buscarTodosClientes() {

		Collection<Cliente> clientesBuscados = clienteService.buscarTodos();

		return new ResponseEntity<>(clientesBuscados, HttpStatus.OK);

	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/clientes/{id}")
	// pathVariable indica que o valor da requisicao passado sera
	// inserido na variavel id do metodo
	public ResponseEntity<Cliente> excluirCliente(@PathVariable Integer id) {

		Cliente clienteEncontrado = clienteService.buscarPorId(id);

		if (clienteEncontrado == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		clienteService.excluir(clienteEncontrado);
		return new ResponseEntity<>(HttpStatus.OK);

	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	// requestBody - indicamos que o json que contem os dados sera
	// prenchido dentro de cliente

	// retornara um ResponseEntity para json na pagina
	public ResponseEntity<Cliente> alterarCliente(@RequestBody Cliente cliente) {

		Cliente clienteAlterado = clienteService.alterar(cliente);

		return new ResponseEntity<>(clienteAlterado, HttpStatus.OK);

	}

}
