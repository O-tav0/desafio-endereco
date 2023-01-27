package com.desafio.endereco.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CriaPessoaVO {
    private String nome;
    private Date dataNascimento;
    private EnderecoVO endereco;
}
