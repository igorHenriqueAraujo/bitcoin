package br.com.ciandt.bitcoin.api.services.integration.saldoapi;

import org.springframework.http.ResponseEntity;

/**
 * Interface de simulação no caso da API fornecer um client para comunicação.
 * Simulação de interface que viria no client disponibilizado.
 * @author igorha
 *
 */
public interface ApiSaldoCarteiraClient {
	
	ResponseEntity<ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO>> getSaldoCarteira(String numeroCarteira);

}
