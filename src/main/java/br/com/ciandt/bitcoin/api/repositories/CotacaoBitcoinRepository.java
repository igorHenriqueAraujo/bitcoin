package br.com.ciandt.bitcoin.api.repositories;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ciandt.bitcoin.api.entities.CotacaoBitcoinEntity;

/**
 * Interface seguindo o padrão Repository do Spring Data.
 * Herda de JpaRepository, operações padrões de CRUD estão disponiveis na classe pai.
 * @author igorha
 *
 */
public interface CotacaoBitcoinRepository extends JpaRepository<CotacaoBitcoinEntity, Long> {
	
	/**
	 * Lista os registros de historico de cotação inserido entre duas datas (Normalmente o mesmo dia com horas diferente)
	 * Ex: 05/01/2019 00:00:00 a 05/01/2019 23:59:59
	 * @param start
	 * @param end
	 * @return
	 */
	List<CotacaoBitcoinEntity> findAllByDataHoraObtidaCotacaoBetween(LocalDateTime start, LocalDateTime end);

}
