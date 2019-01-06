package br.com.ciandt.bitcoin.api.services.integration;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import br.com.ciandt.bitcoin.api.entities.enums.TipoMoedaEnum;


@RunWith(MockitoJUnitRunner.class)
public class CotacaoBitcoinServiceClientTest {
	
	@Value("${bitcoins.cotacao.base.url}")
	private String baseUrl;
	
	@Mock
	private RestTemplate restTemplate;
	
	@InjectMocks
	private CotacaoBitcoinServiceClient client;
	
	@Test
	public void getCotacaoBitcoinTest() {
		
		BigDecimal valor = new BigDecimal(14221.61).setScale(2, RoundingMode.UP);
		
		Mockito
			.when(restTemplate.getForObject(baseUrl + "/bitcoin/{moeda}", BigDecimal.class, TipoMoedaEnum.REAL.toString()))
			.thenReturn(valor);
		
		BigDecimal result = client.getCotacaoBitcoin();
		Assert.assertEquals(valor, result);
	}

}
