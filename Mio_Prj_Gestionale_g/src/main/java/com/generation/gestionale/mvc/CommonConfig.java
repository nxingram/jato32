package com.generation.gestionale.mvc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.generation.gestionale.entity.Impiegato;
import com.generation.gestionale.entity.Ufficio;
import com.generation.gestionale.service.iservice.IImpiegatoService;
import com.generation.gestionale.service.iservice.IUfficioService;

@Configuration
public class CommonConfig {
	@Autowired
	private IImpiegatoService _sImpiegato;
	
	@Autowired
	private IUfficioService _sUfficio;
	
//	@Bean
//	public List<Impiegato> impiegati(){
//		return _sImpiegato.findAll();
//	}
//	
//	@Bean
//	public List<Ufficio> uffici(){
//		return _sUfficio.findAll();
//	}
}
