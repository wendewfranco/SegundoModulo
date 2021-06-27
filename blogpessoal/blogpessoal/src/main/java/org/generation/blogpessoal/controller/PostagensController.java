package org.generation.blogpessoal.controller;

import org.generation.blogpessoal.repository.PostagemRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/postagens")
@CrossOrigin("*")
public class PostagensController {
	
	private PostagemRepository repository;

}
