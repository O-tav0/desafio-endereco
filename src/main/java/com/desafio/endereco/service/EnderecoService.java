package com.desafio.endereco.service;

import com.desafio.endereco.VO.EnderecoVO;
import com.desafio.endereco.entity.Endereco;

import javax.persistence.EntityNotFoundException;

public interface EnderecoService {
    public void adicionarEnderecoParaPessoa(EnderecoVO vo, Long idPessoa);
    public Endereco buscarEnderecoPrincipalPessoa(Long idPessoa);
}
