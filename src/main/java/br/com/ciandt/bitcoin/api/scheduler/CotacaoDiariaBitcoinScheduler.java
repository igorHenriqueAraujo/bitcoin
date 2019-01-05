package br.com.ciandt.bitcoin.api.scheduler;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import br.com.ciandt.bitcoin.api.entities.CotacaoBitcoinEntity;
import br.com.ciandt.bitcoin.api.services.CotacaoDiariaBitcoinService;

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
	
	private BigDecimal valorBitcoinMock = new BigDecimal(14221.61).setScale(2, RoundingMode.UP);
	
	/**
	 * Método iniciado pelo scheduler para executar o processo.
	 */
	@Scheduled(fixedRate=60000)
	public void obtemCotacaoBitcon() {
		CotacaoBitcoinEntity saved = cotacaoBitcoinService.save(valorBitcoinMock.add(new BigDecimal(10)));
		log.info(saved.toString());
		
	}

}
