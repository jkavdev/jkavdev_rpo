package br.com.cocodonto.framework.dao;

public class UpdateDaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UpdateDaoException() {
		super();
	}

	public UpdateDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UpdateDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public UpdateDaoException(String message) {
		super(message);
	}

	public UpdateDaoException(Throwable cause) {
		super(cause);
	}

}
