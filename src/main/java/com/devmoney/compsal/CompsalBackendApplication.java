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
import com.devmoney.compsal.Repository.TecnicoRepository;
import com.devmoney.compsal.domain.Anotador;
import com.devmoney.compsal.domain.Arbitro;
import com.devmoney.compsal.domain.Equipe;
import com.devmoney.compsal.domain.Jogador;
import com.devmoney.compsal.domain.ResolucaoEquipe;
import com.devmoney.compsal.domain.Sumula;
import com.devmoney.compsal.domain.Tecnico;
import com.devmoney.compsal.domain.enums.FuncaoArbitro;
import com.devmoney.compsal.domain.enums.PerfilUsuario;

@SpringBootApplication
public class CompsalBackendApplication implements CommandLineRunner {

	@Autowired
	private AnotadorRepository anotadorRepository;
	@Autowired
	private TecnicoRepository tecnicoRepository;
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
				
		Arbitro arb1 = new Arbitro(null, "Emmanuel Andrade", FuncaoArbitro.PRINCIPAL);
		Arbitro arb2 = new Arbitro(null, "Miguel Borges", FuncaoArbitro.AUXILIAR);
		Arbitro arb3 = new Arbitro(null, "Mannolo Silva", FuncaoArbitro.AUXILIAR);
		Arbitro arb4 = new Arbitro(null, "Evandro da Costa", FuncaoArbitro.AUXILIAR);
		Arbitro arb5 = new Arbitro(null, "Júlio Alenmar", FuncaoArbitro.PRINCIPAL);
		
		Tecnico tecA = new Tecnico(null, "Zé Braga Neto", "zeze@gmail.com", "55566448", PerfilUsuario.TECNICO);
		Tecnico tecB = new Tecnico(null, "Birimba", "birimbal123@gmail.com", "46789932", PerfilUsuario.TECNICO);
		
		Equipe equipeA = new Equipe(null, "Sport", "Felipe Souza", "Sérgio Menesez");
		
		Jogador joga1 = new Jogador(null, "Romário", "11", 14, equipeA, false);
		Jogador joga2 = new Jogador(null, "Pelépo", "10", 4, equipeA, true);
		Jogador joga3 = new Jogador(null, "Ronaldinho Baihano", "17", 10, equipeA, false);
		Jogador joga4 = new Jogador(null, "Romero Brita", "22", 24, equipeA, false);
		Jogador joga5 = new Jogador(null, "Ziico", "6", 18, equipeA, false);
		
		equipeA.getJogadores().addAll(Arrays.asList(joga1, joga2, joga3, joga4, joga5));
		equipeA.setTecnico(tecA);
		tecA.setEquipe(equipeA);
		
		Equipe equipeB = new Equipe(null, "Santa Cruz", "Hernesto Mathias", "Flávio Assunção");
		
		Jogador jogb1 = new Jogador(null, "Fernando", "1", 0, equipeB, false);
		Jogador jogb2 = new Jogador(null, "Nelson", "13", 15, equipeB, false);
		Jogador jogb3 = new Jogador(null, "Sandro", "10", 5, equipeB, true);
		Jogador jogb4 = new Jogador(null, "Ariano", "5", 8, equipeB, false);
		Jogador jogb5 = new Jogador(null, "Alceu", "20", 30, equipeB, false);
		
		equipeB.getJogadores().addAll(Arrays.asList(jogb1, jogb2, jogb3, jogb4, jogb5));
		equipeB.setTecnico(tecB);
		tecB.setEquipe(equipeB);
		
		Sumula sumu1 = new Sumula(null, "Campeonato Pernambucano de Futsal S1", "1", equipeA.getNome() , equipeB.getNome(), "4", "2", "Sub-20", "Geraldão", "Recife", sdf.parse("27/02/2019 21:20"), ano1);
		sumu1.getArbitros().addAll(Arrays.asList(arb1, arb2));
		
		ResolucaoEquipe resEquipeA = new ResolucaoEquipe(null, 2, 0, 1, 1, 6, equipeA);
		ResolucaoEquipe resEquipeB = new ResolucaoEquipe(null, 0, 1, 3, 2, 12, equipeB);		
		
		resEquipeA.setJogadorCapitao(joga2.getNome());
		resEquipeA.setTecnico(tecA.getNome());
		resEquipeA.setSumula(sumu1);
		
		resEquipeB.setJogadorCapitao(jogb3.getNome());
		resEquipeB.setTecnico(tecB.getNome());
		resEquipeB.setSumula(sumu1);
		
		equipeA.getResolucoes().addAll(Arrays.asList(resEquipeA));
		equipeB.getResolucoes().addAll(Arrays.asList(resEquipeB));
		
		sumu1.getResolucoes().addAll(Arrays.asList(resEquipeA, resEquipeB));
		
//---------------------------------------------------------------------------------------------------------		
		
		anotadorRepository.saveAll(Arrays.asList(ano1, ano2));
		
		arbitroRepository.saveAll(Arrays.asList(arb1, arb2, arb3, arb4, arb5));
		sumulaRepository.saveAll(Arrays.asList(sumu1));
		
		tecnicoRepository.saveAll(Arrays.asList(tecA, tecB));
		equipeRepository.saveAll(Arrays.asList(equipeA, equipeB));
		
		resEquipeRepository.saveAll(Arrays.asList(resEquipeA, resEquipeB));
		jogadorRepository.saveAll(Arrays.asList(joga1, joga2, joga3, joga4, joga5, jogb1, jogb2, jogb3, jogb4, jogb5));
	}

}















