package br.com.ciandt.bitcoin.api.config.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Classe de configuração para o framwork Swagger, 
 * responsável por criar uma documentação visual da API.
 * @author igorha
 *
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {
	
	/**
	 * Criação do Bean que executará o swagger com suas configurações básicas.
	 * @return
	 */
	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("br.com.ciandt.bitcoin"))
				.paths(PathSelectors.any()).build().apiInfo(apiInfo());
	}
	
	/**
	 * Construtor de informações básicas da API.
	 * @return
	 */
	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("API Bitcoin - Desafio CI&T")
				.description("Documentação da API utilizando Swagger")
				.version("1.0").build();
	}

}
