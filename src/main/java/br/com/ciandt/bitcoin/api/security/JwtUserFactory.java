package br.com.ciandt.bitcoin.api.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import br.com.ciandt.bitcoin.api.entities.UsuarioEntity;
import br.com.ciandt.bitcoin.api.entities.enums.PerfilEnum;

/**
 * 
 * @author igorha
 *
 */
public final class JwtUserFactory {

    private JwtUserFactory() {
    }

    public static JwtUser create(UsuarioEntity user) {
        return new JwtUser(
                user.getId(),
                user.getLogin(),
                user.getSenha(),
                mapToGrantedAuthorities(user.getPerfil())
        );
    }

    private static List<GrantedAuthority> mapToGrantedAuthorities(PerfilEnum perfil) {
    	SimpleGrantedAuthority authority = new SimpleGrantedAuthority(perfil.toString());
    	List<GrantedAuthority> retorno = new ArrayList<GrantedAuthority>();
    	retorno.add(authority);
        return retorno;
    }
}
