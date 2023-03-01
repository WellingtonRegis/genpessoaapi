package com.example.genpessosapi.services;

import com.example.genpessosapi.entities.Endereco;
import com.example.genpessosapi.repositories.EnderecoRepository;
import com.example.genpessosapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {

    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private PessoaRepository pessoaRepository;

    public List<Endereco> findAll(){
        return repository.findAll();
    }

    public Endereco findById(Long id){
        Optional<Endereco> endereco = repository.findById(id);
        return endereco.get();
    }


    public Endereco criarEndereco(Endereco endereco){
        return repository.save(endereco);
    }
}
