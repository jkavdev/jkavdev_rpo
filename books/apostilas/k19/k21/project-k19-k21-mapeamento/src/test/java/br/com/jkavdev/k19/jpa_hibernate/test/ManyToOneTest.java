package br.com.jkavdev.k19.jpa_hibernate.test;

import java.util.Calendar;

import org.junit.Test;

import br.com.jkavdev.k19.jpa_hibernate.model.Cliente;
import br.com.jkavdev.k19.jpa_hibernate.model.Pedido;

public class ManyToOneTest extends AbstractJUnitConfig {

	@Test
	public void insertCliente() {

		Cliente cliente = new Cliente();
		cliente.setNome("Jhonatan");

		Pedido pedido = new Pedido();
		pedido.setCliente(cliente);
		pedido.setData(Calendar.getInstance());

		Pedido pedido2 = new Pedido();
		pedido2.setCliente(cliente);
		pedido2.setData(Calendar.getInstance());

		beginTransaction();

		this.getManager().persist(cliente);
		this.getManager().persist(pedido);
		this.getManager().persist(pedido2);

		commit();

	}

}
