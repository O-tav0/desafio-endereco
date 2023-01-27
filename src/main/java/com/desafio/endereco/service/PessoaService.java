package com.desafio.endereco.service;

import com.desafio.endereco.VO.AtualizaPessoaVO;
import com.desafio.endereco.VO.CriaPessoaVO;
import com.desafio.endereco.entity.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaService {
    void criarNovaPessoa(CriaPessoaVO criaPessoaVO);
    Pessoa buscarPessoaPeloId(Long idPessoa);
    List<Pessoa> buscarTodasPessoas();
    void atualizarPessoa(AtualizaPessoaVO vo, Long idPessoa);
}
