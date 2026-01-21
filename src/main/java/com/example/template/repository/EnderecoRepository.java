package com.example.template.repository;

import com.example.template.domain.Endereco;
import com.example.template.domain.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ENDERECO")
    List<Estudante> buscaTodos();
}
