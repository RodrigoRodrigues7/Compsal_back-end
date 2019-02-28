package com.devmoney.compsal;

import java.text.SimpleDateFormat;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.devmoney.compsal.Repository.AnotadorRepository;
import com.devmoney.compsal.Repository.ArbitroRepository;
import com.devmoney.compsal.Repository.EquipeRepository;
import com.devmoney.compsal.Repository.JogadorRepository;
import com.devmoney.compsal.Repository.SumulaRepository;
import com.devmoney.compsal.domain.Anotador;
import com.devmoney.compsal.domain.Arbitro;
import com.devmoney.compsal.domain.Equipe;
import com.devmoney.compsal.domain.Jogador;
import com.devmoney.compsal.domain.Sumula;
import com.devmoney.compsal.domain.enums.FuncaoArbitro;
import com.devmoney.compsal.domain.enums.PerfilUsuario;

@SpringBootApplication
public class CompsalBackendApplication implements CommandLineRunner {

	@Autowired
	private AnotadorRepository anotadorRepository;
	@Autowired
	private SumulaRepository sumulaRepository;
	@Autowired
	private ArbitroRepository arbitroRepository;
	@Autowired
	private EquipeRepository equipeRepository;
	@Autowired
	private JogadorRepository jogadorRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CompsalBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Anotador ano1 = new Anotador(null, "Vinicius da Silva", "viniSil@gmail.com", "34455466", PerfilUsuario.ANOTADOR);
		Anotador ano2 = new Anotador(null, "Henrique Ferreira", "heriqueF@gmail.com", "54465766",PerfilUsuario.ANOTADOR);

		anotadorRepository.saveAll(Arrays.asList(ano1, ano2));
		
//-----------------------------------------------------------------------------------------------------------------------------
		
		Arbitro arb1 = new Arbitro(null, "Emmanuel Andrade");
		arb1.addFuncao(FuncaoArbitro.PRINCIPAL);

		Arbitro arb2 = new Arbitro(null, "Miguel Borges");
		arb2.addFuncao(FuncaoArbitro.AUXILIAR);
		
		Sumula sumu1 = new Sumula(null, "Campeonato Pernambucano de Futsal S1", "1", "Santa Cruz", "Sport", "Sub-20", "Geraldão", "Recife", 
				sdf.parse("27/02/2019 21:20"), ano1);
		
		sumu1.getArbitros().addAll(Arrays.asList(arb1, arb2));
		
		arbitroRepository.saveAll(Arrays.asList(arb1, arb2));
		sumulaRepository.saveAll(Arrays.asList(sumu1));
		
//-----------------------------------------------------------------------------------------------------------------------------
		
		Equipe equipe1 = new Equipe(null, "Sport", "Zé Braga Neto", "Felipe Souza", "Sérgio Menesez");
		
		Jogador jog1 = new Jogador(null, "Romário", "11", 14, equipe1);
		Jogador jog2 = new Jogador(null, "Pelépo", "10", 4, equipe1);
		Jogador jog3 = new Jogador(null, "Ronaldinho Baihano", "17", 10, equipe1);
		Jogador jog4 = new Jogador(null, "Romero Brita", "22", 24, equipe1);
		Jogador jog5 = new Jogador(null, "Ziico", "6", 18, equipe1);
		
		equipe1.getJogadores().addAll(Arrays.asList(jog1, jog2, jog3, jog4, jog5));
		
		equipeRepository.saveAll(Arrays.asList(equipe1));
		jogadorRepository.saveAll(Arrays.asList(jog1, jog2, jog3, jog4, jog5));
	}

}















