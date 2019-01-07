package br.com.ciandt.bitcoin.api.services.integration.saldoapi;

import java.math.BigDecimal;

/**
 * Objeto DTO para transferência dos dados da API Saldo Carteira.
 * Simulação de classe que viria no client disponibilizado.
 * @author igorha
 *
 */
public class ApiSaldoCarteiraDTO {
	
	private String carteira;
	private BigDecimal saldo;
	
	public ApiSaldoCarteiraDTO(String carteira, BigDecimal saldo) {
		this.carteira = carteira;
		this.saldo = saldo;
	}
	
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public BigDecimal getSaldo() {
		return saldo;
	}
	public void setSaldo(BigDecimal saldo) {
		this.saldo = saldo;
	}
	@Override
	public String toString() {
		return "ApiSaldoCarteiraDTO [carteira=" + carteira + ", saldo=" + saldo + "]";
	}
	

}
