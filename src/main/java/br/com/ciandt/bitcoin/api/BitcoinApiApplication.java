package br.com.ciandt.bitcoin.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import br.com.ciandt.bitcoin.api.builder.GenericBuilder;
import br.com.ciandt.bitcoin.api.entities.UsuarioEntity;
import br.com.ciandt.bitcoin.api.entities.enums.PerfilEnum;
import br.com.ciandt.bitcoin.api.repositories.UsuarioRepository;
import br.com.ciandt.bitcoin.api.utils.SenhaUtils;

@SpringBootApplication
@EnableScheduling
public class BitcoinApiApplication {
	
	@Autowired
	private UsuarioRepository usuarioRepository;

	public static void main(String[] args) {
		SpringApplication.run(BitcoinApiApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> { UsuarioEntity usuario = GenericBuilder.of(UsuarioEntity::new)
				.with(UsuarioEntity::setLogin, "admin")
				.with(UsuarioEntity::setSenha, SenhaUtils.gerarBCrypt("admin"))
				.with(UsuarioEntity::setPerfil, PerfilEnum.ROLE_ADMIN)
				.build();
		usuarioRepository.save(usuario);
		
		UsuarioEntity usuario2 = GenericBuilder.of(UsuarioEntity::new)
				.with(UsuarioEntity::setLogin, "usuario")
				.with(UsuarioEntity::setSenha, SenhaUtils.gerarBCrypt("senha"))
				.with(UsuarioEntity::setPerfil, PerfilEnum.ROLE_USUARIO)
				.build();
		
		usuarioRepository.save(usuario2);
		
		UsuarioEntity usuario3 = GenericBuilder.of(UsuarioEntity::new)
				.with(UsuarioEntity::setLogin, "leitor")
				.with(UsuarioEntity::setSenha, SenhaUtils.gerarBCrypt("senha"))
				.with(UsuarioEntity::setPerfil, PerfilEnum.ROLE_LEITOR)
				.build();
		
		usuarioRepository.save(usuario3);
		};
	}
}

