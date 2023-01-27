package com.desafio.endereco.controller;

import com.desafio.endereco.VO.AtualizaPessoaVO;
import com.desafio.endereco.VO.CriaPessoaVO;
import com.desafio.endereco.VO.RespostaVO;
import com.desafio.endereco.entity.Pessoa;
import com.desafio.endereco.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController()
@RequestMapping("/pessoa")
public class PessoaController {

    @Autowired
    PessoaServiceImpl pessoaService;

    @PostMapping(path="/nova")
    public ResponseEntity<RespostaVO> criarNovaPessoa(@RequestBody CriaPessoaVO vo) {
        RespostaVO resposta = new RespostaVO();
        try {
            pessoaService.criarNovaPessoa(vo);
            resposta.setMensagem("Pessoa criada com sucesso!");
            return ResponseEntity.ok(resposta);
        }catch(Exception e) {
            resposta.setMensagem("Houve algum problema ao criar a pessoa!");
            return ResponseEntity.internalServerError().body(resposta);
        }
    }

    @GetMapping(path="/{idPessoa}/enderecos")
    public ResponseEntity<RespostaVO> listarEnderecosPessoa(@PathVariable Long idPessoa) {
        RespostaVO resposta = new RespostaVO();
        try {
            Pessoa pessoa = pessoaService.buscarPessoaPeloId(idPessoa);
            resposta.setResposta(pessoa.getEnderecos());
            return ResponseEntity.ok(resposta);
        } catch(EntityNotFoundException enf) {
            resposta.setMensagem("Não existe pessoa com o número informado!");
            return ResponseEntity.badRequest().body(resposta);
        }
        catch(Exception e) {
            resposta.setMensagem("Houve algum problema ao criar a pessoa!");
            return ResponseEntity.internalServerError().body(resposta);
        }
    }

    @GetMapping(path="/todas")
    public ResponseEntity<RespostaVO> listarPessoas() {
        RespostaVO resposta = new RespostaVO();
        try {
            List<Pessoa> pessoas = pessoaService.buscarTodasPessoas();
            resposta.setResposta(pessoas);
            return ResponseEntity.ok(resposta);
        } catch(Exception e) {
            resposta.setMensagem("Houve algum problema ao criar a pessoa!");
            return ResponseEntity.internalServerError().body(resposta);
        }
    }

    @GetMapping(path="/{idPessoa}")
    public ResponseEntity<RespostaVO> buscarPessoa(@PathVariable Long idPessoa) {
        RespostaVO resposta = new RespostaVO();
        try {
            Pessoa pessoa = pessoaService.buscarPessoaPeloId(idPessoa);
            resposta.setResposta(pessoa);
            return ResponseEntity.ok(resposta);
        } catch(Exception e) {
            resposta.setMensagem("Houve algum problema ao criar a pessoa!");
            return ResponseEntity.internalServerError().body(resposta);
        }
    }

    @PutMapping(path="/{idPessoa}/atualizar")
    public ResponseEntity<RespostaVO> atualizarPessoa(@RequestBody AtualizaPessoaVO atualizaPessoaVO, @PathVariable Long idPessoa) {
        RespostaVO resposta = new RespostaVO();
        try {
            pessoaService.atualizarPessoa(atualizaPessoaVO, idPessoa);
            resposta.setMensagem("Pessoa atualizada com sucesso!");
            return ResponseEntity.ok(resposta);
        } catch(Exception e) {
            resposta.setMensagem("Houve algum problema ao criar a pessoa!");
            return ResponseEntity.internalServerError().body(resposta);
        }
    }

}
