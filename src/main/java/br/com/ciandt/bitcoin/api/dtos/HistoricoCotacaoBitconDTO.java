package br.com.ciandt.bitcoin.api.dtos;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalTime;

/**
 * Classe representando o objeto de resposta para o endpoint Historico de Cotacao do Bitcon no Dia seguindo o pattern DTO (Data Transfer Object)
 * @author igorha
 *
 */
public class HistoricoCotacaoBitconDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2961476973063813543L;
	
	private BigDecimal valorCotacao;
	private LocalTime horaObtidaCotacao;
	
	public HistoricoCotacaoBitconDTO() {
		
	}

	public HistoricoCotacaoBitconDTO(BigDecimal valorCotacao, LocalTime horaObtidaCotacao) {
		super();
		this.valorCotacao = valorCotacao;
		this.horaObtidaCotacao = horaObtidaCotacao;
	}


	public BigDecimal getValorCotacao() {
		return valorCotacao;
	}
	public void setValorCotacao(BigDecimal valorCotacao) {
		this.valorCotacao = valorCotacao;
	}
	public LocalTime getHoraObtidaCotacao() {
		return horaObtidaCotacao;
	}
	public void setHoraObtidaCotacao(LocalTime horaObtidaCotacao) {
		this.horaObtidaCotacao = horaObtidaCotacao;
	}

	@Override
	public String toString() {
		return "HistoricoCotacaoBitconDTO [valorCotacao=" + valorCotacao + ", horaObtidaCotacao=" + horaObtidaCotacao
				+ "]";
	}
	

}
