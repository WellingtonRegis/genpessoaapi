package com.example.genpessosapi.services;

import com.example.genpessosapi.entities.Endereco;
import com.example.genpessosapi.entities.Pessoa;
import com.example.genpessosapi.repositories.PessoaRepository;
import com.example.genpessosapi.services.exceptions.PessoaNotFoundException;
import jakarta.persistence.EntityNotFoundException;
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
        return pessoa.orElseThrow(() -> new PessoaNotFoundException(id));
    }

    public Pessoa criarPessoa(Pessoa pessoa){
        return repository.save(pessoa);
    }

    public Pessoa editarPessoa(Long id, Pessoa pessoa){
        try {
            Pessoa entity = repository.getReferenceById(id);
            updateData(entity, pessoa);
            return repository.save(entity);
        }catch (EntityNotFoundException e){
            throw new PessoaNotFoundException(id);
        }
    }

    private void updateData(Pessoa entity, Pessoa pessoa) {
        entity.setNomeCompleto(pessoa.getNomeCompleto());
        entity.setDataNascimento(pessoa.getDataNascimento());
    }

    public Endereco criarEndereco(Endereco enderecos) {
        return enderecos;
    }
}
