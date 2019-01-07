package br.com.ciandt.bitcoin.api.services;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.builder.GenericBuilder;
import br.com.ciandt.bitcoin.api.dtos.HistoricoTransacoesDTO;
import br.com.ciandt.bitcoin.api.dtos.integration.HistoricoTransacaoIntegrationDTO;
import br.com.ciandt.bitcoin.api.responses.integration.HistoricoTransacoesIntegrationResponse;
import br.com.ciandt.bitcoin.api.services.integration.HistoricoTransacoesRecentesServiceClient;

/**
 * Classe responsável por recuperar as informações e retornar as 5 ultimas transações realizadas.
 * @author igorha
 *
 */
@Service
public class TransacoesRecentesService {
	
	private static final Logger log = LoggerFactory.getLogger(TransacoesRecentesService.class);
	
	private static int NUM_TRANSACOES_RETORNO = 5;
	
	@Autowired
	private HistoricoTransacoesRecentesServiceClient historicoTransacoesRecentesServiceClient;
	
	/**
	 * Retorna uma lista com ultimas transações realizadas baseadas na qtdade definida na constante NUM_TRANSACOES_RETORNO.
	 * @param carteira
	 * @return
	 */
	public List<HistoricoTransacoesDTO> listUltimasTransacoes(String carteira) {
		
		List<HistoricoTransacoesDTO> retorno = new ArrayList<HistoricoTransacoesDTO>();
		
		//recupera historico recente
		List<HistoricoTransacaoIntegrationDTO> historico = recuperaHistoricoTransacoesRecentes(carteira);
		//ordena a lista por data da mais recente a mais antiga
		List<HistoricoTransacaoIntegrationDTO> ultimas = historico.stream().sorted(Comparator.comparing(HistoricoTransacaoIntegrationDTO::getDataHoraTransacao).reversed()).collect(Collectors.toList()).subList(0, NUM_TRANSACOES_RETORNO);
		//constroi a lista de retorno da API
		ultimas.stream().forEach(ultima -> retorno.add(buildApiDto(ultima, carteira)));
		
		return retorno;
	}
	
	/**
	 * Recupera histórico de transações recentes.
	 * @param carteira
	 * @return
	 */
	public List<HistoricoTransacaoIntegrationDTO> recuperaHistoricoTransacoesRecentes(String carteira) {
		HistoricoTransacoesIntegrationResponse response = historicoTransacoesRecentesServiceClient.getHistoricoTransacoesRecentes(carteira);
		log.info(response.toString());
		return response.getHistorico();
	}
	
	/**
	 * Constrói o objeto de retorno da nossa API.
	 * @param historico
	 * @param carteira
	 * @return
	 */
	private HistoricoTransacoesDTO buildApiDto(HistoricoTransacaoIntegrationDTO historico, String carteira) {
		return GenericBuilder.of(HistoricoTransacoesDTO::new)
				.with(HistoricoTransacoesDTO::setDataHoraTransacao, historico.getDataHoraTransacao())
				.with(HistoricoTransacoesDTO::setCotacaoTransacao, historico.getCotacaoTransacao())
				.with(HistoricoTransacoesDTO::setTipoTransacao, historico.getTipoTransacao())
				.with(HistoricoTransacoesDTO::setValorBitcoin, historico.getValorBitcoin())
				.with(HistoricoTransacoesDTO::setValorReal, historico.getValorReal())
				.with(HistoricoTransacoesDTO::setCarteira, carteira)
				.build();
	}

}
