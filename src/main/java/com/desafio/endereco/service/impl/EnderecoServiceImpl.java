package com.desafio.endereco.service.impl;

import com.desafio.endereco.VO.EnderecoVO;
import com.desafio.endereco.entity.Endereco;
import com.desafio.endereco.entity.Pessoa;
import com.desafio.endereco.repository.EnderecoRepository;
import com.desafio.endereco.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
public class EnderecoServiceImpl implements EnderecoService {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private PessoaServiceImpl pessoaService;

    @Override
    public void adicionarEnderecoParaPessoa(EnderecoVO vo, Long idPessoa) throws EntityNotFoundException {
        
        Endereco endereco = preencheNovoEndereco(vo, idPessoa);
        enderecoRepository.save(endereco);
    }

    private Endereco preencheNovoEndereco(EnderecoVO vo, Long idPessoa) throws EntityNotFoundException {
        Endereco novoEndereco = new Endereco();
        Pessoa pessoa = pessoaService.buscarPessoaPeloId(idPessoa).orElseThrow(EntityNotFoundException::new);

        novoEndereco.setPessoa(pessoa);
        novoEndereco.setLogradouro(vo.getLogradouro());
        novoEndereco.setCep(vo.getCep());
        novoEndereco.setNumero(vo.getNumero());
        novoEndereco.setEnderecoPrincipal(novoEndereco.isEnderecoPrincipal(vo.getEnderecoPrincipal()));

        return novoEndereco;
    }
}
