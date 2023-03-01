package com.example.genpessosapi.resources;

import com.example.genpessosapi.entities.Endereco;
import com.example.genpessosapi.entities.Pessoa;
import com.example.genpessosapi.services.EnderecoService;
import com.example.genpessosapi.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/enderecos")
public class EnderecoResource {

    @Autowired
    private EnderecoService service;

    @GetMapping
    public ResponseEntity<List<Endereco>> findAll(){
        List<Endereco>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Endereco> findById(@PathVariable Long id){
        Endereco endereco = service.findById(id);
        return ResponseEntity.ok().body(endereco);
    }
    @PostMapping
    public ResponseEntity<Endereco> criarEndereco(@RequestBody Endereco endereco){
        endereco = service.criarEndereco(endereco);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(endereco);
    }
}
