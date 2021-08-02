package com.generation.springmvchttpsession.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.generation.springmvchttpsession.entity.User;

//1) Sessione Http lato server

@Controller
@SessionAttributes("user") //1
public class IndexCtrl {
	
	// 2) N.B:  Model model: serve solo per debuggare 
	// e vedere quando lo user viene caricato o rimosso dalla sessione
	// nelle variabili di debug vedrai una chiave: user
	// e l'istanza di User con i dati.
	// Provare a fare login con 2 browsers diversi
	
	@RequestMapping("/")
	public String base(Model model) { //2
		return "index";
	}
}
