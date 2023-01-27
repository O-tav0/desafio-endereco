package com.desafio.endereco.controller;

import com.desafio.endereco.VO.CriaPessoaVO;
import com.desafio.endereco.VO.EnderecoVO;
import com.desafio.endereco.VO.RespostaVO;
import com.desafio.endereco.entity.Endereco;
import com.desafio.endereco.service.impl.EnderecoServiceImpl;
import com.desafio.endereco.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;

@RestController()
@RequestMapping("/endereco")
public class EnderecoController {

    @Autowired
    EnderecoServiceImpl enderecoService;


    @PostMapping(path="/adicionar-endereco-pessoa/{idPessoa}")
    public ResponseEntity<RespostaVO> adicionarEndereco(@RequestBody EnderecoVO vo, @PathVariable Long idPessoa) {
        RespostaVO resposta = new RespostaVO();
        try {
            enderecoService.adicionarEnderecoParaPessoa(vo, idPessoa);
            resposta.setMensagem("Endereço adicionado com sucesso!");
            return ResponseEntity.ok(resposta);
        } catch(EntityNotFoundException enf) {
            resposta.setMensagem("Não existe pessoa com o número informado!");
            return ResponseEntity.badRequest().body(resposta);
        } catch(Exception e) {
            resposta.setMensagem("Houve algum problema ao adicionar o endereço!");
            return ResponseEntity.internalServerError().body(resposta);
        }
    }

    @GetMapping(path="/{idPessoa}/buscar-endereco-principal")
    public ResponseEntity<RespostaVO> buscarEnderecoPrincipal(@PathVariable Long idPessoa) {
        RespostaVO resposta = new RespostaVO();
        try {
            Endereco endereco = enderecoService.buscarEnderecoPrincipalPessoa(idPessoa);
            resposta.setResposta(endereco);
            return ResponseEntity.ok(resposta);
        } catch(EntityNotFoundException enf) {
            resposta.setMensagem("Não existe pessoa com o número informado!");
            return ResponseEntity.badRequest().body(resposta);
        } catch(Exception e) {
            resposta.setMensagem("Houve algum problema ao adicionar o endereço!");
            return ResponseEntity.internalServerError().body(resposta);
        }
    }
}
