package com.desafio.endereco.repository;

import com.desafio.endereco.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface PessoaRepository extends CrudRepository<Pessoa, Long> {
}
