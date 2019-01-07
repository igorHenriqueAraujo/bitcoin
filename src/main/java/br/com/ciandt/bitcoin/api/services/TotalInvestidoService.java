package br.com.ciandt.bitcoin.api.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.dtos.enums.TipoTransacaoBitcoin;
import br.com.ciandt.bitcoin.api.dtos.integration.HistoricoTransacaoRecenteDTO;
import br.com.ciandt.bitcoin.api.responses.integration.HistoricoTransacoesRecenteResponse;
import br.com.ciandt.bitcoin.api.services.integration.HistoricoTransacoesRecentesServiceClient;

/**
 * Classe responsável por recuperar as informações e calcular o total investido (compra) desde o momento da criação da carteira.
 * @author igorha
 *
 */
@Service
public class TotalInvestidoService {
	
	private static final Logger log = LoggerFactory.getLogger(TotalInvestidoService.class);
	
	@Autowired
	private HistoricoTransacoesRecentesServiceClient historicoTransacoesRecentesServiceClient;
	
	/**
	 * Recupera o valor do total investido (compra).
	 * @param carteira
	 * @return
	 */
	public BigDecimal getTotalInvestido(String carteira) {
		
		//recupera historico recente
		List<HistoricoTransacaoRecenteDTO> historico = recuperaHistoricoTransacoesRecentes(carteira);
		//filtra para obter apenas transações de compra
		List<HistoricoTransacaoRecenteDTO> apenasCompra = historico.stream().filter(hist -> TipoTransacaoBitcoin.COMPRA.equals(hist.getTipoTransacao())).collect(Collectors.toList());
		//soma os valores contidos na lista
		BigDecimal totalInvestido = apenasCompra.stream().map((compra) -> compra.getValorReal()).reduce((compra, outra) -> compra.add(outra)).get();
		
		return totalInvestido;
	}
	
	/**
	 * Recupera histórico de transações recentes.
	 * @param carteira
	 * @return
	 */
	private List<HistoricoTransacaoRecenteDTO> recuperaHistoricoTransacoesRecentes(String carteira) {
		HistoricoTransacoesRecenteResponse response = historicoTransacoesRecentesServiceClient.getHistoricoTransacoesRecentes(carteira);
		log.info(response.toString());
		return response.getHistorico();
	}

}
