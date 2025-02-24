package br.com.fiap.fin_money_api.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
	
	@RequestMapping
	public String index(){
		return "ok";
	}	
}
