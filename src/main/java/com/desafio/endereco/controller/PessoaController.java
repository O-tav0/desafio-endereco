package com.desafio.endereco.controller;

import com.desafio.endereco.VO.CriaPessoaVO;
import com.desafio.endereco.VO.RespostaVO;
import com.desafio.endereco.service.impl.PessoaServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
