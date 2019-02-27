package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Arbitro;
import com.devmoney.compsal.services.ArbitroService;

@RestController
@RequestMapping(value="/arbitros")
public class ArbitroResource {
	
	@Autowired
	private ArbitroService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Arbitro> find(@PathVariable Integer id) {
		Arbitro arbitro = service.findId(id);
		return ResponseEntity.ok().body(arbitro);
	}
	
}
