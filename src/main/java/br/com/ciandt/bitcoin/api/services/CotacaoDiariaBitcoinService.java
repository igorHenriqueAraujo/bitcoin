package br.com.ciandt.bitcoin.api.services;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.builder.GenericBuilder;
import br.com.ciandt.bitcoin.api.dtos.HistoricoCotacaoBitconDTO;
import br.com.ciandt.bitcoin.api.entities.CotacaoBitcoinEntity;
import br.com.ciandt.bitcoin.api.repositories.CotacaoBitcoinRepository;

@Service
public class CotacaoDiariaBitcoinService {
	
	private static LocalTime ULTIMA_HORA_DO_DIA = LocalTime.of(23, 59, 59);
	
	@Autowired
	private CotacaoBitcoinRepository cotacaoBitcoinRepository;
	
	/**
	 * Salva o valor da cotacao na base de dados.
	 * @param valorCotacao
	 * @return
	 */
	public CotacaoBitcoinEntity save(BigDecimal valorCotacao) {
		
		CotacaoBitcoinEntity entity = new CotacaoBitcoinEntity();
		entity.setValor(valorCotacao);
		CotacaoBitcoinEntity saved = cotacaoBitcoinRepository.save(entity);
		
		return saved;
	}
	
	/**
	 * Recupera o histórico de cotações obtidas durante o dia informado.
	 * @param diaInformado
	 * @return
	 */
	public List<HistoricoCotacaoBitconDTO> listaHistoricoCotacaoBitcoinDia(LocalDate diaInformado){
		
		List<CotacaoBitcoinEntity> listaBase = cotacaoBitcoinRepository.findAllByDataHoraObtidaCotacaoBetween(diaInformado.atStartOfDay(), diaInformado.atTime(ULTIMA_HORA_DO_DIA));
		List<HistoricoCotacaoBitconDTO> resultado = new ArrayList<HistoricoCotacaoBitconDTO>();
		listaBase.parallelStream().forEach(cotacao -> resultado.add(converteObjeto(cotacao)));
		
		return resultado;
	}
	
	private HistoricoCotacaoBitconDTO converteObjeto(CotacaoBitcoinEntity cotacao) {
		
		HistoricoCotacaoBitconDTO historicoDTO = GenericBuilder.of(HistoricoCotacaoBitconDTO::new)
		.with(HistoricoCotacaoBitconDTO::setHoraObtidaCotacao, cotacao.getDataHoraObtidaCotacao().toLocalTime())
		.with(HistoricoCotacaoBitconDTO::setValorCotacao, cotacao.getValor())
		.build();
		
		return historicoDTO;
	}

}
