package com.generation.miofileuploaddb.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.multipart.MaxUploadSizeExceededException;

import com.generation.miofileuploaddb.Dto.MessaggioDto;

/**
 * classe per gestire eccezioni

 */
@ControllerAdvice
public class FileUploadExceptionAdvice {

	/**
	 * gestisce le eccezioni quando l'utente cerca di caricare un file di dimensioni superiori <br> 
	 * a quelle fissate in application.properties
	 * @param exc : eccezione file troppo grande
	 * @return messaggio
	 */
	@ExceptionHandler(MaxUploadSizeExceededException.class)
	public ResponseEntity<MessaggioDto> gestoreMaxSizeException(MaxUploadSizeExceededException exc){
		return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new MessaggioDto("File troppo Grande!"));
	}
}
