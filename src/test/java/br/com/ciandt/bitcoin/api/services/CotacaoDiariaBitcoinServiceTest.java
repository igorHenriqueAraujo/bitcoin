package br.com.ciandt.bitcoin.api.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.ciandt.bitcoin.api.dtos.HistoricoCotacaoBitconDTO;
import br.com.ciandt.bitcoin.api.entities.CotacaoBitcoinEntity;
import br.com.ciandt.bitcoin.api.entities.enums.TipoMoedaEnum;
import br.com.ciandt.bitcoin.api.repositories.CotacaoBitcoinRepository;

@RunWith(SpringRunner.class)
public class CotacaoDiariaBitcoinServiceTest {
	
	
	@TestConfiguration
	static class CotacaoDiariaBitcoinServiceConfig {
		@Bean
		public CotacaoDiariaBitcoinService cotacaoDiariaBitcoinService() {
			return new CotacaoDiariaBitcoinService();
		}
	}
	
	@MockBean
	private CotacaoBitcoinRepository cotacaoBitcoinRepository;
	
	@Autowired
	private CotacaoDiariaBitcoinService cotacaoDiariaBitcoinService;
	
	private List<CotacaoBitcoinEntity> listaMock = new ArrayList<CotacaoBitcoinEntity>();
	
	private BigDecimal cotacaoInicial = new BigDecimal(14221.61).setScale(2, RoundingMode.UP);
	
	private LocalDateTime dataHoraReferencia = LocalDateTime.now();
	
	@Before
	public void setUp() {
		
		CotacaoBitcoinEntity ent1 = new CotacaoBitcoinEntity();
		ent1.setId(1L);
		ent1.setTipoMoeda(TipoMoedaEnum.REAL);
		ent1.setDataHoraObtidaCotacao(dataHoraReferencia.minusHours(1));
		ent1.setValor(this.cotacaoInicial.add(new BigDecimal(10)));
		
		CotacaoBitcoinEntity ent2 = new CotacaoBitcoinEntity();
		ent2.setId(2L);
		ent2.setTipoMoeda(TipoMoedaEnum.REAL);
		ent2.setDataHoraObtidaCotacao(dataHoraReferencia);
		ent2.setValor(this.cotacaoInicial);
		
		listaMock.add(ent1);
		listaMock.add(ent2);
		
	}
	
	@Test
	public void saveTest() {
		
		CotacaoBitcoinEntity entity = new CotacaoBitcoinEntity();
		entity.setDataHoraObtidaCotacao(LocalDateTime.now());
		entity.setId(1L);
		entity.setTipoMoeda(TipoMoedaEnum.REAL);
		entity.setValor(this.cotacaoInicial);
		
		Mockito.when(cotacaoBitcoinRepository.save(Mockito.any())).thenReturn(entity);
		
		CotacaoBitcoinEntity result = cotacaoDiariaBitcoinService.save(this.cotacaoInicial);
		
		Assert.assertEquals(entity.getId(), result.getId());
		Assert.assertEquals(entity.getDataHoraObtidaCotacao(), result.getDataHoraObtidaCotacao());
		Assert.assertEquals(entity.getTipoMoeda(), result.getTipoMoeda());
		Assert.assertEquals(entity.getValor(), result.getValor());
		
	}
	
	@Test
	public void listaHistoricoCotacaoBitcoinDiaTest() {
		
		Mockito.when(cotacaoBitcoinRepository.findAllByDataHoraObtidaCotacaoBetween(Mockito.any(), Mockito.any())).thenReturn(listaMock);
		
		List<HistoricoCotacaoBitconDTO> result = cotacaoDiariaBitcoinService.listaHistoricoCotacaoBitcoinDia(LocalDate.now());
		
		//Verifica se a lista está totalmente como esperado
		Assert.assertNotNull(result);
		Assert.assertFalse(result.isEmpty());
		Assert.assertTrue(result.size() == 2);
		
		//Verifica se os objetos estão como esperado
		Optional<HistoricoCotacaoBitconDTO> hist1 = result.stream().filter(obj -> obj.getValorCotacao().equals(cotacaoInicial)).findFirst();
		Assert.assertNotNull(hist1.get());
		Assert.assertNotNull(hist1.get().getHoraObtidaCotacao());
		Assert.assertEquals(hist1.get().getHoraObtidaCotacao(), dataHoraReferencia.toLocalTime());
		
		Optional<HistoricoCotacaoBitconDTO> hist2 = result.stream().filter(obj -> obj.getValorCotacao().equals(cotacaoInicial.add(new BigDecimal(10)))).findFirst();
		Assert.assertNotNull(hist2.get());
		Assert.assertNotNull(hist2.get().getHoraObtidaCotacao());
		Assert.assertEquals(hist2.get().getHoraObtidaCotacao(), dataHoraReferencia.minusHours(1).toLocalTime());
		
		
	}

}
