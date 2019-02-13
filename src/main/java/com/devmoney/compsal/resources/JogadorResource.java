package com.devmoney.compsal.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value="/jogadores")
public class JogadorResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String texto() {
		return "Rest '/jogadores' está funcionando!";
	}
	
}
