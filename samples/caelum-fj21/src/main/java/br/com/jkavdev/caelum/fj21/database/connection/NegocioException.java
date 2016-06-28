package br.com.jkavdev.caelum.fj21.database.connection;

public class NegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public NegocioException() {
	}

	public NegocioException(String arg0) {
		super(arg0);
	}

	public NegocioException(Throwable arg0) {
		super(arg0);
	}

	public NegocioException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public NegocioException(String arg0, Throwable arg1, boolean arg2,
			boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

}
