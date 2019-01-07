package br.com.ciandt.bitcoin.api.dtos.integration;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import br.com.ciandt.bitcoin.api.dtos.enums.TipoTransacaoBitcoin;

/**
 * DTO Representado a lista de objetos retornados pela API de Integração.
 * @author igorha
 *
 */
public class HistoricoTransacaoRecenteDTO {
	
	private BigDecimal valorReal;
	private BigDecimal valorBitcoin;
	private BigDecimal cotacaoTransacao;
	private LocalDateTime dataHoraTransacao;
	private TipoTransacaoBitcoin tipoTransacao;
	
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
	public TipoTransacaoBitcoin getTipoTransacao() {
		return tipoTransacao;
	}
	public void setTipoTransacao(TipoTransacaoBitcoin tipoTransacao) {
		this.tipoTransacao = tipoTransacao;
	}
	
	@Override
	public String toString() {
		return "HistoricoTransacaoRecenteDTO [valorReal=" + valorReal + ", valorBitcoin=" + valorBitcoin
				+ ", cotacaoTransacao=" + cotacaoTransacao + ", dataHoraTransacao=" + dataHoraTransacao
				+ ", tipoTransacao=" + tipoTransacao + "]";
	}

}
