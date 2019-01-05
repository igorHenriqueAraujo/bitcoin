package br.com.ciandt.bitcoin.api.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.Table;

import br.com.ciandt.bitcoin.api.entities.enums.TipoMoedaEnum;

@Entity
@Table(name="COTACAO_BITCOIN")
public class CotacaoBitcoinEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8372140243242072688L;
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	@Column(name = "DATA_HORA_OBTIDA_COTACAO", nullable = false)
	private LocalDateTime dataHoraObtidaCotacao;
	
	@Column(name = "VALOR", precision = 12, scale = 2, nullable = false)
	private BigDecimal valor;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "TIPO_MOEDA", nullable= false)
	private TipoMoedaEnum tipoMoeda;
	
    @PrePersist
    public void prePersist() {
        this.dataHoraObtidaCotacao = LocalDateTime.now();
        this.tipoMoeda = TipoMoedaEnum.REAL;
    }


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraObtidaCotacao() {
		return dataHoraObtidaCotacao;
	}

	public void setDataHoraObtidaCotacao(LocalDateTime dataHoraObtidaCotacao) {
		this.dataHoraObtidaCotacao = dataHoraObtidaCotacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public TipoMoedaEnum getTipoMoeda() {
		return tipoMoeda;
	}

	public void setTipoMoeda(TipoMoedaEnum tipoMoeda) {
		this.tipoMoeda = tipoMoeda;
	}

	@Override
	public String toString() {
		return "CotacaoBitcoinEntity [id=" + id + ", dataHoraObtidaCotacao=" + dataHoraObtidaCotacao + ", valor="
				+ valor + ", tipoMoeda=" + tipoMoeda + "]";
	}
	
	

}
