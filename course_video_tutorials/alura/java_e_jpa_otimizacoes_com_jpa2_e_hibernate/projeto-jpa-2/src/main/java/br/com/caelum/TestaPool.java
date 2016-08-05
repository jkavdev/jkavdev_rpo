package br.com.caelum;

import java.beans.PropertyVetoException;
import java.sql.SQLException;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class TestaPool {

	public static void main(String[] args) throws PropertyVetoException, SQLException {

		ComboPooledDataSource dataSource = (ComboPooledDataSource) new JpaConfigurator().getDataSource();

		// Isso acontece porque o pool armazena inicialmente três conexões
		// ociosas (sem uso). Na primera obtenção uma delas passa se torna
		// ocupada e,
		// por consequência, o número de ociosas diminui. O mesmo evento ocorre
		// na segunda e terceira iteração.
		for (int i = 0; i < 10; i++) {
			dataSource.getConnection();

			System.out.println(i + " - Conexões existentes: " + dataSource.getNumConnections());
			System.out.println(i + " - Conexões ocupadas: " + dataSource.getNumBusyConnections());
			System.out.println(i + " - Conexões ociosas: " + dataSource.getNumIdleConnections());

			System.out.println("");

		}
	}

}
