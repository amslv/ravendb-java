package br.edu.ifpb.mt.bd2.ravendb.exception;

public class RavenDBException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8251399213343314558L;

	public RavenDBException() {
		super();
	}

	public RavenDBException(String message, Throwable cause) {
		super(message, cause);
	}

	public RavenDBException(String message) {
		super(message);
	}
}
