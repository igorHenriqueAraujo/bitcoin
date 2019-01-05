package br.com.ciandt.bitcoin.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.ciandt.bitcoin.api.dtos.enums.TipoTransacaoBitcon;

/**
 * Classe representando o objeto de resposta para o endpoint Historico de Transações realizadas de uma carteira seguindo o pattern DTO (Data Transfer Object)
 * @author igorha
 *
 */
public class HistoricoTransacoesDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2961476973063813543L;
	
	private BigDecimal valorReal;
	private BigDecimal valorBitcoin;
	private BigDecimal cotacaoTransacao;
	private LocalDateTime dataHoraTransacao;
	private TipoTransacaoBitcon tipoTransacao;
	private String carteira;
	
	public HistoricoTransacoesDTO() {
		
	}

	public HistoricoTransacoesDTO(BigDecimal valorReal, BigDecimal valorBitcoin, BigDecimal cotacaoTransacao,
			LocalDateTime dataHoraTransacao, TipoTransacaoBitcon tipoTransacao, String carteira) {
		super();
		this.valorReal = valorReal;
		this.valorBitcoin = valorBitcoin;
		this.cotacaoTransacao = cotacaoTransacao;
		this.dataHoraTransacao = dataHoraTransacao;
		this.tipoTransacao = tipoTransacao;
		this.carteira = carteira;
	}

	public BigDecimal getValorReal() {
		return valorReal;
	}

	public void setValorReal(BigDecimal valorReal) {
		this.valorReal = valorReal;
	}

	public BigDecimal getValorBitcoin() {
		return valorBitcoin;
	}

	public void setValorBitcoin(BigDecimal valorBitcoin) {
		this.valorBitcoin = valorBitcoin;
	}

	public BigDecimal getCotacaoTransacao() {
		return cotacaoTransacao;
	}

	public void setCotacaoTransacao(BigDecimal cotacaoTransacao) {
		this.cotacaoTransacao = cotacaoTransacao;
	}

	public LocalDateTime getDataHoraTransacao() {
		return dataHoraTransacao;
	}

	public void setDataHoraTransacao(LocalDateTime dataHoraTransacao) {
		this.dataHoraTransacao = dataHoraTransacao;
	}

	public TipoTransacaoBitcon getTipoTransacao() {
		return tipoTransacao;
	}

	public void setTipoTransacao(TipoTransacaoBitcon tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}

	public String getCarteira() {
		return carteira;
	}

	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}

	@Override
	public String toString() {
		return "HistoricoTransacoesDTO [valorReal=" + valorReal + ", valorBitcoin=" + valorBitcoin
				+ ", cotacaoTransacao=" + cotacaoTransacao + ", dataHoraTransacao=" + dataHoraTransacao
				+ ", tipoTransacao=" + tipoTransacao + ", carteira=" + carteira + "]";
	}
	
	

}
