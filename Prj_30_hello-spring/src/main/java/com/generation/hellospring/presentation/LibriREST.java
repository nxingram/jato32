package com.generation.hellospring.presentation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.hellospring.model.Libro;
import com.generation.hellospring.service.LibroService;

@RestController
@RequestMapping(path = "/api")
public class LibriREST {
	
	@Autowired
	private LibroService service;
	
	@GetMapping(path = "/saluta")
	public String hello() {
		return "Hello";
	}
	
	@GetMapping(value = "/libri")
	public List<Libro> libri() {
		return service.getLibri();
	}

}
