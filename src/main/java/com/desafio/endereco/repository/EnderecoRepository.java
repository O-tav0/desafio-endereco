package com.desafio.endereco.repository;

import com.desafio.endereco.entity.Endereco;
import com.desafio.endereco.entity.Pessoa;
import org.springframework.data.repository.CrudRepository;

public interface EnderecoRepository extends CrudRepository<Endereco, Long> {
    Endereco findByPessoaAndEnderecoPrincipal(Pessoa pessoa, String enderecoPrincipal);
}
