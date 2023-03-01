package com.example.genpessosapi.resources;

import com.example.genpessosapi.entities.Endereco;
import com.example.genpessosapi.entities.Pessoa;
import com.example.genpessosapi.repositories.EnderecoRepository;
import com.example.genpessosapi.repositories.PessoaRepository;
import com.example.genpessosapi.services.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/endereco")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;



    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping(value = "/novoendereco/{id}")
    public ResponseEntity<Pessoa> criarEndereco(@RequestBody Endereco enderecos, Pessoa pessoa){
        enderecos = service.criarEndereco(enderecos);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(enderecos.getId()).toUri();
        return ResponseEntity.created(uri).body(enderecos.getPessoa(pessoa));
    }

}
