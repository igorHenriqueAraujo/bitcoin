package br.com.ciandt.bitcoin.api.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.ciandt.bitcoin.api.entities.enums.PerfilEnum;


@Entity
@Table(name = "USUARIO")
public class UsuarioEntity implements Serializable {

	private static final long serialVersionUID = 306411570471828345L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "LOGIN", nullable = false)
	private String login;
	
	@Column(name = "SENHA", nullable = false)
	private String senha;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "PERFIL", nullable = false)
	private PerfilEnum perfil;

	public UsuarioEntity() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public PerfilEnum getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilEnum perfil) {
		this.perfil = perfil;
	}
	
	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

}
