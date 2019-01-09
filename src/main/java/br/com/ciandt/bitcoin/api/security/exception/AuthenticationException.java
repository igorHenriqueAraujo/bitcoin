package br.com.ciandt.bitcoin.api.security.exception;

public class AuthenticationException extends RuntimeException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -480857523881398549L;

	public AuthenticationException(String message, Throwable cause) {
        super(message, cause);
    }
}
