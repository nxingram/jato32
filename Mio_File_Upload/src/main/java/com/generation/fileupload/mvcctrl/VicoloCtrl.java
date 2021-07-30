package com.generation.fileupload.mvcctrl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.generation.fileupload.entity.Veicolo;
import com.generation.fileupload.service.VeicoloService;

/**
 * Tutorial <br>
 * https://www.codejava.net/frameworks/spring-boot/spring-boot-file-upload-tutorial
 *
 */
@Controller
@RequestMapping("/mvc/veicolo")
public class VicoloCtrl {

	@Autowired
    private VeicoloService _vserv;
	
	@PostMapping("/save")
	public String salvaVeicolo(Veicolo veicolo, @RequestParam("image") MultipartFile multipartFile, Model model) {
		Veicolo veicoloSalvato = new Veicolo(); // vuoto
		
		// controllo se c'è l'immagine
		if(multipartFile == null || multipartFile.equals("")) {
			// non è stata caricata una immagine, salvo comunque il veicolo
			veicoloSalvato = _vserv.saveVeicolo(veicolo);
		}else {
			// salvo il veicolo su database, e l'immagine in una cartella
			veicoloSalvato = _vserv.saveVeicolo(veicolo, multipartFile);			
		}
        
        // si può fare lo stesso percorso con un'api rest, e restituire solo il veicolo senza l'html
        model.addAttribute("veicolo", veicoloSalvato);
        
		return "file-salvato";
	}
	
}
