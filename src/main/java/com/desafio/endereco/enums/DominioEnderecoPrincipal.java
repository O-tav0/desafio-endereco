package com.desafio.endereco.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class DominioEnderecoPrincipal {

    private EnumDominioEnderecoPrincipal isEnderecoPrincipal;

    public String getValorEmPortugues() {
        return this.isEnderecoPrincipal ==  EnumDominioEnderecoPrincipal.SIM ? "S" : "N";
    }
}
