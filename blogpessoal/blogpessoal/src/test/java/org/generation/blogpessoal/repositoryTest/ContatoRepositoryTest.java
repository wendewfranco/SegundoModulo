package org.generation.blogpessoal.repositoryTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.generation.blogpessoal.model.Contato;
import org.generation.blogpessoal.repository.ContatoRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.util.Assert;







@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class ContatoRepositoryTest {
	
	@Autowired
	private ContatoRepository contatoRepository;
	
	@BeforeAll
	public void start() {
		Contato contato = new Contato(null, "Lenda", "35y", "7845124515");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new Contato(null, "Nova Lenda", "25y", "9988774415");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new Contato(null, "Lenda Old School", "45y", "11915247869");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
		
		contato = new Contato(null, "Amigo das Lendas", "15y", "7815426844");
		if (contatoRepository.findFirstByNome(contato.getNome()) == null)
			contatoRepository.save(contato);
	}
	
	@Test
	public void findByNomeRetornaContato () throws Exception {
		
		Contato contato = contatoRepository.findFirstByNome("Lenda");
		
		assertTrue(contato.getNome().equals("Lenda"));
	}

	
	public void findAllByNomeIgnoreCaseRetornaTresContato () {
		
		List<Contato> contatos = contatoRepository.findAllByNomeIgnoreCaseContaining("lenda");
		
		assertEquals(3, contatos.size());
	}
	
	public void end() {
		contatoRepository.deleteAll();
	}
}
