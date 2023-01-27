package com.desafio.endereco.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="TB_ENDERECO")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DS_LOGRADOURO")
    private String logradouro;

    @Column(name="DS_CEP")
    private String cep;

    @Column(name="NUMERO")
    private Integer numero;

    @Column(name="DS_CIDADE")
    private String cidade;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name="ID_PESSOA")
    private Pessoa pessoa;

    @Column(name="ST_ENDERECO_PRINCIPAL")
    private String enderecoPrincipal;

    public String converteEnderecoPrincipalParaString(Boolean enderecoPrincipal) {
        return enderecoPrincipal ? "S" : "N";
    }
}
