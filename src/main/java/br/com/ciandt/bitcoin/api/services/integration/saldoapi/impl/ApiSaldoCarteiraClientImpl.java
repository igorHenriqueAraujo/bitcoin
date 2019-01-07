package br.com.ciandt.bitcoin.api.services.integration.saldoapi.impl;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;

import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraClient;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraDTO;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraResponse;

/**
 * Classe de implemetação da interface do serviço utilizada para simular o retorno da API.
 * Simulação de classe que viria no client disponibilizado.
 * @author igorha
 *
 */
public class ApiSaldoCarteiraClientImpl implements ApiSaldoCarteiraClient{
	
	private static final Logger log = LoggerFactory.getLogger(ApiSaldoCarteiraClientImpl.class);

	/*
	 * URL de conexão com a API.
	 */
	private String urlConexao;
	
	public ApiSaldoCarteiraClientImpl(String urlConexao) {
		this.urlConexao = urlConexao;
	}
	
	public ResponseEntity<ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO>> getSaldoCarteira(String numeroCarteira){
		log.info(getUrlConexao());
		return ResponseEntity.ok(new ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO>(new ApiSaldoCarteiraDTO(numeroCarteira, new BigDecimal(1000)), new ArrayList<String>()));
	}

	public String getUrlConexao() {
		return urlConexao;
	}

	public void setUrlConexao(String urlConexao) {
		this.urlConexao = urlConexao;
	}
	
}
