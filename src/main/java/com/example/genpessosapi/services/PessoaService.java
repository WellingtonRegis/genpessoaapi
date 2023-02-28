package com.example.genpessosapi.services;

import com.example.genpessosapi.entities.Pessoa;
import com.example.genpessosapi.repositories.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {
    @Autowired
    private PessoaRepository repository;

    public List<Pessoa> findAll(){
        return repository.findAll();
    }

    public Pessoa findById(Long id){
        Optional<Pessoa> pessoa = repository.findById(id);
        return pessoa.get();
    }
}
