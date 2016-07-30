package br.com.jkavdev.algaworks.jsf.services;

public class RegraNegocioException extends Exception {

	private static final long serialVersionUID = 1L;

	public RegraNegocioException() {
		super();
	}

	public RegraNegocioException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
	}

	public RegraNegocioException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

	public RegraNegocioException(String arg0) {
		super(arg0);
	}

	public RegraNegocioException(Throwable arg0) {
		super(arg0);
	}

}
