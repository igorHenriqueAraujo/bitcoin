package br.com.ciandt.bitcoin.api.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.entities.UsuarioEntity;
import br.com.ciandt.bitcoin.api.repositories.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Optional<UsuarioEntity> buscarPorLogin(String login) {
		return Optional.ofNullable(this.usuarioRepository.findByLogin(login));
	}
}
