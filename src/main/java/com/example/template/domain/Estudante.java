package com.example.template.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(schema = "public", name = "estudante")
@Data
public class Estudante {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "documento")
    private String documento;

    @Column(name = "data_nascimento")
    private Date dataNascimento;

    @Column(name = "nome_pai")
    private String nomePai;

    @Column(name = "nome_mae")
    private String nomeMae;

    @Column(name = "criado_em")
    private LocalDateTime dataCriacao;

}
