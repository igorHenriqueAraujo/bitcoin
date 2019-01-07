package br.com.ciandt.bitcoin.api.config.clients.apisaldo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraClient;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.impl.ApiSaldoCarteiraClientImpl;

/**
 * Classe responsável por configurar e iniciar o Client fornecido para comunicação com a API.
 * @author igorha
 *
 */
@Configuration
public class ApiSaldoClientConfig {

	@Value("${api.saldo.carteira.url.conexao}")
	private String urlConexao;
	
	@Bean
	public ApiSaldoCarteiraClient apiSaldoCarteiraClient() {
		return new ApiSaldoCarteiraClientImpl(this.urlConexao);
	}
	
}
