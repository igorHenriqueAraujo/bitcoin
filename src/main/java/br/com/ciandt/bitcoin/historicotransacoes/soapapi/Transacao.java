//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.01.10 às 12:07:59 PM BRST 
//


package br.com.ciandt.bitcoin.historicotransacoes.soapapi;

import java.math.BigDecimal;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Classe Java de Transacao complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType name="Transacao"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="valorReal" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="valorBitcoin" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="cotacaoTransacao" type="{http://www.w3.org/2001/XMLSchema}decimal"/&gt;
 *         &lt;element name="tipoTransacao" type="{http://www.ciandt.com.br/xml/carteirabitcoin}TipoTransacao"/&gt;
 *         &lt;element name="dataHoraTransacao" type="{http://www.w3.org/2001/XMLSchema}dateTime"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Transacao", propOrder = {
    "valorReal",
    "valorBitcoin",
    "cotacaoTransacao",
    "tipoTransacao",
    "dataHoraTransacao"
})
public class Transacao {

    @XmlElement(required = true)
    protected BigDecimal valorReal;
    @XmlElement(required = true)
    protected BigDecimal valorBitcoin;
    @XmlElement(required = true)
    protected BigDecimal cotacaoTransacao;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected TipoTransacao tipoTransacao;
    @XmlElement(required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar dataHoraTransacao;

    /**
     * Obtém o valor da propriedade valorReal.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorReal() {
        return valorReal;
    }

    /**
     * Define o valor da propriedade valorReal.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorReal(BigDecimal value) {
        this.valorReal = value;
    }

    /**
     * Obtém o valor da propriedade valorBitcoin.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getValorBitcoin() {
        return valorBitcoin;
    }

    /**
     * Define o valor da propriedade valorBitcoin.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setValorBitcoin(BigDecimal value) {
        this.valorBitcoin = value;
    }

    /**
     * Obtém o valor da propriedade cotacaoTransacao.
     * 
     * @return
     *     possible object is
     *     {@link BigDecimal }
     *     
     */
    public BigDecimal getCotacaoTransacao() {
        return cotacaoTransacao;
    }

    /**
     * Define o valor da propriedade cotacaoTransacao.
     * 
     * @param value
     *     allowed object is
     *     {@link BigDecimal }
     *     
     */
    public void setCotacaoTransacao(BigDecimal value) {
        this.cotacaoTransacao = value;
    }

    /**
     * Obtém o valor da propriedade tipoTransacao.
     * 
     * @return
     *     possible object is
     *     {@link TipoTransacao }
     *     
     */
    public TipoTransacao getTipoTransacao() {
        return tipoTransacao;
    }

    /**
     * Define o valor da propriedade tipoTransacao.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoTransacao }
     *     
     */
    public void setTipoTransacao(TipoTransacao value) {
        this.tipoTransacao = value;
    }

    /**
     * Obtém o valor da propriedade dataHoraTransacao.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getDataHoraTransacao() {
        return dataHoraTransacao;
    }

    /**
     * Define o valor da propriedade dataHoraTransacao.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setDataHoraTransacao(XMLGregorianCalendar value) {
        this.dataHoraTransacao = value;
    }

}
