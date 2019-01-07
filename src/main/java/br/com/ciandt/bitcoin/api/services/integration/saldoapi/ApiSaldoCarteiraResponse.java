package br.com.ciandt.bitcoin.api.services.integration.saldoapi;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Response do serviço Saldo Carteira.
 * Simulação de classe que viria no client disponibilizado.
 * @author igorha
 *
 * @param <T>
 */
public class ApiSaldoCarteiraResponse<T> implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7459375120751194468L;

	private T data;
	private List<String> errors;

	public ApiSaldoCarteiraResponse() {
		
	}
	
	public ApiSaldoCarteiraResponse(T data, List<String> errors) {
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

	@Override
	public String toString() {
		return "ApiSaldoCarteiraResponse [data=" + data + ", errors=" + errors + "]";
	}
	
}
