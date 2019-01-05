package br.com.ciandt.bitcoin.api.scheduler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Componente responsável por recuperar a cotação da Bitcoin de hora em hora e armazenar no BD.
 * A execução é agendada via recursos de Scheduler do Spring.
 * @author igorha
 *
 */
@Component
public class CotacaoDiariaBitcoinScheduler {
	
	private static final Logger log = LoggerFactory.getLogger(CotacaoDiariaBitcoinScheduler.class);
	
	/**
	 * Método iniciado pelo scheduler para executar o processo.
	 */
	@Scheduled(fixedRate=5000)
	public void obtemCotacaoBitcon() {
		log.info("Obtem Cotação do Bitcon e Armazena");
	}

}
