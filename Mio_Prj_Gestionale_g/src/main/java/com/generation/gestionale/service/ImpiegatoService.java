package com.generation.gestionale.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.generation.gestionale.entity.Impiegato;
import com.generation.gestionale.repository.IImpiegato;
import com.generation.gestionale.service.iservice.IImpiegatoService;

@Service
public class ImpiegatoService implements IImpiegatoService {

	@Autowired
	private IImpiegato _rImpiegato;
	
	@Override
	public List<Impiegato> findAll() {
		return _rImpiegato.findAll();
	}

}
