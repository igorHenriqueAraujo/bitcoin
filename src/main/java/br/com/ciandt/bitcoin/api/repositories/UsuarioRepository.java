package br.com.ciandt.bitcoin.api.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ciandt.bitcoin.api.entities.UsuarioEntity;


@Transactional(readOnly = true)
public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
	UsuarioEntity findByLogin(String login);
}
