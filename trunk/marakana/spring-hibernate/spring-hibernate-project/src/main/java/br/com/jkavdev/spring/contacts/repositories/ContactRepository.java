package br.com.jkavdev.spring.contacts.repositories;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import br.com.jkavdev.spring.contacts.entities.Contact;

public class ContactRepository {

	private final DataSource dataSource;

	public ContactRepository() {
		try {
			Context context = new InitialContext();
			try {
				dataSource = (DataSource) context.lookup("java:comp/env/jdbc/spring-hibernateDS");
			} finally {
				context.close();
			}
		} catch (NamingException e) {
			throw new RuntimeException(e);
		}
	}

	public void init() throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				String sql = "create table contact " + 
								"(	id integer generated by default as identity primary key, " + 
								"	name varchar(255), " + 
								"	address_id integer, " + 
								"	foreign key (address_id) references address)";
				statement.execute(sql);
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public List<Contact> findAll() throws SQLException{
		Connection connection = dataSource.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				ResultSet resultSet = statement.executeQuery("select * from contact");
				try {
					List<Contact> contacts = new ArrayList<>();
					
					while (resultSet.next()) {
						contacts.add(unmarshal(resultSet));
					}
					
					return contacts;
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}
	
	public Contact find(long id) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				ResultSet resultSet = statement.executeQuery("select * from contact where id = " + id);
				try {
					if (!resultSet.next()) {
						return null;
					} else {
						return unmarshal(resultSet);
					}
				} finally {
					resultSet.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public void create(Contact contact) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				String sql = "insert into contact (name, address_id) values ('" + 
								contact.getName() + "', '" + 
								contact.getAddressId() + "')";
				statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
				ResultSet generatedKeys = statement.getGeneratedKeys();
				try {
					if (generatedKeys.next())
						contact.setId(generatedKeys.getLong("id"));
				} finally {
					generatedKeys.close();
				}
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public void update(Contact contact) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				String sql = "update contact set "
						+ "name='" + contact.getName() 
						+ "', address_id='" + contact.getAddressId()
						+ "' where id=" + contact.getId();
				statement.executeUpdate(sql);
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	public void delete(Contact contact) throws SQLException {
		Connection connection = dataSource.getConnection();
		try {
			Statement statement = connection.createStatement();
			try {
				statement.executeUpdate("delete from contact where id=" + contact.getId());
			} finally {
				statement.close();
			}
		} finally {
			connection.close();
		}
	}

	// criação do objeto devolvido, de acordo com cada linha que encontrar no
	// resulset
	private static Contact unmarshal(ResultSet resultSet) throws SQLException {

		Contact contact = new Contact();
		contact.setId(resultSet.getLong("id"));
		contact.setName(resultSet.getString("name"));
		contact.setAddressId(resultSet.getLong("address_id"));

		return contact;
	}

}
