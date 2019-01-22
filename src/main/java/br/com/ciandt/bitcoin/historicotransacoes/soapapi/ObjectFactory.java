//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.01.22 às 04:33:23 PM BRST 
//


package br.com.ciandt.bitcoin.historicotransacoes.soapapi;

import javax.xml.bind.annotation.XmlRegistry;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the br.com.ciandt.bitcoin.historicotransacoes.soapapi package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {


    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: br.com.ciandt.bitcoin.historicotransacoes.soapapi
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link HistoricoTransacaoRequest }
     * 
     */
    public HistoricoTransacaoRequest createHistoricoTransacaoRequest() {
        return new HistoricoTransacaoRequest();
    }

    /**
     * Create an instance of {@link HistoricoTransacaoResponse }
     * 
     */
    public HistoricoTransacaoResponse createHistoricoTransacaoResponse() {
        return new HistoricoTransacaoResponse();
    }

    /**
     * Create an instance of {@link Transacao }
     * 
     */
    public Transacao createTransacao() {
        return new Transacao();
    }

}
