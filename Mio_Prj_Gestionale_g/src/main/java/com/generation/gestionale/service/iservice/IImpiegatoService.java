package com.generation.gestionale.service.iservice;

import java.util.List;

import com.generation.gestionale.entity.Impiegato;

public interface IImpiegatoService {
	List<Impiegato> findAll();
	Impiegato addOne(Impiegato i);
}
