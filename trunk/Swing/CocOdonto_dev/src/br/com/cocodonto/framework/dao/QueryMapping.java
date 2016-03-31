package br.com.cocodonto.framework.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface QueryMapping<T> {
	
	void mapping(ResultSet resultSet) throws SQLException;

}
