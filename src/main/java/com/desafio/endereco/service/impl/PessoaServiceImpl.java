package com.desafio.endereco.service.impl;

import com.desafio.endereco.VO.AtualizaPessoaVO;
import com.desafio.endereco.VO.CriaPessoaVO;
import com.desafio.endereco.entity.Pessoa;
import com.desafio.endereco.repository.EnderecoRepository;
import com.desafio.endereco.repository.PessoaRepository;
import com.desafio.endereco.service.EnderecoService;
import com.desafio.endereco.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaServiceImpl implements PessoaService {

    @Autowired
    PessoaRepository pessoaRepository;

    @Autowired
    EnderecoServiceImpl enderecoService;

    @Override
    public void criarNovaPessoa(CriaPessoaVO criaPessoaVO) {

        Pessoa novaPessoa = preencheNovaPessoa(criaPessoaVO);
        Pessoa pessoaGerada = pessoaRepository.save(novaPessoa);

        enderecoService.adicionarEnderecoParaPessoa(criaPessoaVO.getEndereco(), pessoaGerada.getId());
    }

    @Override
    public Pessoa buscarPessoaPeloId(Long idPessoa) throws EntityNotFoundException{
        return pessoaRepository.findById(idPessoa).orElseThrow(EntityNotFoundException::new);
    }

    @Override
    public List<Pessoa> buscarTodasPessoas() {
        return (List<Pessoa>) pessoaRepository.findAll();
    }

    @Override
    public void atualizarPessoa(AtualizaPessoaVO vo, Long idPessoa) throws EntityNotFoundException {
        Pessoa pessoa = buscarPessoaPeloId(idPessoa);

        pessoa.setNome(vo.getNome());
        pessoa.setDataNascimento(vo.getDataNascimento());

        pessoaRepository.save(pessoa);
    }

    private Pessoa preencheNovaPessoa(CriaPessoaVO criaPessoaVO) {
        Pessoa novaPessoa = new Pessoa();

        novaPessoa.setNome(criaPessoaVO.getNome());
        novaPessoa.setDataNascimento(criaPessoaVO.getDataNascimento());

        return novaPessoa;
    }

}
