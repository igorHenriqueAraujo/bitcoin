package br.com.ciandt.bitcoin.api.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ciandt.bitcoin.api.builder.GenericBuilder;
import br.com.ciandt.bitcoin.api.dtos.HistoricoCotacaoBitconDTO;
import br.com.ciandt.bitcoin.api.dtos.HistoricoTransacoesDTO;
import br.com.ciandt.bitcoin.api.dtos.LucroDTO;
import br.com.ciandt.bitcoin.api.dtos.ValorInvestidoDTO;
import br.com.ciandt.bitcoin.api.dtos.enums.TipoTransacaoBitcon;
import br.com.ciandt.bitcoin.api.responses.ApiResponse;


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
	public ResponseEntity<ApiResponse<ValorInvestidoDTO>> valorInvestido(@PathVariable String carteira) {
		
		ValorInvestidoDTO data  = GenericBuilder.of(ValorInvestidoDTO::new)
	            .with(ValorInvestidoDTO::setValorInvestido, new BigDecimal(1000.00).setScale(2, RoundingMode.HALF_UP))
	            .with(ValorInvestidoDTO::setCarteira, carteira)
	            .with(ValorInvestidoDTO::setDataCadastroCarteira, LocalDate.of(2015, Month.MARCH, 7))
	            .build();
		
		ApiResponse<ValorInvestidoDTO> response = GenericBuilder.of(ApiResponse<ValorInvestidoDTO>::new)
	            .with(ApiResponse::setData, data).build(); 
				
		 return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna o lucro obtido do momento do cadastro da carteira até o dia atual.
	 * @param carteira
	 * @return
	 */
	@GetMapping(value = "/lucro/{carteira}")
	public ResponseEntity<ApiResponse<LucroDTO>> lucro(@PathVariable String carteira) {
		
		LucroDTO data  = GenericBuilder.of(LucroDTO::new)
	            .with(LucroDTO::setLucroObtido, new BigDecimal(250000.00).setScale(2, RoundingMode.HALF_UP))
	            .with(LucroDTO::setCarteira, carteira)
	            .with(LucroDTO::setDataCadastroCarteira, LocalDate.of(2015, Month.MARCH, 7))
	            .build();
		
		ApiResponse<LucroDTO> response = GenericBuilder.of(ApiResponse<LucroDTO>::new)
	            .with(ApiResponse::setData, data).build(); 
				
		 return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna o histórico da cotação do Bitcoin no dia.
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/cotacao/historico")
	public ResponseEntity<ApiResponse<List>> historicoCotacaoBitcoinDia() {
		
		List<HistoricoCotacaoBitconDTO> historicoData = new ArrayList<HistoricoCotacaoBitconDTO>();
		
		HistoricoCotacaoBitconDTO hist1 = GenericBuilder.of(HistoricoCotacaoBitconDTO::new)
				.with(HistoricoCotacaoBitconDTO::setHoraObtidaCotacao, LocalTime.now())
				.with(HistoricoCotacaoBitconDTO::setValorCotacao, new BigDecimal(24567.55).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoCotacaoBitconDTO hist2 = GenericBuilder.of(HistoricoCotacaoBitconDTO::new)
				.with(HistoricoCotacaoBitconDTO::setHoraObtidaCotacao, LocalTime.now().plusHours(4))
				.with(HistoricoCotacaoBitconDTO::setValorCotacao, new BigDecimal(25800.66).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		historicoData.add(hist1);
		historicoData.add(hist2);
		
		ApiResponse<List> response = GenericBuilder.of(ApiResponse<List>::new)
				.with(ApiResponse::setData, historicoData).build();
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna o historico de todas as transações da Carteira.
	 * @param carteira
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/transacoes/historico/{carteira}")
	public ResponseEntity<ApiResponse<List>> historicoTransacoes(@PathVariable String carteira) {
		
		List<HistoricoTransacoesDTO> historicoData = new ArrayList<HistoricoTransacoesDTO>();
		
		HistoricoTransacoesDTO hist0 = GenericBuilder.of(HistoricoTransacoesDTO::new)
				.with(HistoricoTransacoesDTO::setDataHoraTransacao, LocalDateTime.now().plusDays(-10))
				.with(HistoricoTransacoesDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setTipoTransacao, TipoTransacaoBitcon.COMPRA)
				.with(HistoricoTransacoesDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setCarteira, carteira)
				.build();
		
		HistoricoTransacoesDTO hist1 = GenericBuilder.of(HistoricoTransacoesDTO::new)
				.with(HistoricoTransacoesDTO::setDataHoraTransacao, LocalDateTime.now().plusDays(-10))
				.with(HistoricoTransacoesDTO::setCotacaoTransacao, new BigDecimal(24567.55).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setTipoTransacao, TipoTransacaoBitcon.COMPRA)
				.with(HistoricoTransacoesDTO::setValorBitcoin, new BigDecimal(98).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setValorReal, new BigDecimal(2407619.9).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setCarteira, carteira)
				.build();
		
		HistoricoTransacoesDTO hist2 = GenericBuilder.of(HistoricoTransacoesDTO::new)
				.with(HistoricoTransacoesDTO::setDataHoraTransacao, LocalDateTime.now().plusDays(-15))
				.with(HistoricoTransacoesDTO::setCotacaoTransacao, new BigDecimal(23989.56).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setTipoTransacao, TipoTransacaoBitcon.COMPRA)
				.with(HistoricoTransacoesDTO::setValorBitcoin, new BigDecimal(653).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setValorReal, new BigDecimal(15665182.68).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setCarteira, carteira)
				.build();
		
		HistoricoTransacoesDTO hist3 = GenericBuilder.of(HistoricoTransacoesDTO::new)
				.with(HistoricoTransacoesDTO::setDataHoraTransacao, LocalDateTime.now().plusDays(-3))
				.with(HistoricoTransacoesDTO::setCotacaoTransacao, new BigDecimal(25123.10).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setTipoTransacao, TipoTransacaoBitcon.VENDA)
				.with(HistoricoTransacoesDTO::setValorBitcoin, new BigDecimal(1000).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setValorReal, new BigDecimal(25123100).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacoesDTO::setCarteira, carteira)
				.build();
		
		historicoData.add(hist0);
		historicoData.add(hist1);
		historicoData.add(hist2);
		historicoData.add(hist3);
		
		ApiResponse<List> response = GenericBuilder.of(ApiResponse<List>::new)
				.with(ApiResponse::setData, historicoData).build();
		
		return ResponseEntity.ok(response);
	}

}
