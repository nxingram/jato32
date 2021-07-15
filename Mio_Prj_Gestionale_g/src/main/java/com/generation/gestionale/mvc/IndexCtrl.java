package com.generation.gestionale.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexCtrl {

	@GetMapping("/")
	public String index() {
		return "index";
	}
}
