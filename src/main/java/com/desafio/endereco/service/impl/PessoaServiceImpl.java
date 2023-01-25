package com.desafio.endereco.service.impl;

import com.desafio.endereco.VO.CriaPessoaVO;
import com.desafio.endereco.entity.Pessoa;
import com.desafio.endereco.repository.EnderecoRepository;
import com.desafio.endereco.repository.PessoaRepository;
import com.desafio.endereco.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Override
    public void criarNovaPessoa(CriaPessoaVO criaPessoaVO) {
        Pessoa novaPessoa = preencheNovaPessoa(criaPessoaVO);
        pessoaRepository.save(novaPessoa);
    }

    @Override
    public Optional<Pessoa> buscarPessoaPeloId(Long idPessoa) {
        return pessoaRepository.findById(idPessoa);
    }

    private Pessoa preencheNovaPessoa(CriaPessoaVO criaPessoaVO) {
        Pessoa novaPessoa = new Pessoa();

        novaPessoa.setNome(criaPessoaVO.getNome());
        novaPessoa.setDataNascimento(criaPessoaVO.getDataNascimento());

        return novaPessoa;
    }
}
