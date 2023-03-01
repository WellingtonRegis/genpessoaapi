package com.example.genpessosapi.resources;

import com.example.genpessosapi.entities.Endereco;
import com.example.genpessosapi.entities.Pessoa;
import com.example.genpessosapi.repositories.EnderecoRepository;
import com.example.genpessosapi.repositories.PessoaRepository;
import com.example.genpessosapi.services.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/pessoas")
public class PessoaResource {

    @Autowired
    private PessoaService pessoaService;
    @Autowired
    private PessoaRepository pessoaRepository;

    @Autowired
    private EnderecoRepository enderecoRepository;

    @GetMapping
    public ResponseEntity<List<Pessoa>> findAll(){
        List<Pessoa>list = pessoaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Optional<Pessoa>> findById(@PathVariable Long id){
        Optional<Pessoa> pessoa = pessoaRepository.findById(id);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping(value = "/{criarnovapessoa}")
    public ResponseEntity<Pessoa> criarPessoa(@RequestBody Pessoa pessoa){
        pessoa = pessoaService.criarPessoa(pessoa);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(pessoa.getId()).toUri();
        return ResponseEntity.created(uri).body(pessoa);
    }

    @PutMapping(value = "/atualizar/{id}")
    public ResponseEntity<Pessoa> editarPessoa(@PathVariable Long id, @RequestBody Pessoa pessoa){
        pessoa = pessoaService.editarPessoa(id, pessoa);
        return ResponseEntity.ok().body(pessoa);
    }

    @PostMapping("/{id}/endereco")
    @ResponseStatus(HttpStatus.CREATED)
    public Endereco criarEndereco(@PathVariable Long id, @RequestBody Endereco endereco) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
        endereco.setPessoa(pessoa);
        return enderecoRepository.save(endereco);
    }

    @GetMapping("/{id}/enderecos")
    public List<Endereco> listarEnderecos(@PathVariable Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Pessoa não encontrada"));
        return pessoa.getEnderecos();
    }
}
