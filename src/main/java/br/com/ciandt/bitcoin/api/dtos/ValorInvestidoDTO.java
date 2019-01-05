package br.com.ciandt.bitcoin.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;

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
	private LocalDate dataCadastroCarteira;
	
	public ValorInvestidoDTO() {
		
	}
	
	public ValorInvestidoDTO(BigDecimal valorInvestido, String carteira, LocalDate dataCadastroCarteira) {
		this.valorInvestido = valorInvestido;
		this.carteira = carteira;
		this.dataCadastroCarteira = dataCadastroCarteira;
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
	
	public LocalDate getDataCadastroCarteira() {
		return dataCadastroCarteira;
	}

	public void setDataCadastroCarteira(LocalDate dataCadastroCarteira) {
		this.dataCadastroCarteira = dataCadastroCarteira;
	}
	

}
