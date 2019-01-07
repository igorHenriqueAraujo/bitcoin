package br.com.ciandt.bitcoin.api.services.integration;

import java.math.BigDecimal;
import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraClient;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraDTO;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraResponse;

@RunWith(MockitoJUnitRunner.class)
public class SaldoCarteiraBitcoinServiceClientTest {
	
	@Mock
	private ApiSaldoCarteiraClient apiSaldoCarteiraClient;
	
	@InjectMocks
	private SaldoCarteiraBitcoinServiceClient saldoCarteiraBitcoinClientService;
	
	@Test
	public void getSaldoCarteiraTest() {
		ResponseEntity<ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO>> retornoMock = 
				ResponseEntity.ok(new ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO>(new ApiSaldoCarteiraDTO("123456", new BigDecimal(1000)), new ArrayList<String>()));
		Mockito.when(apiSaldoCarteiraClient.getSaldoCarteira("123456")).thenReturn(retornoMock);
		
		ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO> retorno = saldoCarteiraBitcoinClientService.getSaldoCarteira("123456");
		
		Assert.assertNotNull(retorno);
		Assert.assertNotNull(retorno.getData());
		Assert.assertEquals(retorno.getData().getCarteira(), "123456");
		Assert.assertEquals(retorno.getData().getSaldo(), new BigDecimal(1000));
		
	}

}
