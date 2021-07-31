package com.generation.miofileuploaddb.service;

import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

import org.springframework.web.multipart.MultipartFile;

import com.generation.miofileuploaddb.dto.VeicoloDto;
import com.generation.miofileuploaddb.entity.Veicolo;

public interface IVeicoloService {
	
	Veicolo save(MultipartFile file, VeicoloDto vDto) throws IOException;
	
	Veicolo getVeicoloById(int id);
	
	List<Veicolo> getAllVeicoli();
}
