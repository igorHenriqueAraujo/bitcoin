package br.com.ciandt.bitcoin.historico;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import br.com.ciandt.xml.carteirabitcoin.HistoricoTransacaoRequest;
import br.com.ciandt.xml.carteirabitcoin.HistoricoTransacaoResponse;
import br.com.ciandt.xml.carteirabitcoin.TipoTransacao;
import br.com.ciandt.xml.carteirabitcoin.Transacao;

@Endpoint
public class HistoricoEndpoint {
	
	private static final String NAMESPACE_URI = "http://www.ciandt.com.br/xml/carteirabitcoin";
	
	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "HistoricoTransacaoRequest")
	@ResponsePayload
	public HistoricoTransacaoResponse getHistoricoTransacoes(@RequestPayload HistoricoTransacaoRequest request) {
		HistoricoTransacaoResponse response = new HistoricoTransacaoResponse();
		
		response.setNumeroCarteira(request.getNumeroCarteira());
		response.getHistoricoTransacoes().addAll(getTransacoes());
		
		return response;
	}
	
	private List<Transacao> getTransacoes(){
		List<Transacao> historico = new ArrayList<Transacao>();
		
		Transacao _1 = new Transacao();
		_1.setDataHoraTransacao(convertLocalDateTimeToXMLGregorianCalendar(LocalDateTime.now().minusMonths(3)));
		_1.setCotacaoTransacao(new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP));
		_1.setTipoTransacao(TipoTransacao.COMPRA);
		_1.setValorBitcoin(new BigDecimal(249).setScale(2, RoundingMode.HALF_UP));
		_1.setValorReal(new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP));
		
		Transacao _2 = new Transacao();
		_2.setDataHoraTransacao(convertLocalDateTimeToXMLGregorianCalendar(LocalDateTime.now().minusMonths(4).minusDays(15)));
		_2.setCotacaoTransacao(new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP));
		_2.setTipoTransacao(TipoTransacao.COMPRA);
		_2.setValorBitcoin(new BigDecimal(249).setScale(2, RoundingMode.HALF_UP));
		_2.setValorReal(new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP));
		
		Transacao _3 = new Transacao();
		_3.setDataHoraTransacao(convertLocalDateTimeToXMLGregorianCalendar(LocalDateTime.now().minusMonths(4).minusDays(25)));
		_3.setCotacaoTransacao(new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP));
		_3.setTipoTransacao(TipoTransacao.COMPRA);
		_3.setValorBitcoin(new BigDecimal(249).setScale(2, RoundingMode.HALF_UP));
		_3.setValorReal(new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP));
		
		Transacao _4 = new Transacao();
		_4.setDataHoraTransacao(convertLocalDateTimeToXMLGregorianCalendar(LocalDateTime.now().minusMonths(3).minusDays(5)));
		_4.setCotacaoTransacao(new BigDecimal(24332.23).setScale(2, RoundingMode.HALF_UP));
		_4.setTipoTransacao(TipoTransacao.VENDA);
		_4.setValorBitcoin(new BigDecimal(249).setScale(2, RoundingMode.HALF_UP));
		_4.setValorReal(new BigDecimal(6058725.27).setScale(2, RoundingMode.HALF_UP));
		
		historico.add(_1);
		historico.add(_2);
		historico.add(_3);
		historico.add(_4);
		
		return historico;
	}
	
	private XMLGregorianCalendar convertLocalDateTimeToXMLGregorianCalendar(LocalDateTime localDateTime) {
		GregorianCalendar gcal = GregorianCalendar.from(localDateTime.atZone(ZoneId.systemDefault()));
		XMLGregorianCalendar xcal;
		try {
			xcal = DatatypeFactory.newInstance().newXMLGregorianCalendar(gcal);
			return xcal;
		} catch (DatatypeConfigurationException e) {
			return null;
		}
	}

}
