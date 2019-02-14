package com.devmoney.compsal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.JogadorRepository;
import com.devmoney.compsal.domain.Jogador;

@Service // Annotation coloado para o 'Spring' saber que essa classe sera um provedor de servico
public class JogadorService {

	@Autowired
	private JogadorRepository repo;
	
	public Jogador findId(Integer id) {
		Optional<Jogador> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
