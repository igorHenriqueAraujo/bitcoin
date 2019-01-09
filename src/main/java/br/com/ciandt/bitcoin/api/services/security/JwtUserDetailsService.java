package br.com.ciandt.bitcoin.api.services.security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.ciandt.bitcoin.api.entities.UsuarioEntity;
import br.com.ciandt.bitcoin.api.security.JwtUserFactory;
import br.com.ciandt.bitcoin.api.services.UsuarioService;

@Service
public class JwtUserDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UsuarioEntity> usuario = usuarioService.buscarPorLogin(username);

        if (!usuario.isPresent()) {
            throw new UsernameNotFoundException(String.format("Nenhum usuario encontrado com login: '%s'.", username));
        } else {
            return JwtUserFactory.create(usuario.get());
        }
    }
}
