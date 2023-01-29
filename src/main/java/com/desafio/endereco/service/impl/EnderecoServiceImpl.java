package com.desafio.endereco.service.impl;

import com.desafio.endereco.VO.EnderecoVO;
import com.desafio.endereco.entity.Endereco;
import com.desafio.endereco.entity.Pessoa;
import com.desafio.endereco.enums.DominioEnderecoPrincipal;
import com.desafio.endereco.enums.EnumDominioEnderecoPrincipal;
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

    @Override
    public Endereco buscarEnderecoPrincipalPessoa(Long idPessoa) {
        Pessoa pessoa = pessoaService.buscarPessoaPeloId(idPessoa);
        return enderecoRepository.findByPessoaAndEnderecoPrincipal(pessoa, new DominioEnderecoPrincipal(EnumDominioEnderecoPrincipal.SIM).getValorEmPortugues());
    }


    private Endereco preencheNovoEndereco(EnderecoVO vo, Long idPessoa) throws EntityNotFoundException {
        Endereco novoEndereco = new Endereco();
        Pessoa pessoa = pessoaService.buscarPessoaPeloId(idPessoa);

        novoEndereco.setPessoa(pessoa);
        novoEndereco.setLogradouro(vo.getLogradouro());
        novoEndereco.setCidade(vo.getCidade());
        novoEndereco.setCep(vo.getCep());
        novoEndereco.setNumero(vo.getNumero());

        if(existeEnderecoPrincipalParaPessoa(idPessoa)) {
            novoEndereco.setEnderecoPrincipal(new DominioEnderecoPrincipal(EnumDominioEnderecoPrincipal.NAO).getValorEmPortugues());
        } else {
            novoEndereco.setEnderecoPrincipal(new DominioEnderecoPrincipal(EnumDominioEnderecoPrincipal.SIM).getValorEmPortugues());
        }

        return novoEndereco;
    }

    private Boolean existeEnderecoPrincipalParaPessoa(Long idPessoa) throws EntityNotFoundException{
        Pessoa pessoa = pessoaService.buscarPessoaPeloId(idPessoa);
        Boolean existeEnderecoPrincipal = false;

        if(pessoa.getEnderecos() != null) {
            for(Endereco endereco: pessoa.getEnderecos()) {
                if(endereco.getEnderecoPrincipal().equals(new DominioEnderecoPrincipal(EnumDominioEnderecoPrincipal.SIM).getValorEmPortugues())) {
                    existeEnderecoPrincipal = true;
                }
            }
        }

        return existeEnderecoPrincipal;
    }
}
