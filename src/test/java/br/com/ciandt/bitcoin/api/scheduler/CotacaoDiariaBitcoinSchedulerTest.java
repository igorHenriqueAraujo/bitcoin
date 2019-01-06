package br.com.ciandt.bitcoin.api.scheduler;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import br.com.ciandt.bitcoin.api.entities.CotacaoBitcoinEntity;
import br.com.ciandt.bitcoin.api.entities.enums.TipoMoedaEnum;
import br.com.ciandt.bitcoin.api.services.CotacaoDiariaBitcoinService;
import br.com.ciandt.bitcoin.api.services.integration.CotacaoBitcoinServiceClient;

@RunWith(MockitoJUnitRunner.class)
public class CotacaoDiariaBitcoinSchedulerTest {
	
	@Mock
	private CotacaoDiariaBitcoinService cotacaoBitcoinService;
	
	@Mock
	private CotacaoBitcoinServiceClient cotacaoBitcoinServiceClient;
	
	@InjectMocks
	private CotacaoDiariaBitcoinScheduler cotacaoDiariaBitcoinScheduler;
	
	@Test
	public void getCotacaoTest() {
		
		BigDecimal valor = new BigDecimal(14221.61).setScale(2, RoundingMode.UP);
		
		Mockito.when(cotacaoBitcoinServiceClient.getCotacaoBitcoin()).thenReturn(valor);
		
		BigDecimal result = cotacaoDiariaBitcoinScheduler.getCotacao();
		
		Assert.assertEquals(valor, result);
	}
	
	@Test
	public void saveTest() {
		BigDecimal valor = new BigDecimal(14221.61).setScale(2, RoundingMode.UP);
		
		CotacaoBitcoinEntity entity = new CotacaoBitcoinEntity();
		entity.setDataHoraObtidaCotacao(LocalDateTime.now());
		entity.setId(1L);
		entity.setTipoMoeda(TipoMoedaEnum.REAL);
		entity.setValor(valor);
		
		Mockito.when(cotacaoBitcoinService.save(valor)).thenReturn(entity);
		
		CotacaoBitcoinEntity result = cotacaoBitcoinService.save(valor);
		
		Assert.assertEquals(entity.getId(), result.getId());
		Assert.assertEquals(entity.getDataHoraObtidaCotacao(), result.getDataHoraObtidaCotacao());
		Assert.assertEquals(entity.getTipoMoeda(), result.getTipoMoeda());
		Assert.assertEquals(entity.getValor(), result.getValor());
		
	}

}
