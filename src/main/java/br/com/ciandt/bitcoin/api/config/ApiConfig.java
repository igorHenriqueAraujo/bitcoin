package br.com.ciandt.bitcoin.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Classe que encapsula as configurações gerais da aplicação
 * @author igorha
 *
 */
@Configuration
public class ApiConfig {
	
	/**
	 * Configura o Bean Rest Template para comunicação com outras API RESTfull.
	 * @return
	 */
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
