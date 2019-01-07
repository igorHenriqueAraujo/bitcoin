package br.com.ciandt.bitcoin.api.services.integration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraClient;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraDTO;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraResponse;

/**
 * Classe de serviço responsável por executar a comunicação com a API de recuperação do saldo atual da carteira de Bitcoins.
 * @author igorha
 *
 */
@Service
public class SaldoCarteiraBitcoinClientService {
	
	private static final Logger log = LoggerFactory.getLogger(SaldoCarteiraBitcoinClientService.class);
	
	@Autowired
	private ApiSaldoCarteiraClient apiSaldoCarteiraClient;
	
	public ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO> getSaldoCarteira(String carteira) {
		ResponseEntity<ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO>> response = apiSaldoCarteiraClient.getSaldoCarteira(carteira);
		log.info(response.toString());
		if (HttpStatus.OK.equals(response.getStatusCode()) && response.hasBody()) {
			return response.getBody();
		}
		return null;
	}

}
