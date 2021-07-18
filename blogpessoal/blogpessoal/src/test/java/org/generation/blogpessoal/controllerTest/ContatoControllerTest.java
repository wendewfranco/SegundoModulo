package org.generation.blogpessoal.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.generation.blogpessoal.model.Contato;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContatoControllerTest {
	
	@Autowired
	private TestRestTemplate testRestTemplate;
	
	private Contato contato;
	
	private Contato contatoupd;
	
	@BeforeAll
	public void start() {
		contato = new Contato(null,"Maria", "21y", "2145785412");
		contatoupd = new Contato(2L,"Maria da silva", "21", "2145789865");
		
	}


	@Test
	public void deveRealizarPostContatos() {
		
		HttpEntity<Contato> request = new HttpEntity<Contato>(contato);
		
		ResponseEntity<Contato> resposta = testRestTemplate
				.exchange("/contatos/inserir", HttpMethod.POST, request, Contato.class);
				assertEquals(HttpStatus.CREATED, resposta.getStatusCode());
		
	}
	
	@Disabled
	@Test
	public void deveMostrarTodosContatos() {
		
		ResponseEntity<String> resposta = testRestTemplate
				.exchange("/contatos/", HttpMethod.GET, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveRealizarPutContatos() {
		HttpEntity<Contato> request = new HttpEntity<Contato>(contatoupd);
		
		ResponseEntity<Contato> resposta = testRestTemplate
				.exchange("/contatos/alterar", HttpMethod.PUT, request, Contato.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
	}
	
	@Disabled
	@Test
	public void deveRealizarDeleteContatos() {
		
		ResponseEntity<String> resposta = testRestTemplate
				.exchange("/contatos/3", HttpMethod.DELETE, null, String.class);
		assertEquals(HttpStatus.OK, resposta.getStatusCode());
		
	}
}
