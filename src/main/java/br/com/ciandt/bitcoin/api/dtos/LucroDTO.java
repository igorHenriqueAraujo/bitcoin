package br.com.ciandt.bitcoin.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe representando o objeto de resposta para o endpoint Lucro Obtido seguindo o pattern DTO (Data Transfer Object)
 * @author igorha
 *
 */
public class LucroDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3262904036559427479L;
	
	private BigDecimal lucroObtido;
	private String carteira;
	
	public LucroDTO() {
		
	}
	
	public LucroDTO(BigDecimal lucroObtido, String carteira) {
		this.lucroObtido = lucroObtido;
		this.carteira = carteira;
	}

	public BigDecimal getLucroObtido() {
		return lucroObtido;
	}

	public void setLucroObtido(BigDecimal lucroObtido) {
		this.lucroObtido = lucroObtido;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	@Override
	public String toString() {
		return "LucroDTO [lucroObtido=" + lucroObtido + ", carteira=" + carteira + "]";
	}
	

}
