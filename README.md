# genpessoaapi
Está é uma API para gerenciar pessoas, com ela será possível criar, editar, consultar e listar uma pessoa em um banco de dados. (Por regra de negócio o projeto usa por padrão o Banco de Dados H2 do Spring, uma banco em memória que toda vez que a aplicação rodar o dados que foram inseridos e editados, serão apagados assim que a aplicação parar de rodar).

É uma API bem simples ela consiste em Criar uma pessoa, que tem os seguintes atributos:

    • Id da pessoa ( esse Id é gerado pelo próprio banco de dados H2);
    
    • Nome da pessoa que vai ser cadastrada no banco (Deve se passar o nome completo da pessoa);
    
    • Data de nascimento da pessoa( exemplo "dd/MM/yyyy" "13/08/1990";
    
Está pessoa possue um endereço e nesse endereço alguns atributos devem ser passados.

    • Id do endereço (gerado pelo Banco de Dados);
    
    • Logradouro (Nome da rua onde a pessoa reside);
    
    • CEP da rua onde a pessoa reside;
    
    • Número da residência da pessoa;
    
    • Id da pessoa para identificar quem é a pessoa correspondente ao Id;
    
    • Endereço principal ( caso a pessoa possua mais de um endereço, o primeiro endereço que a pessoa registrar na hora que for cadastrar, por padrão     ficará como endereço principal dessa pessoa.).
    
    Está API fornece alguns Endpoints para realizar determinadas operações, buscar uma lista de pessoas, consultar uma pessoa pelo ID, editar uma os dados da pessoa e criar uma nova pessoa para por no sistema. Assim como também disponibiliza endpoints para realizar as seguintes operações, criar um novo endereço para uma pessoa ja cadastrada caso ela possua mais de um endereço, listar todos os endereços de uma pessoa( caso a mesma possua mais de um endereço, e por fim informar ao usuario do sistema qual dos endereços listados é o principal da pessoa.
    
    ENDPOINTS PESSOA:
    * GET HTTPS://localhost:8080/pessoas - Para listar todas as pessoas;
    
    * GET HTTPS://localhost:8080/pessoas/id - Para listar uma pessoa pelo seu ID;
    
    * POST HTTPS://localhost:8080/pessoas/criarnovapessoa - Para criar uma nova pessoa;
    
    * PUT HTTPS://localhost:8080/pessoas/atualizarpessoa/id - Para atualizar os dados de uma pessoa;
    
    ENDPOINTS ENDEREÇO:
    * GET HTTPS://localhost:8080/enderecos - para listar todos os endereços;
    
    * POST HTTPS://localhost:8080/enderecos/novoendereco - para adicionar o novo endereço de uma pessoa;
    
    * GET HTTPS://localhost:8080/enderecos/id - Para buscar todos os endereços de uma pessoa;
    
    * GET HTTPS://localhost:8080/endereco/principal - Para buscar o endereço principal da pessoa que possuir mais de um endereço;
    
    A API usa como Banco de Dados o H2 do Spring Boot, um Banco de Dados em memória, para ter acesso a esse banco o usuário do sistema deve ter agregado     ao projeto, o Arquivo: application.properties com a seguinte anotação inserida:
    
    # DATASOURCE

spring.profiles.active=test


spring.jpa.open-in-view=true


E em seguida o seguinte arquivo também agregado ao projeto application-test.properties, com as seguintes anotações:

# DATASOURCE
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.username=sa
spring.datasource.password=
# H2 CLIENT
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
# JPA, SQL
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect
spring.jpa.defer-datasource-initialization=true
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

# ATENÇÃO!
Para que o projeto funcione certifique-se de ter instalado no seu sistema Java Jdk 17, as dependências do Spring Boot: Starter Web, Data JPA e H2. Essas são as 3 dependências básicas para que a aplicação funcione.
Para poder testar os endpoints da aplicação deve ter a ferramenta Postman instalado e através dela fazer as chamadas Rest.
E uma IDE de sua preferência, Eclipse, Intellij-EDEA, VS-Code entre outras.
# IMPORTANTE
tenha as seguintes dependencias em seu projeto para que possa ter um bom funcionamento dos recursos REST
<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-data-jpa</artifactId>
		</dependency>
    
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>
    
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>


    
    
