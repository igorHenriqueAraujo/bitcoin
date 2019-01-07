package br.com.ciandt.bitcoin.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Classe representando o objeto de resposta para o endpoint Valor Investido seguindo o pattern DTO (Data Transfer Object)
 * @author igorha
 *
 */
public class ValorInvestidoDTO implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3262904036559427479L;
	
	private BigDecimal valorInvestido;
	private String carteira;
	
	public ValorInvestidoDTO() {
		
	}
	
	public ValorInvestidoDTO(BigDecimal valorInvestido, String carteira) {
		this.valorInvestido = valorInvestido;
		this.carteira = carteira;
	}

	public BigDecimal getValorInvestido() {
		return valorInvestido;
	}

	public void setValorInvestido(BigDecimal lucroObtido) {
		this.valorInvestido = lucroObtido;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	@Override
	public String toString() {
		return "ValorInvestidoDTO [valorInvestido=" + valorInvestido + ", carteira=" + carteira +  "]";
	}
	
	

}
