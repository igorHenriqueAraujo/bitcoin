package br.com.ciandt.bitcoin.api.services.integration;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Optional;

import javax.xml.datatype.XMLGregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.builder.GenericBuilder;
import br.com.ciandt.bitcoin.api.config.clients.historicotransacoessoap.HistoricoTransacoesSOAPConnector;
import br.com.ciandt.bitcoin.api.dtos.HistoricoTransacoesDTO;
import br.com.ciandt.bitcoin.api.dtos.enums.TipoTransacaoBitcoin;
import br.com.ciandt.bitcoin.historicotransacoes.soapapi.HistoricoTransacaoRequest;
import br.com.ciandt.bitcoin.historicotransacoes.soapapi.HistoricoTransacaoResponse;
import br.com.ciandt.bitcoin.historicotransacoes.soapapi.TipoTransacao;
import br.com.ciandt.bitcoin.historicotransacoes.soapapi.Transacao;

/**
 * Classe de serviço responsável por executar a comunicação com a API de recuperação do historico antigo de transações, retorna transacoes com mais de 3 meses.
 * @author igorha
 *
 */
@Service
public class HistoricoTransacoesAntigasServiceClient {
	
	@Value("${api.historico.transacoes.soap.url.conexao}")
	private String urlConexao;
	
	@Autowired
	HistoricoTransacoesSOAPConnector soapConnector;
	
	/**
	 * Recupera historico de transações antigas da carteira de bitcoins.
	 * @return
	 */
	public List<HistoricoTransacoesDTO> getHistoricoTransacoesAntigas(String carteira) {
		
		List<HistoricoTransacoesDTO> listaRetorno = new ArrayList<HistoricoTransacoesDTO>();
		HistoricoTransacaoRequest request = new HistoricoTransacaoRequest();
		request.setNumeroCarteira(carteira);
		HistoricoTransacaoResponse response = (HistoricoTransacaoResponse) soapConnector.callWebService(urlConexao, request);
		response.getHistoricoTransacoes().stream().forEach(historico -> listaRetorno.add(converteObjeto(historico, carteira)));
		
		return listaRetorno;
	}
	
	/**
	 * Converte o objeto retornado da API SOAP para o objeto conhecido pela aplicação.
	 * @param transacao
	 * @return
	 */
	private HistoricoTransacoesDTO converteObjeto(Transacao transacao, String carteira) {
		HistoricoTransacoesDTO historico = GenericBuilder.of(HistoricoTransacoesDTO::new)
				.with(HistoricoTransacoesDTO::setCarteira, carteira)
				.with(HistoricoTransacoesDTO::setCotacaoTransacao, transacao.getCotacaoTransacao())
				.with(HistoricoTransacoesDTO::setDataHoraTransacao, converteXMLGregorianCalendarToLocalDateTime(transacao.getDataHoraTransacao()))
				.with(HistoricoTransacoesDTO::setTipoTransacao, converteTipoTransacao(transacao.getTipoTransacao()))
				.with(HistoricoTransacoesDTO::setValorBitcoin, transacao.getValorBitcoin())
				.with(HistoricoTransacoesDTO::setValorReal, transacao.getValorReal())
				.build();
		return historico;
	}
	
	private LocalDateTime converteXMLGregorianCalendarToLocalDateTime(XMLGregorianCalendar xcal) {
		GregorianCalendar gcal = xcal.toGregorianCalendar();
		LocalDateTime dateTime = gcal.toZonedDateTime().withZoneSameInstant(ZoneId.systemDefault()).toLocalDateTime();
		return dateTime;
	}
	
	private TipoTransacaoBitcoin converteTipoTransacao(TipoTransacao tipoTransacao) {
		List<TipoTransacaoBitcoin> values = Arrays.asList(TipoTransacaoBitcoin.values());
		Optional<TipoTransacaoBitcoin> retorno = values.stream().filter(tipo -> tipo.toString().equals(tipoTransacao.toString())).findAny();
		return retorno.get();
	}

}
