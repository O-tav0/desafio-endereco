package com.desafio.endereco.service;

import com.desafio.endereco.VO.CriaPessoaVO;
import com.desafio.endereco.entity.Pessoa;

import java.util.Optional;

public interface PessoaService {
    void criarNovaPessoa(CriaPessoaVO criaPessoaVO);
    Optional<Pessoa> buscarPessoaPeloId(Long idPessoa);
}
