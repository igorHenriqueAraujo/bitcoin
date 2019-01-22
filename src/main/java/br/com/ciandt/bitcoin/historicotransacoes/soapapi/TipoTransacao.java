//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.01.22 às 04:33:23 PM BRST 
//


package br.com.ciandt.bitcoin.historicotransacoes.soapapi;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de TipoTransacao.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * <p>
 * <pre>
 * &lt;simpleType name="TipoTransacao"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="COMPRA"/&gt;
 *     &lt;enumeration value="VENDA"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "TipoTransacao")
@XmlEnum
public enum TipoTransacao {

    COMPRA,
    VENDA;

    public String value() {
        return name();
    }

    public static TipoTransacao fromValue(String v) {
        return valueOf(v);
    }

}
