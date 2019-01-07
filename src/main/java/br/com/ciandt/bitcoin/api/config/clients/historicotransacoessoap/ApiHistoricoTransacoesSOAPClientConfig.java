package br.com.ciandt.bitcoin.api.config.clients.historicotransacoessoap;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;

/**
 * Classe de configuração do client soap
 * @author igorha
 *
 */
@Configuration
public class ApiHistoricoTransacoesSOAPClientConfig {
	
	@Value("${api.historico.transacoes.soap.url.conexao}")
	private String urlConexao;
	
    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        // this is the package name specified in the <generatePackage> specified in
        // pom.xml
        marshaller.setContextPath("br.com.ciandt.bitcoin.historicotransacoes.soapapi");
        return marshaller;
    }
 
    @Bean
    public HistoricoTransacoesSOAPConnector soapConnector(Jaxb2Marshaller marshaller) {
    	HistoricoTransacoesSOAPConnector client = new HistoricoTransacoesSOAPConnector();
        client.setDefaultUri(urlConexao);
        client.setMarshaller(marshaller);
        client.setUnmarshaller(marshaller);
        return client;
    }

}
