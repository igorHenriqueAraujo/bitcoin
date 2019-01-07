package br.com.ciandt.bitcoin.api.responses.integration;

import java.util.List;

import br.com.ciandt.bitcoin.api.dtos.integration.HistoricoTransacaoIntegrationDTO;

/**
 * Classe Response que representa o conteúdo retornado pela API de integração.
 * @author igorha
 *
 */
public class HistoricoTransacoesIntegrationResponse {
	
	private String carteira;
	private List<HistoricoTransacaoIntegrationDTO> historico;
	public String getCarteira() {
		return carteira;
	}
	public void setCarteira(String carteira) {
		this.carteira = carteira;
	}
	public List<HistoricoTransacaoIntegrationDTO> getHistorico() {
		return historico;
	}
	public void setHistorico(List<HistoricoTransacaoIntegrationDTO> historico) {
		this.historico = historico;
	}
	
	@Override
	public String toString() {
		return "HistoricoTransacoesRecenteResponse [carteira=" + carteira + ", historico=" + historico + "]";
	}

}
