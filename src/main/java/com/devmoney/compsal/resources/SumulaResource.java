package com.devmoney.compsal.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Sumula;
import com.devmoney.compsal.services.SumulaService;

@RestController
@RequestMapping(value="/sumulas")
public class SumulaResource {
	
	@Autowired
	private SumulaService service;
	
	@RequestMapping(value="/{id}",method=RequestMethod.GET)
	public ResponseEntity<Sumula> find(@PathVariable Integer id) {
		Sumula sumula = service.findId(id);
		return ResponseEntity.ok().body(sumula);
	}
	
}
