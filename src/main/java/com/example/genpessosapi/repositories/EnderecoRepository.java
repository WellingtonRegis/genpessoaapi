package com.example.genpessosapi.repositories;

import com.example.genpessosapi.entities.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

}
