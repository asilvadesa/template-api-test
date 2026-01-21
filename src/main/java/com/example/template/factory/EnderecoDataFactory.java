package com.example.template.factory;

import com.example.template.domain.Endereco;
import com.example.template.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class EnderecoDataFactory {

    @Autowired
    private EnderecoRepository enderecoRepository;

    public String buscaCepValido() {
        List<Endereco> enderecosList = enderecoRepository.buscaTodos();
        Collections.shuffle(enderecosList);
        return enderecosList.getFirst().getCep();
    }
}
