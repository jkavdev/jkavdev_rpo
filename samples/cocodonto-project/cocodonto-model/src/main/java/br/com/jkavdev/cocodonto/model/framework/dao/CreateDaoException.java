package br.com.jkavdev.cocodonto.model.framework.dao;

public class CreateDaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CreateDaoException() {
		super();
	}

	public CreateDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public CreateDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public CreateDaoException(String message) {
		super(message);
	}

	public CreateDaoException(Throwable cause) {
		super(cause);
	}

}
