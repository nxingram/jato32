package com.generation.mioSharing.service;

import org.springframework.web.multipart.MultipartFile;

import com.generation.mioSharing.entity.Veicolo;

public interface IVeicoloService {

	Veicolo saveVeicolo(Veicolo veicolo, MultipartFile multipartFile);
}
