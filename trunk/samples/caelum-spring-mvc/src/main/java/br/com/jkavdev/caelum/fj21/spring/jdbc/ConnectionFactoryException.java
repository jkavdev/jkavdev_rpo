package br.com.jkavdev.caelum.fj21.spring.jdbc;

public class ConnectionFactoryException extends Exception {

	private static final long serialVersionUID = 1L;

	public ConnectionFactoryException() {
		super();
	}

	public ConnectionFactoryException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public ConnectionFactoryException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public ConnectionFactoryException(String arg0) {
		super(arg0);
	}

	public ConnectionFactoryException(Throwable arg0) {
		super(arg0);
	}
	
	

}
