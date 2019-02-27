package com.devmoney.compsal.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devmoney.compsal.Repository.ArbitroRepository;
import com.devmoney.compsal.domain.Arbitro;

@Service
public class ArbitroService {
	
	@Autowired
	private ArbitroRepository repo;
	
	public Arbitro findId(Integer id) {
		Optional<Arbitro> obj = repo.findById(id);
		return obj.orElse(null);
	}
	
}
