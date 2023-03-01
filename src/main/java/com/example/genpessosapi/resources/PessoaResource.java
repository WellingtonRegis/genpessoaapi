package com.example.genpessosapi.resources;

import com.example.genpessosapi.entities.Pessoa;
import com.example.genpessosapi.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService service;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa>list = service.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Pessoa> findById(@PathVariable Long id){
        Pessoa pessoa = service.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        pessoa = service.criarPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        pessoa = service.editarPessoa(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }
}
