package com.devmoney.compsal;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devmoney.compsal.Repository.AnotadorRepository;
import com.devmoney.compsal.Repository.SumulaRepository;
import com.devmoney.compsal.domain.Anotador;
import com.devmoney.compsal.domain.Sumula;
import com.devmoney.compsal.domain.enums.PerfilUsuario;

@SpringBootApplication
public class CompsalBackendApplication implements CommandLineRunner {

	@Autowired
	private AnotadorRepository anotadorRepository;
	@Autowired
	private SumulaRepository sumulaRepository ;
	
	public static void main(String[] args) {
		SpringApplication.run(CompsalBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		Anotador ano1 = new Anotador(null, "Vinicius da Silva", "viniSil@gmail.com", "34455466");
		ano1.addPerfil(PerfilUsuario.ANOTADOR);
		
		Anotador ano2 = new Anotador(null, "Henrique Ferreira", "heriqueF@gmail.com", "54465766");
		ano2.addPerfil(PerfilUsuario.ANOTADOR);
		
		Sumula sumu1 = new Sumula(null, "Campeonato Pernambucano de Futsal S1", "1", "Santa Cruz", "Sport", ano1);
		Sumula sumu2 = new Sumula(null, "Campeonato PE Junior de Futsal", "3", "Nautico", "Carcará", ano1);
		Sumula sumu3 = new Sumula(null, "Campeonato Nacional de Futsal Ligua 1", "12", "Bahia", "Vasco", ano2);
		
		anotadorRepository.saveAll(Arrays.asList(ano1, ano2));
		sumulaRepository.saveAll(Arrays.asList(sumu1, sumu2, sumu3));
		
	}
	
	
}

