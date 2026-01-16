package com.example.template.repository;

import com.example.template.domain.Estudante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EstudanteRepository extends JpaRepository<Estudante, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM ESTUDANTE")
    List<Estudante> getList();

}
