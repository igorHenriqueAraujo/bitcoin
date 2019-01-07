package br.com.ciandt.bitcoin.api.scheduler;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.ciandt.bitcoin.api.entities.CotacaoBitcoinEntity;
import br.com.ciandt.bitcoin.api.services.CotacaoDiariaBitcoinService;
import br.com.ciandt.bitcoin.api.services.integration.CotacaoBitcoinServiceClient;

/**
 * Componente responsável por recuperar a cotação da Bitcoin de hora em hora e armazenar no BD.
 * A execução é agendada via recursos de Scheduler do Spring.
 * @author igorha
 *
 */
@Component
public class CotacaoDiariaBitcoinScheduler {
	
	private static final Logger log = LoggerFactory.getLogger(CotacaoDiariaBitcoinScheduler.class);
	
	@Autowired
	private CotacaoDiariaBitcoinService cotacaoBitcoinService;
	
	@Autowired
	private CotacaoBitcoinServiceClient cotacaoBitcoinServiceClient;
	
	
	/**
	 * Método iniciado pelo scheduler para executar o processo.
	 */
	@Scheduled(fixedRate=600000)
	public void obtemCotacaoBitcon() {
		CotacaoBitcoinEntity saved = save(getCotacao());
		log.info(saved.toString());	
	}
	
	public BigDecimal getCotacao() {
		return cotacaoBitcoinServiceClient.getCotacaoBitcoin();
	}
	
	public CotacaoBitcoinEntity save(BigDecimal cotacao) {
		return cotacaoBitcoinService.save(cotacao);
	}

}
