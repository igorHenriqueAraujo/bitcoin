package br.com.ciandt.bitcoin.api.responses;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe que encapsula a resposta da API aos chamadores.
 * @author igorha
 *
 * @param <T>
 */
public class ApiResponse<T> implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 148964349596194776L;
	private T data;
	private List<String> errors;

	public ApiResponse() {
		
	}
	
	public ApiResponse(T data, List<String> errors) {
		this.data = data;
		this.errors = errors;
	}

	public T getData() {
		return data;
	}

	public List<String> getErrors() {
		if (this.errors == null) {
			this.errors = new ArrayList<String>();
		}
		return errors;
	}

	public void setData(T data) {
		this.data = data;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

}
