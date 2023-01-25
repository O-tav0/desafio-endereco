package com.desafio.endereco.VO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EnderecoVO {
    private String logradouro;
    private String cep;
    private Integer numero;
    private String cidade;
    private Boolean enderecoPrincipal;
}
