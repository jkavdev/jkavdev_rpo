package br.com.cocodonto.frameworkdao;

public class ConnectionFailureException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ConnectionFailureException() {
		super();
	}

	public ConnectionFailureException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ConnectionFailureException(String message, Throwable cause) {
		super(message, cause);
	}

	public ConnectionFailureException(String message) {
		super(message);
	}

	public ConnectionFailureException(Throwable cause) {
		super(cause);
	}

}
