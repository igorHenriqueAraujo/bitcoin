package br.com.ciandt.bitcoin.api.config.clients.historicotransacoessoap;

import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 * Conector com o web service SOAP
 * @author igorha
 *
 */
public class HistoricoTransacoesSOAPConnector extends WebServiceGatewaySupport {
	
	public Object callWebService(String url, Object request) {
		return getWebServiceTemplate().marshalSendAndReceive(url, request);
	}

}
