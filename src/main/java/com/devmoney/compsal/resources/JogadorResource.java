package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Jogador;
import com.devmoney.compsal.services.JogadorService;

@RestController
@RequestMapping(value="/jogadores")
public class JogadorResource {
	
	@Autowired
	private JogadorService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<Jogador> find(@PathVariable Integer id) {
		Jogador obj = service.findId(id);
		return ResponseEntity.ok().body(obj);
	}
	
}
