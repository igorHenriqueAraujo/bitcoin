package br.com.ciandt.bitcoin.api.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * Classe Controller responsável por expor os endpoints RESTfull com as funcionalidades da API.
 * @author Igor Henrique de Araújo
 * Data: 02/01/2019
 *
 */
@RestController
@RequestMapping("/api/")
public class BitcoinAPIController {
	
	/**
	 * Retorna o valor investido desde o momento do cadastro da carteira.
	 * @param carteira
	 * @return
	 */
	@GetMapping(value = "/valorinvestido/{carteira}")
	public String valorInvestido(@PathVariable String carteira) {
		 return "Olá " + carteira;
	}
	
	/**
	 * Retorna o lucro obtido do momento do cadastro da carteira até o dia atual.
	 * @param carteira
	 * @return
	 */
	@GetMapping(value = "/lucro/{carteira}")
	public String lucro(@PathVariable String carteira) {
		 return "Olá ";
	}
	
	/**
	 * Retorna o histórico da cotação do Bitcoin no dia.
	 * @return
	 */
	@GetMapping(value = "/cotacao/historico")
	public String historicoCotacaoBitcoinDia() {
		return "Olá Historico";
	}
	
	/**
	 * Retorna o historico de todas as transações da Carteira.
	 * @param carteira
	 * @return
	 */
	@GetMapping(value = "/transacoes/historico/{carteira}")
	public String historicoTransacoes(@PathVariable String carteira) {
		return "Olá ";
	}

}
