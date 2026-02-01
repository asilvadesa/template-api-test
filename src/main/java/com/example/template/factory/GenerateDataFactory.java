package com.example.template.factory;

import com.example.template.primary.entity.Endereco;
import com.example.template.primary.repository.EnderecoRepository;
import com.example.template.secondary.entity.Filme;
import com.example.template.secondary.repository.FilmeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class GenerateDataFactory {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @Autowired
    private FilmeRepository filmeRepository;

    public String buscaCepValido() {
        List<Endereco> enderecosList = enderecoRepository.buscaTodos();
        Collections.shuffle(enderecosList);
        return enderecosList.getFirst().getCep();
    }

    public List<Filme> buscaTodosFilmes() {
        return filmeRepository.findAll();
    }

}
