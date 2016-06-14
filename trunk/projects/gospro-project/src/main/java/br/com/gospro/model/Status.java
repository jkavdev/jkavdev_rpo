package br.com.gospro.model;

import javax.persistence.Entity;

@Entity
public enum Status {

	NOVO("Novo Servico"),

	// Você ainda não confirmou a sua encomenda, e os detalhes de pagamento não
	// foram introduzidos.

	EMPROCESSO("Serviço em Atendimento"),

	// Os seus detalhes de pagamento foram aceitos pela prestadora dos serviços
	// de pagamento e serão apagados em breve. Os detalhes dos pagamentos pelo
	// PayPal podem demorar mais tempo para serem apagados.

	CONCLUIDO("Serviço concluído"),

	// Seu pedido foi pago. Pode verificar os horários de entrega.
	// [ mostrar como... ]

	CANCELADO("Serviço Cancelado");

	// Seu pedido foi cancelado.

	private Status(String descricao) {
		this.descricao = descricao;
	}

	private String descricao;

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

}
