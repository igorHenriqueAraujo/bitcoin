package br.com.ciandt.bitcoin.api.services;

import java.math.BigDecimal;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.dtos.integration.HistoricoTransacaoRecenteDTO;
import br.com.ciandt.bitcoin.api.responses.integration.HistoricoTransacoesRecenteResponse;
import br.com.ciandt.bitcoin.api.services.integration.HistoricoTransacoesRecentesServiceClient;
import br.com.ciandt.bitcoin.api.services.integration.SaldoCarteiraBitcoinServiceClient;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraDTO;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraResponse;

/**
 * Classe de serviço responsável por recuperar as informações e calcular o lucro obtido da criação da carteira até o momento da solicitação.
 * @author igorha
 *
 */
@Service
public class LucroObtidoService {
	
	private static final Logger log = LoggerFactory.getLogger(LucroObtidoService.class);
	
	@Autowired
	private SaldoCarteiraBitcoinServiceClient saldoCarteiraBitcoinServiceClient;
	
	@Autowired
	private HistoricoTransacoesRecentesServiceClient historicoTransacoesRecentesServiceClient;
	
	/**
	 * Recupera o lucro obtido da carteira.
	 * @param carteira
	 * @return
	 */
	public BigDecimal getLucroObtido(String carteira) {
		
		BigDecimal saldo = recuperaSaldoAtual(carteira);
		List<HistoricoTransacaoRecenteDTO> historico = recuperaHistoricoTransacoesRecentes(carteira);
		
		return null;
	}
	
	private BigDecimal recuperaSaldoAtual(String carteira) {
		ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO> response = saldoCarteiraBitcoinServiceClient.getSaldoCarteira(carteira);
		log.info(response.getData().toString());
		return response.getData().getSaldo();
	}
	
	private List<HistoricoTransacaoRecenteDTO> recuperaHistoricoTransacoesRecentes(String carteira) {
		HistoricoTransacoesRecenteResponse response = historicoTransacoesRecentesServiceClient.getHistoricoTransacoesRecentes(carteira);
		log.info(response.toString());
		return response.getHistorico();
	}
	

}
