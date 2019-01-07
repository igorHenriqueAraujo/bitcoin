package br.com.ciandt.bitcoin.api.services;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.dtos.HistoricoTransacoesDTO;
import br.com.ciandt.bitcoin.api.dtos.enums.TipoTransacaoBitcoin;
import br.com.ciandt.bitcoin.api.dtos.integration.HistoricoTransacaoIntegrationDTO;
import br.com.ciandt.bitcoin.api.responses.integration.HistoricoTransacoesIntegrationResponse;
import br.com.ciandt.bitcoin.api.services.integration.CotacaoBitcoinServiceClient;
import br.com.ciandt.bitcoin.api.services.integration.HistoricoTransacoesAntigasServiceClient;
import br.com.ciandt.bitcoin.api.services.integration.HistoricoTransacoesRecentesServiceClient;
import br.com.ciandt.bitcoin.api.services.integration.SaldoCarteiraBitcoinServiceClient;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraDTO;
import br.com.ciandt.bitcoin.api.services.integration.saldoapi.ApiSaldoCarteiraResponse;

/**
 * Classe de serviço responsável por recuperar as informações e calcular o lucro obtido da criação da carteira até o momento da solicitação.
 * @author igorha
 *
 */
@Service
public class LucroObtidoService {
	
	private static final Logger log = LoggerFactory.getLogger(LucroObtidoService.class);
	
	@Autowired
	private SaldoCarteiraBitcoinServiceClient saldoCarteiraBitcoinServiceClient;
	
	@Autowired
	private CotacaoBitcoinServiceClient cotacaoBitcoinServiceClient;
	
	@Autowired
	private HistoricoTransacoesRecentesServiceClient historicoTransacoesRecentesServiceClient;
	
	@Autowired
	private HistoricoTransacoesAntigasServiceClient historicoTransacoesAntigasServiceClient;
	
	/**
	 * Recupera o lucro obtido da carteira.
	 * @param carteira
	 * @return
	 */
	public BigDecimal getLucroObtido(String carteira) {
		
		//Recupera o saldo atual da carteira
		BigDecimal saldo = recuperaSaldoAtual(carteira);
		//Recupera a cotação atual do bitcoin
		BigDecimal cotacaoAtual = getCotacao();
		//Calcula o valor em reais do saldo da carteira
		BigDecimal lucroSaldo = saldo.multiply(cotacaoAtual).setScale(2, RoundingMode.HALF_UP);
		//Recuperao historico de transações recente
		List<HistoricoTransacaoIntegrationDTO> historicoRecente = recuperaHistoricoTransacoesRecentes(carteira);
		//Recupera historico de transações antigas
		List<HistoricoTransacoesDTO> historicoAntigo = recuperaHistoricoTransacoesAntigas(carteira);
		//Soma as transações do tipo compra da lista de historico antigo
		BigDecimal totalCompra = historicoAntigo.stream()
				.filter(hist -> TipoTransacaoBitcoin.COMPRA.equals(hist.getTipoTransacao()))
				.map((compra) -> compra.getValorReal()).reduce((compra, outra) -> compra.add(outra)).get();
		//Soma as transações do tipo compra da lista de histórico recente e adiciona ao valor antes obtido.
		totalCompra.add(historicoRecente.stream()
				.filter(hist -> TipoTransacaoBitcoin.COMPRA.equals(hist.getTipoTransacao()))
				.map((compra) -> compra.getValorReal()).reduce((compra, outra) -> compra.add(outra)).get());
		//Soma as transações do tipo venda da lista de historico antigo
		BigDecimal totalVenda = historicoAntigo.stream()
				.filter(hist -> TipoTransacaoBitcoin.VENDA.equals(hist.getTipoTransacao()))
				.map((compra) -> compra.getValorReal()).reduce((compra, outra) -> compra.add(outra)).get();
		//Soma as transações do tipo venda da lista de histórico recente e adiciona ao valor antes obtido.
		totalVenda.add(historicoRecente.stream()
				.filter(hist -> TipoTransacaoBitcoin.VENDA.equals(hist.getTipoTransacao()))
				.map((compra) -> compra.getValorReal()).reduce((compra, outra) -> compra.add(outra)).get());
		//obtem o lucro sobre a seguinte fórmula:
		//(Valor em carteira sob a cotação do momento + valor obtido em transações de venda) - valor das transações de compra.
		BigDecimal lucro = (lucroSaldo.add(totalVenda)).subtract(totalCompra);
		
		return lucro;
	}
	
	private BigDecimal recuperaSaldoAtual(String carteira) {
		ApiSaldoCarteiraResponse<ApiSaldoCarteiraDTO> response = saldoCarteiraBitcoinServiceClient.getSaldoCarteira(carteira);
		log.info(response.getData().toString());
		return response.getData().getSaldo();
	}
	
	private BigDecimal getCotacao() {
		return cotacaoBitcoinServiceClient.getCotacaoBitcoin();
	}
	
	private List<HistoricoTransacaoIntegrationDTO> recuperaHistoricoTransacoesRecentes(String carteira) {
		HistoricoTransacoesIntegrationResponse response = historicoTransacoesRecentesServiceClient.getHistoricoTransacoesRecentes(carteira);
		log.info(response.toString());
		return response.getHistorico();
	}
	
	private List<HistoricoTransacoesDTO> recuperaHistoricoTransacoesAntigas(String carteira) {
		return historicoTransacoesAntigasServiceClient.getHistoricoTransacoesAntigas(carteira);
	}

}
