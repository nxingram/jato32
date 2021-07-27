package com.generation.miofileuploaddb.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.generation.miofileuploaddb.Dto.VeicoloDto;
import com.generation.miofileuploaddb.entity.Veicolo;
import com.generation.miofileuploaddb.repo.IVeicoloRepo;

@Service
public class VeicoloService implements IVeicoloService {

	@Autowired
	private IVeicoloRepo repo;
	
	@Override
	public Veicolo save(MultipartFile file, VeicoloDto vDto) throws IOException {
		// nome del file caricato
		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		
		// creo un nuovo veicolo
		Veicolo veicolo = new Veicolo(vDto.getName(), fileName, file.getContentType(), file.getBytes());
		
		// salvo e restituisco il veicolo
		return repo.save(veicolo);
	}

	@Override
	public Veicolo getVeicoloById(int id) {
		return repo.findById(id).get();
	}

	@Override
	public List<Veicolo> getAllVeicoli() {
		return repo.findAll();
	}

}
