package com.example.template;

import com.example.template.factory.EnderecoDataFactory;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@SpringBootTest
class TemplateApiTestApplicationTests {

	@Autowired
	private EnderecoDataFactory enderecoDataFactory;

	@Test
	void validaBuscaCepComSucesso() {
		String cep = enderecoDataFactory.buscaCepValido();

		given().
			filters(new RequestLoggingFilter(), new ResponseLoggingFilter()).
			pathParam("cep",  cep).
		expect().
			statusCode(200).
			body("cep", is(cep)).
			body("city", notNullValue()).
		when().
			get("https://brasilapi.com.br/api/cep/v1/{cep}");
	}

}
