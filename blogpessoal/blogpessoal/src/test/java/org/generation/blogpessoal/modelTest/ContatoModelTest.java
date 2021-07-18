package org.generation.blogpessoal.modelTest;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;

import org.generation.blogpessoal.model.Contato;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContatoModelTest {
	
	public Contato contato;
	
	@Autowired
	private final Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	
	@BeforeEach
	public void start() {
		contato = new Contato(null,"Wendew","24y", "11998547652");
	}
	
	@Test
	public void testValidationAtributos() {
		
		contato.setNome("Maro");
		contato.setDdd("021");
		contato.setTelefone("21987454785");
		
		Set<ConstraintViolation<Contato>> violations = validator.validate(contato);
		System.out.println(violations.toString());
		assertTrue(violations.isEmpty());
	}
	

}
