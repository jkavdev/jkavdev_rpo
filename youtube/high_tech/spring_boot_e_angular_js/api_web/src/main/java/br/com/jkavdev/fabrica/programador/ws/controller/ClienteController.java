package br.com.jkavdev.fabrica.programador.ws.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.jkavdev.fabrica.programador.ws.model.Cliente;

@RestController
public class ClienteController {

	Map<Integer, Cliente> clientes;
	Integer proximoId = 0;

	private Cliente cadastrar(Cliente cliente) {

		if (clientes == null) {
			clientes = new HashMap<Integer, Cliente>();
		}

		cliente.setId(++proximoId);

		clientes.put(cliente.getId(), cliente);

		return cliente;
	}

	// consumes - indicamos que este metodo possa tambem ler um json
	@RequestMapping(method = RequestMethod.POST, value = "/clientes", consumes = MediaType.APPLICATION_JSON_VALUE)
	// requestBody - indicamos que o json que contem os dados sera
	// prenchido dentro de cliente

	// retornara um ResponseEntity para json na pagina
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {

		Cliente clienteCadastrado = cadastrar(cliente);

		return new ResponseEntity<>(clienteCadastrado, HttpStatus.CREATED);

	}

}
