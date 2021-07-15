package com.generation.gestionale.mvc;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.generation.gestionale.entity.Impiegato;
import com.generation.gestionale.entity.Ufficio;
import com.generation.gestionale.service.iservice.IImpiegatoService;
import com.generation.gestionale.service.iservice.IUfficioService;

/**
 * Controller MVC: restituisce pagine Html <br>
 * Thymeleaf : https://www.baeldung.com/thymeleaf-in-spring-mvc <br>
 * ModelAttribute: https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
 */
@Controller
@RequestMapping("/mvc/impiegato")
public class ImpiegatoCtrl {

	@Autowired
	private IImpiegatoService _sImpiegato;
	
	@Autowired
	private IUfficioService _sUfficio;

	/**
	 * Tutti gli impiegati <br>
	 * method: GET <br>
	 * lista impiegati viene aggiunta nel model dal metodo addModelAttributes()</br>
	 * Thymeleaf paragrafo 5.2: https://www.baeldung.com/thymeleaf-in-spring-mvc 
	 * @param model con la lista
	 * @return html thymeleaf
	 */
	@GetMapping
	public String allImpiegati(Model model) {
//		model.addAttribute("impiegati", _sImpiegato.findAll());
		return "/impiegato/impiegato-list";
	}

	/**
	 * Aggiunge un impiegato, se non ci sono errori <br>
	 * methd: POST </br>
	 * Thymeleaf paragrafi 7-8: https://www.baeldung.com/thymeleaf-in-spring-mvc 
	 * @param imp Impiegato
	 * @param errors gli errori di validazione
	 * @return
	 */
	@PostMapping
	public String addImpiegato(@Valid @ModelAttribute Impiegato imp, BindingResult errors, Model model) {
		if (errors.hasErrors()) {
			// se ho errori riapro il form e visualizzo gli errori
			return "/impiegato/impiegato-form";
		}

		// salvo l'impiegato
		_sImpiegato.addOne(imp);

		// rotta get impiegato mvc
		return "redirect:/mvc/impiegato";
	}
	
	/**
	 * GET: link aggiungi un impiegato, restituisce un form html </br>
	 * \@ModelAttribute : aggiunge in automatico un attributo "impiegato" = new Impiegato() </br>
	 * se non si aggiunge l'attributo impiegasto, thymeleaf da errore in th:object="${impiegato}" </br> 
	 */
	@GetMapping("/aggiungi")	
	public String addImpiegatoForm(@ModelAttribute Impiegato imp, Model model) {
		return "/impiegato/impiegato-form";
	}
	
	/**
	 * Aggiunge gli attributi a tutti i Model di questo controller <br/>
	 * paragrafo 2.1: https://www.baeldung.com/spring-mvc-and-the-modelattribute-annotation
	 * @param model : da passare alle pagine thymeleaf
	 */
	@ModelAttribute
	public void addModelAttributes(Model model) {
		model.addAttribute("impiegati", _sImpiegato.findAll());
		model.addAttribute("uffici", _sUfficio.findAll());
	}
	
	

	


}
