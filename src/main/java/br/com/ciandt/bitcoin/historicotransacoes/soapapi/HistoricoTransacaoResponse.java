//
// Este arquivo foi gerado pela Arquitetura JavaTM para Implementação de Referência (JAXB) de Bind XML, v2.2.11 
// Consulte <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Todas as modificações neste arquivo serão perdidas após a recompilação do esquema de origem. 
// Gerado em: 2019.01.07 às 02:29:28 PM BRST 
//


package br.com.ciandt.bitcoin.historicotransacoes.soapapi;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Classe Java de anonymous complex type.
 * 
 * <p>O seguinte fragmento do esquema especifica o conteúdo esperado contido dentro desta classe.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="numeroCarteira" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="historicoTransacoes" type="{http://www.ciandt.com.br/xml/carteirabitcoin}Transacao" maxOccurs="unbounded"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "numeroCarteira",
    "historicoTransacoes"
})
@XmlRootElement(name = "HistoricoTransacaoResponse")
public class HistoricoTransacaoResponse {

    @XmlElement(required = true)
    protected String numeroCarteira;
    @XmlElement(required = true)
    protected List<Transacao> historicoTransacoes;

    /**
     * Obtém o valor da propriedade numeroCarteira.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNumeroCarteira() {
        return numeroCarteira;
    }

    /**
     * Define o valor da propriedade numeroCarteira.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNumeroCarteira(String value) {
        this.numeroCarteira = value;
    }

    /**
     * Gets the value of the historicoTransacoes property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the historicoTransacoes property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getHistoricoTransacoes().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Transacao }
     * 
     * 
     */
    public List<Transacao> getHistoricoTransacoes() {
        if (historicoTransacoes == null) {
            historicoTransacoes = new ArrayList<Transacao>();
        }
        return this.historicoTransacoes;
    }

	@Override
	public String toString() {
		return "HistoricoTransacaoResponse [numeroCarteira=" + numeroCarteira + ", historicoTransacoes="
				+ historicoTransacoes + "]";
	}
    
    

}
