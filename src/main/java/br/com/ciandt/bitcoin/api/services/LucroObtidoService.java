package br.com.ciandt.bitcoin.api.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.services.integration.SaldoCarteiraBitcoinClientService;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraDTO;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraResponse;

@Service
public class LucroObtidoService {
	
	private static final Logger log = LoggerFactory.getLogger(LucroObtidoService.class);
	
	@Autowired
	private SaldoCarteiraBitcoinClientService saldoCarteiraBitcoinClientService;
	
	@Scheduled(fixedRate=60000)
	public void teste() {
		ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO> response = saldoCarteiraBitcoinClientService.getSaldoCarteira("123456789");
		log.info(response.getData().toString());
	}
	

}
