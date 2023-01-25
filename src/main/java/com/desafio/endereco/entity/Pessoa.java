package com.desafio.endereco.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="TB_PESSOA")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="DS_NOME_PESSOA")
    private String nome;

    @Column(name="DT_NASCIMENTO")
    private Date dataNascimento;

    @OneToMany(mappedBy="pessoa")
    private List<Endereco> enderecos;
}
