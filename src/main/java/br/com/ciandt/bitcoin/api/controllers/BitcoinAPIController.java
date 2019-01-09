package br.com.ciandt.bitcoin.api.controllers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.ciandt.bitcoin.api.builder.GenericBuilder;
import br.com.ciandt.bitcoin.api.dtos.HistoricoCotacaoBitconDTO;
import br.com.ciandt.bitcoin.api.dtos.HistoricoTransacoesDTO;
import br.com.ciandt.bitcoin.api.dtos.LucroDTO;
import br.com.ciandt.bitcoin.api.dtos.ValorInvestidoDTO;
import br.com.ciandt.bitcoin.api.responses.ApiResponse;
import br.com.ciandt.bitcoin.api.services.CotacaoDiariaBitcoinService;
import br.com.ciandt.bitcoin.api.services.LucroObtidoService;
import br.com.ciandt.bitcoin.api.services.TotalInvestidoService;
import br.com.ciandt.bitcoin.api.services.TransacoesRecentesService;


/**
 * Classe Controller responsável por expor os endpoints RESTfull com as funcionalidades da API.
 * @author Igor Henrique de Araújo
 * Data: 02/01/2019
 *
 */
@RestController
@RequestMapping("/api/")
public class BitcoinAPIController {
	
	@Autowired
	private CotacaoDiariaBitcoinService cotacaoDiariaBitcoinService;
	
	@Autowired
	private TotalInvestidoService totalInvestidoService;
	
	@Autowired
	private TransacoesRecentesService transacoesRecentesService;
	
	@Autowired
	private LucroObtidoService lucroObtidoService;
	
	/**
	 * Retorna o valor investido desde o momento do cadastro da carteira.
	 * @param carteira
	 * @return
	 */
	@GetMapping(value = "/valorinvestido/{carteira}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ApiResponse<ValorInvestidoDTO>> valorInvestido(@PathVariable String carteira) {
		
		BigDecimal valorInvestido = totalInvestidoService.getTotalInvestido(carteira);
		
		ValorInvestidoDTO data  = GenericBuilder.of(ValorInvestidoDTO::new)
	            .with(ValorInvestidoDTO::setValorInvestido, valorInvestido.setScale(2, RoundingMode.HALF_UP))
	            .with(ValorInvestidoDTO::setCarteira, carteira)
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
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<ApiResponse<LucroDTO>> lucro(@PathVariable String carteira) {
		
		LucroDTO data  = GenericBuilder.of(LucroDTO::new)
	            .with(LucroDTO::setLucroObtido, lucroObtidoService.getLucroObtido(carteira))
	            .with(LucroDTO::setCarteira, carteira)
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
		
		List<HistoricoCotacaoBitconDTO> historicoData = cotacaoDiariaBitcoinService.listaHistoricoCotacaoBitcoinDia(LocalDate.now());
		
		
		ApiResponse<List> response = GenericBuilder.of(ApiResponse<List>::new)
				.with(ApiResponse::setData, historicoData).build();
		
		return ResponseEntity.ok(response);
	}
	
	/**
	 * Retorna o historico das ultimas 5 transações da Carteira.
	 * @param carteira
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	@GetMapping(value = "/transacoes/historico/{carteira}")
	@PreAuthorize("hasAnyRole('ADMIN','USUARIO')")
	public ResponseEntity<ApiResponse<List>> historicoTransacoes(@PathVariable String carteira) {
		
		List<HistoricoTransacoesDTO> historicoData = transacoesRecentesService.listUltimasTransacoes(carteira);
		
		ApiResponse<List> response = GenericBuilder.of(ApiResponse<List>::new)
				.with(ApiResponse::setData, historicoData).build();
		
		return ResponseEntity.ok(response);
	}

}
