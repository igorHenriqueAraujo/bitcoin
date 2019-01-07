package br.com.ciandt.bitcoin.historico.controllers;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/historico/")
public class HistoricoTransacoesController {
	
	@GetMapping("/{carteira}/transacoesrecentes")
	public ResponseEntity<Response> getCotacao(@PathVariable String carteira){
		return ResponseEntity.ok(mountResponse(carteira));
	}
	
	private Response mountResponse(String carteira) {
		
		List<HistoricoTransacaoDTO> historicoData = new ArrayList<HistoricoTransacaoDTO>();
		
		HistoricoTransacaoDTO hist0 = GenericBuilder.of(HistoricoTransacoesController.HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now())
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist1 = GenericBuilder.of(HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(10))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24567.55).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(98).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(2407619.9).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist2 = GenericBuilder.of(HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(15))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(23989.56).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(653).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(15665182.68).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist3 = GenericBuilder.of(HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(3))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(25123.10).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.VENDA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(1000).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(25123100).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist4 = GenericBuilder.of(HistoricoTransacoesController.HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(20))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist5 =  GenericBuilder.of(HistoricoTransacoesController.HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(23))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist6 =  GenericBuilder.of(HistoricoTransacoesController.HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(25))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist7 =  GenericBuilder.of(HistoricoTransacoesController.HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(30))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist8 =  GenericBuilder.of(HistoricoTransacoesController.HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(35))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		HistoricoTransacaoDTO hist9 =  GenericBuilder.of(HistoricoTransacoesController.HistoricoTransacaoDTO::new)
				.with(HistoricoTransacaoDTO::setDataHoraTransacao, LocalDateTime.now().minusDays(40))
				.with(HistoricoTransacaoDTO::setCotacaoTransacao, new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setTipoTransacao, TipoTransacaoBitcoin.COMPRA)
				.with(HistoricoTransacaoDTO::setValorBitcoin, new BigDecimal(249).setScale(2, RoundingMode.HALF_UP))
				.with(HistoricoTransacaoDTO::setValorReal, new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP))
				.build();
		
		historicoData.add(hist4);
		historicoData.add(hist7);
		historicoData.add(hist1);
		historicoData.add(hist6);
		historicoData.add(hist3);
		historicoData.add(hist5);
		historicoData.add(hist8);
		historicoData.add(hist2);
		historicoData.add(hist9);
		historicoData.add(hist0);
		
		Response response = new Response(carteira, historicoData);
		
		
		return response;
		
	}
	
	public class Response implements Serializable {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = -7501129183654824517L;
		private String carteira;
		private List<HistoricoTransacaoDTO> historico;
		public String getCarteira() {
			return carteira;
		}
		public void setCarteira(String carteira) {
			this.carteira = carteira;
		}
		public List<HistoricoTransacaoDTO> getHistorico() {
			return historico;
		}
		public void setHistorico(List<HistoricoTransacaoDTO> historico) {
			this.historico = historico;
		}
		public Response(String carteira, List<HistoricoTransacaoDTO> historico) {
			super();
			this.carteira = carteira;
			this.historico = historico;
		}
		
	}
	
	public class HistoricoTransacaoDTO implements Serializable {

		/**
		 * 
		 */
		private static final long serialVersionUID = 3513497232941833584L;
		
		private BigDecimal valorReal;
		private BigDecimal valorBitcoin;
		private BigDecimal cotacaoTransacao;
		private LocalDateTime dataHoraTransacao;
		private TipoTransacaoBitcoin tipoTransacao;

		public HistoricoTransacaoDTO() {

		}
		
		public BigDecimal getValorReal() {
			return valorReal;
		}
		public void setValorReal(BigDecimal valorReal) {
			this.valorReal = valorReal;
		}
		public BigDecimal getValorBitcoin() {
			return valorBitcoin;
		}
		public void setValorBitcoin(BigDecimal valorBitcoin) {
			this.valorBitcoin = valorBitcoin;
		}
		public BigDecimal getCotacaoTransacao() {
			return cotacaoTransacao;
		}
		public void setCotacaoTransacao(BigDecimal cotacaoTransacao) {
			this.cotacaoTransacao = cotacaoTransacao;
		}
		public LocalDateTime getDataHoraTransacao() {
			return dataHoraTransacao;
		}
		public void setDataHoraTransacao(LocalDateTime dataHoraTransacao) {
			this.dataHoraTransacao = dataHoraTransacao;
		}
		public TipoTransacaoBitcoin getTipoTransacao() {
			return tipoTransacao;
		}
		public void setTipoTransacao(TipoTransacaoBitcoin tipoTransacao) {
			this.tipoTransacao = tipoTransacao;
		}
		
	}
	
	public enum TipoTransacaoBitcoin {
		VENDA,COMPRA;
	}

}
