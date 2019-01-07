package br.com.ciandt.bitcoin.api.services.integration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ciandt.bitcoin.api.responses.integration.HistoricoTransacoesIntegrationResponse;

/**
 * Classe de serviço responsável por executar a comunicação com a API de recuperação do historico recente de transações, retorna 10 ultimas transações.
 * @author igorha
 *
 */
@Service
public class HistoricoTransacoesRecentesServiceClient {
	
	@Value("${historico.transacoes.recentes.api.base.url}")
	private String baseUrl;
	
	@Autowired
	private RestTemplate restTemplate;

	public HistoricoTransacoesRecentesServiceClient() {
	}
	
	/**
	 * Recupera historico de transações recentes da carteira de bitcoins.
	 * @return
	 */
	public HistoricoTransacoesIntegrationResponse getHistoricoTransacoesRecentes(String carteira) {
		ResponseEntity<HistoricoTransacoesIntegrationResponse> retorno = 
				restTemplate.getForEntity(baseUrl + "/{carteira}/transacoesrecentes", HistoricoTransacoesIntegrationResponse.class, carteira);
		
		if (retorno != null && retorno.hasBody()) {
			return retorno.getBody();
		}
		return null;
		
	}
	
	

}
