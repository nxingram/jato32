package com.generation.hellospring.bean;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import com.generation.hellospring.model.Libro;

/**
 * Required both annotations @Component on class && @Bean on method 
 * to create beans for the spring application context
 */
@Component
public class AutowiredBeans {

	@Bean
	public ArrayList<Libro> getNew(){
		return new ArrayList<Libro>();
	}
}
