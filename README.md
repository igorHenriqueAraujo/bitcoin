[![Build Status](https://travis-ci.org/igorHenriqueAraujo/bitcoin.svg?branch=master)](https://travis-ci.org/igorHenriqueAraujo/bitcoin)
# bitcoin-api

## Desafio Bitcoin

Projeto demonstração de aplicação de tecnologias.

## Executando para testes

Para teste full das funcionalidades é necessário startar os projetos de apoio e depois startar o projeto principal.  
Nessário ter o Java 8 instalado na máquina que vai executar.  
Pode ser realizado através de linha de comando utilizando o plugin do spring-boot do maven como abaixo.


	./mvnw spring-boot:run


Não é necessário ter o maven instalado uma vez que os projetos spring-boot trazem o maven encapsulado (wrapper) para execução em qualquer máquina com JDK instalado.

Ou pode ser executado, também via linha de comando, o build dos projetos com maven e posterior start utilizando java como no exemplo abaixo.


	./mvnw clean package -DskipTests=true
	java -jar target/<nome_do_pacote.jar>


Os projetos de apoio se encontram na pasta projetos-apoio. Os comando devem ser executados como no exemplo dentro da pasta de cada projeto em terminais diferentes.  

## PS: Docker: Executando as aplicações com docker

Adicionado feature para execução de todos os projetos utilizando o docker. Para isso ainda é necessário entrar na pasta de cada projeto e executar o comando abaixo para build.


	./mvnw clean package -DskipTests=true


Após isso executar, dentro da pasta principal do projeto, o comando abaixo: (Assumindo que possua o docker instalado)


	docker-compose up --build


O docker irá construir as imagens de cada projeto de apoio e do projeto principal e em seguida irá iniciar os containers dos projetos de apoio e por ultimo da aplicação principal.  
É possível verificar na execução com docker que a aplicação inicia com profile 'docker' para obter propriedades de conexão com os projetos de apoio que são diferentes de quando executado localmente.  
Para isso há um novo arquivo .properties dentro da aplicação que identifica as propriedades para esse profile.
	
## PS: Travis-CI + Heroku (Integração contínua com deploy automático)

Foi realizado uma nova integração do Travis-CI com o Heroku via build job para deploy automático, por isso a URL para acesso da aplicação no Heroku teve de ser alterada.

Novo link para acesso a aplicação deployada no Heroku.

[Bitcoin-API](https://igoraraujo-bitcoin.herokuapp.com/bitcoin/swagger-ui.html "Aplicação deployada no Heroku") 

Lembrando que a URL leva até a página do Swagger, por ser a única URL visual dentro da aplicação.  

## PS: Segurança da API com Spring Security + JWT (Jason Web Tokens)

Adicionado a aplicação implementação de segurança da API com autenticação e permissões definidas em ROLES.  

É necessário que, antes de usar qualquer endpoint da API, execute uma autenticação chamando o endpoint de autenticação /auth como exemplo abaixo.  
<http://localhost:8080/bitcoin/auth>  
Deve-se executar uma chamda POST passando JSON com o Request informando usuário e senha como exemplo abaixo.  

	curl -d '{"username":"admin", "password":"admin"}' -H "Content-Type: application/json" -X POST http://localhost:8080/bitcoin/auth

Três usuários com perfis diferentes são inseridos na base de dados ao iniciar a aplicação. Pode-se fazer autenticação com qualquer um dos três.

**Usuário:** admin  
**Senha:** admin  
**Perfil:** ADMIN  


**Usuário:** usuario  
**Senha:** senha  
**Perfil:** USUARIO

**Usuário:** leitor  
**Senha:** senha  
**Perfil:** LEITOR  

A aplicação retornará um objeto JSON com o atributo _token_, esse token deve ser enviado via Header para informar a autenticação.  
Adicionar o seguinte Header na requisição:  
**Authorization**  
Com o value dessa forma: Bearer _{token}_. Exemplo abaixo.


	curl --header "Authorization: Bearer eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJsZWl0b3IiLCJleHAiOjE1NDc2NTY5MjIsImlhdCI6MTU0NzA1MjEyMn0.hBoX_G7foDUDbCIU2xTZROXGA4r0bhFALuKolt2LSvrFwvfip-Yg1z614IO2bxIhnxGBNYzwWMCsnChmWIwAWA" http://localhost:8080/bitcoin/api/cotacao/historico


Os endpoints estão com a seguinte segurança.

_/api/cotacao/historico_ - Pode ser acessado por qualquer usuário logado  
_/api/transacoes/historico/{carteira}_ - Pode ser acessado por usuários com perfil **USER** ou **ADMIN**  
_/api/lucro/{carteira}_ e _api/valorinvestido/{carteira}_ - Só podem ser acessados por usuários com perfil **ADMIN**  