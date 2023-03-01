package com.example.genpessosapi.config;

import com.example.genpessosapi.entities.Endereco;
import com.example.genpessosapi.entities.Pessoa;
import com.example.genpessosapi.repositories.EnderecoRepository;
import com.example.genpessosapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration
@Profile("test")
public class TestConfig implements CommandLineRunner {
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;


    @Override
    public void run(String... args) throws Exception {
        Pessoa pessoa1 = new Pessoa(null, "Miranda","10/06/1995");
        Pessoa pessoa2 = new Pessoa(null, "Morrigan","20/06/1990");
        Pessoa pessoa3 = new Pessoa(null, "Mari","18/09/1993");
        Pessoa pessoa4 = new Pessoa(null, "Matilda","15/11/1989");

        Endereco endereco1 = new Endereco(null,"rua joão aragão","65987-159","45",true, pessoa1);
        Endereco endereco2 = new Endereco(null,"rua joão aragão","65987-159","45",true, pessoa1);
        Endereco endereco3 = new Endereco(null,"rua joão aragão","65987-159","45",true, pessoa3);
        Endereco endereco4 = new Endereco(null,"rua joão aragão","65987-159","45",true, pessoa4);

        pessoaRepository.saveAll(Arrays.asList(pessoa1, pessoa2, pessoa3, pessoa4));
        enderecoRepository.saveAll(Arrays.asList(endereco1,endereco2,endereco3,endereco4));

    }

}
