package com.example.template.secondary.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(schema = "public", name = "filme")
@Data
public class Filme {

    @Id
    private Long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "ano")
    private String ano;

    @Column(name = "diretor")
    private String diretor;

    @Column(name = "producao")
    private String producao;
}
