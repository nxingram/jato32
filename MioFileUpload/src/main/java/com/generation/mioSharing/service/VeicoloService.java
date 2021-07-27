package com.generation.mioSharing.service;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.generation.mioSharing.config.CustomProperties;
import com.generation.mioSharing.entity.Veicolo;
import com.generation.mioSharing.repo.IVeicoloRepo;
import com.generation.mioSharing.util.FileUploadUtil;

@Service
public class VeicoloService implements IVeicoloService {
	
	@Autowired
    private IVeicoloRepo repo;
	
	 public Veicolo saveVeicolo(Veicolo veicolo, MultipartFile multipartFile) {
		
		// nome del file
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		
		// setto nome del file prima di salvare il veicolo
		veicolo.setPhoto(fileName);
		
		// salvo il veicolo
		Veicolo veicoloSalvato = repo.save(veicolo);

		// percorso della cartella dove salvare l'immagine
		String uploadDir = CustomProperties.basepath + "/" + veicoloSalvato.getId();
		 
        try {
        	// classe util con metodo statico che salva il file
			FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
		} catch (IOException e) {
			e.printStackTrace();
		}
        
        // restituisce il path uri del file img
        System.out.println(veicoloSalvato.getPhotosImagePath());
        
		return veicoloSalvato;
		
	}
}
