package com.devmoney.compsal.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.devmoney.compsal.domain.Jogador;

@RestController
@RequestMapping(value="/jogadores")
public class JogadorResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Jogador> listar() {
		Jogador jog1 = new Jogador(1, "Rivaldo");
		Jogador jog2 = new Jogador(2, "Cristian");
		
		List<Jogador> lista = new ArrayList<>();
		lista.add(jog1);
		lista.add(jog2);
		
		return lista;
	}
	
}
