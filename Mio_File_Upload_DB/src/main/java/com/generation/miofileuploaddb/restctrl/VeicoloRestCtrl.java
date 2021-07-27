package com.generation.miofileuploaddb.restctrl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.generation.miofileuploaddb.Dto.MessaggioDto;
import com.generation.miofileuploaddb.Dto.VeicoloDto;
import com.generation.miofileuploaddb.entity.Veicolo;
import com.generation.miofileuploaddb.service.IVeicoloService;

/**
 * https://www.bezkoder.com/spring-boot-upload-file-database/
 */
@RestController
@RequestMapping("api/veicolo")
@CrossOrigin("http://localhost:8080")
public class VeicoloRestCtrl {

	@Autowired
	private IVeicoloService _service;
	
	/**
	 * Salvataggio di un veicolo con un'immagine
	 * @param file : immagine
	 * @param vDto : dati veicolo
	 * @return messaggio
	 */
	@PostMapping("/upload")
	public ResponseEntity<MessaggioDto> uploadVeicolo(
			@RequestParam("file") MultipartFile file,
			@RequestParam String name){
		String message = "";
		try {
			// salvo il veicolo con l'immagine su db
			VeicoloDto vDto = new VeicoloDto();
			vDto.setName(name);
			_service.save(file, vDto);			
			message = "Veicolo salvato correttamente: " + file.getOriginalFilename();
			
			// se salvato correttamente il veicolo, restituisco un messaggio
			return ResponseEntity.status(HttpStatus.OK).body(new MessaggioDto(message));
			
		} catch (IOException e) {

			e.printStackTrace();
			message = "Salvataggio veicolo non ruscito: " + file.getOriginalFilename() + "!";

			// altrimenti restituisco un messaggio di errore
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessaggioDto(message));
		}
		
	}
	
	/**
	 * Tutti i veicoli
	 * @return lista di veicoli con il percorso dell'immagine
	 */
	@GetMapping("/all")
	public ResponseEntity<List<VeicoloDto>> getListFiles(){
		
		// prendo tutti i veicoli
		List<Veicolo> listaVeicoli = _service.getAllVeicoli();
		
		// trasformo una lista di veicoli, in una lista di veicoliDto
		List<VeicoloDto> listaVeicoliDto = listaVeicoli.stream().map(veicolo -> {
			
			// genero il percorso per scaricare l'immagine chimando la rotta /files/id
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/api/veicolo/immagine/") // percorso del metodo getImmagine
					.path(String.valueOf(veicolo.getId()))
					.toUriString();
						
			// creo il VeicoloDto con dentro il percorso del file		
			return new VeicoloDto(
					veicolo.getName(), 
					veicolo.getFileName(), 
					veicolo.getType(), 
					fileDownloadUri, 
					veicolo.getData().length);
		} ).collect(Collectors.toList());
		
		
		return ResponseEntity.status(HttpStatus.OK).body(listaVeicoliDto);
	}
	
	/**
	 * Restituisce un veicolo con l'immagine
	 * @param id del veicolo
	 * @return veicolo
	 * https://developer.mozilla.org/en-US/docs/Web/HTTP/Headers/Content-Disposition
	 */
	@GetMapping("/immagine/{id}")
//	public ResponseEntity<byte[]> getImmagine(@PathVariable int id){
	public ResponseEntity<Veicolo> getImmagine(@PathVariable int id){
		
		// prendo il veicolo 
		Veicolo veicolo = _service.getVeicoloById(id);
		
		// restituisco l'immagine del veicolo
//		return ResponseEntity
//				.ok()
//				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + veicolo.getFileName() + "\"") // fa scaricare l'immagine
//				.body(veicolo.getData());
		
		// restituisco il veicolo con all'interno l'immagine
		return ResponseEntity.ok().body(veicolo);
	}
	
}
