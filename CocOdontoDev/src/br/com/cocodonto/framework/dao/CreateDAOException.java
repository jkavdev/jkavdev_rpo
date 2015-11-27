package br.com.cocodonto.framework.dao;

public class CreateDAOException extends RuntimeException{

	public CreateDAOException() {
		super();
	}

	public CreateDAOException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateDAOException(String message) {
		super(message);
	}

	public CreateDAOException(Throwable cause) {
		super(cause);
	}

}
