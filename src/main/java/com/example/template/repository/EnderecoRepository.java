package com.example.template.repository;

import com.example.template.domain.Endereco;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EnderecoRepository extends JpaRepository<Endereco, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ENDERECO")
    List<Endereco> buscaTodos();
}
