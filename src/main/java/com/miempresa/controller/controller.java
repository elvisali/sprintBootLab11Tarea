package com.miempresa.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class controller {
	
	@GetMapping("/primos")
	public String primos(
			@RequestParam(name="ini", required = false, defaultValue = "1") String ini, 
			@RequestParam(name="fin", required = false, defaultValue = "10") String fin,
			Model model) { 
	 
		List<Integer> primos = new ArrayList<Integer>();
		
		int vIni = Integer.parseInt(ini);
		int vFin = Integer.parseInt(fin);
		
		for(int i=vIni;i<=vFin ;i++) {
			if(this.esPrimo(i)) {
				primos.add(i);
			}
		}
		
		model.addAttribute("arrPrimos", primos);
		model.addAttribute("tipo", "primos");
	
		return "resultados"; 
	}
	
	@GetMapping("/multiplicar")
	public String multiplicar(
			@RequestParam(name="numero",
			required = false,
			defaultValue = "1") String numero, Model model) { 
		
		List<Multiplicar> resultado = new ArrayList<Multiplicar>();
		
		
		int vNumero = Integer.parseInt(numero);
		
		  for(int i=0; i<=10; i++) {
			  Multiplicar to = new Multiplicar();
			  	to.setNumero(vNumero);
			  	to.setResultado(vNumero*i);
			  	to.setPar(this.esPar(vNumero*i));
			  resultado.add(to) ;
			   
              
          }
	
		 
		  model.addAttribute("arrResultado", resultado);
		model.addAttribute("tipo", "tMultiplicar");
		
		return "resultados"; 
	}
	
	
	public static boolean esPrimo(int numero){
		  int contador = 2;
		  boolean primo=true;
		  while ((primo) && (contador!=numero)){
		    if (numero % contador == 0)
		      primo = false;
		    contador++;
		  }
		  return primo;
	}
	
	static boolean esPar(int numero){
	    if (numero%2==0) return true; else return false;
	}
	
	 
}

 
