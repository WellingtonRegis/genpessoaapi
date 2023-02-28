package com.example.genpessosapi.repositories;

import com.example.genpessosapi.entities.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
