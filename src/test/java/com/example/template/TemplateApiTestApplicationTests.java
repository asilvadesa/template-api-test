package com.example.template;

import com.example.template.repository.EstudanteRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TemplateApiTestApplicationTests {

	@Autowired
	private EstudanteRepository estudanteRepository;
	@Test
	void contextLoads() {
		System.out.println(estudanteRepository.getList());
	}

}
