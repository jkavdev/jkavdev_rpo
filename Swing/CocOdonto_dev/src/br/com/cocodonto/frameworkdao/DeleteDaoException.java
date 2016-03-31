package br.com.cocodonto.frameworkdao;

public class DeleteDaoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DeleteDaoException() {
		super();
	}

	public DeleteDaoException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public DeleteDaoException(String message, Throwable cause) {
		super(message, cause);
	}

	public DeleteDaoException(String message) {
		super(message);
	}

	public DeleteDaoException(Throwable cause) {
		super(cause);
	}

}
