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
import com.devmoney.compsal.Repository.ResolucaoEquipeRepository;
import com.devmoney.compsal.Repository.SumulaRepository;
import com.devmoney.compsal.domain.Anotador;
import com.devmoney.compsal.domain.Arbitro;
import com.devmoney.compsal.domain.Equipe;
import com.devmoney.compsal.domain.Jogador;
import com.devmoney.compsal.domain.ResolucaoEquipe;
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
	@Autowired
	private ResolucaoEquipeRepository resEquipeRepository;
	
	
	public static void main(String[] args) {
		SpringApplication.run(CompsalBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Anotador ano1 = new Anotador(null, "Vinicius da Silva", "viniSil@gmail.com", "34455466", PerfilUsuario.ANOTADOR);
		Anotador ano2 = new Anotador(null, "Henrique Ferreira", "heriqueF@gmail.com", "54465766",PerfilUsuario.ANOTADOR);
				
		Arbitro arb1 = new Arbitro(null, "Emmanuel Andrade");
		arb1.addFuncao(FuncaoArbitro.PRINCIPAL);

		Arbitro arb2 = new Arbitro(null, "Miguel Borges");
		arb2.addFuncao(FuncaoArbitro.AUXILIAR);
		
		Sumula sumu1 = new Sumula(null, "Campeonato Pernambucano de Futsal S1", "1", "Sub-20", "Geraldão", "Recife", sdf.parse("27/02/2019 21:20"), ano1);
				
		Equipe equipeA = new Equipe(null, "Sport", "Zé Braga Neto", "Felipe Souza", "Sérgio Menesez", sumu1);
		
		Jogador joga1 = new Jogador(null, "Romário", "11", 14, equipeA, false);
		Jogador joga2 = new Jogador(null, "Pelépo", "10", 4, equipeA, true);
		Jogador joga3 = new Jogador(null, "Ronaldinho Baihano", "17", 10, equipeA, false);
		Jogador joga4 = new Jogador(null, "Romero Brita", "22", 24, equipeA, false);
		Jogador joga5 = new Jogador(null, "Ziico", "6", 18, equipeA, false);
		
		equipeA.getJogadores().addAll(Arrays.asList(joga1, joga2, joga3, joga4, joga5));
		
		Equipe equipeB = new Equipe(null, "Santa Cruz", "Birimba", "Hernesto Mathias", "Flávio Assunção", sumu1);
		
		Jogador jogb1 = new Jogador(null, "Fernando", "1", 0, equipeB, false);
		Jogador jogb2 = new Jogador(null, "Nelson", "13", 15, equipeB, false);
		Jogador jogb3 = new Jogador(null, "Sandro", "10", 5, equipeB, true);
		Jogador jogb4 = new Jogador(null, "Ariano", "5", 8, equipeB, false);
		Jogador jogb5 = new Jogador(null, "Alceu", "20", 30, equipeB, false);
		
		equipeA.getJogadores().addAll(Arrays.asList(jogb1, jogb2, jogb3, jogb4, jogb5));
		
		sumu1.getArbitros().addAll(Arrays.asList(arb1, arb2));
		sumu1.getEquipes().addAll(Arrays.asList(equipeA, equipeB));
		
		ResolucaoEquipe resEquipeA = new ResolucaoEquipe(null, 2, 0, 1, 1, 6, "Birimba", equipeA);
		ResolucaoEquipe resEquipeB = new ResolucaoEquipe(null, 0, 1, 3, 2, 12, "Zé Braga Neto", equipeB);		
		
		resEquipeA.setJogadorCapitao(joga2.getNome());
		resEquipeB.setJogadorCapitao(jogb3.getNome());
		
		equipeA.getResolucoes().addAll(Arrays.asList(resEquipeA));
		equipeB.getResolucoes().addAll(Arrays.asList(resEquipeB));
		
//---------------------------------------------------------------------------------------------------------		
		
		anotadorRepository.saveAll(Arrays.asList(ano1, ano2));
		
		arbitroRepository.saveAll(Arrays.asList(arb1, arb2));
		sumulaRepository.saveAll(Arrays.asList(sumu1));
		
		equipeRepository.saveAll(Arrays.asList(equipeA, equipeB));
		resEquipeRepository.saveAll(Arrays.asList(resEquipeA, resEquipeB));
		jogadorRepository.saveAll(Arrays.asList(joga1, joga2, joga3, joga4, joga5, jogb1, jogb2, jogb3, jogb4, jogb5));
	}

}















