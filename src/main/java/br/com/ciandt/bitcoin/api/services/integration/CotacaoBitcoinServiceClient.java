package br.com.ciandt.bitcoin.api.services.integration;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import br.com.ciandt.bitcoin.api.entities.enums.TipoMoedaEnum;

/**
 * Classe de serviço responsável por executar a comunicação com a API de recuperação da cotação atual da criptomoeda Bitcoin.
 * @author igorha
 *
 */
@Service
public class CotacaoBitcoinServiceClient {
	
	@Value("${bitcoins.cotacao.base.url}")
	private String baseUrl;
	
	@Autowired
	private RestTemplate restTemplate;
	
	public CotacaoBitcoinServiceClient() {
		
	}
	
	/**
	 * Recupera cotação atual da criptomoeda bitcoin.
	 * @return
	 */
	public BigDecimal getCotacaoBitcoin() {
		return restTemplate.getForObject(baseUrl + "/bitcoin/{moeda}", BigDecimal.class, TipoMoedaEnum.REAL.toString());
	}

}
