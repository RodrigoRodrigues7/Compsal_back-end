package com.devmoney.compsal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Equipe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String tecnico;
	private String massagista;
	private String preparadorFisico;
	
	@OneToMany(mappedBy="equipe")
	private List<Jogador> jogadores = new ArrayList<>();
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name="FK_Id_Sumula")
	private Sumula sumula;
	
	public Equipe() {
	}

	public Equipe(Integer id, String nome, String tecnico, String massagista, String preparadorFisico, Sumula sumula) {
		super();
		this.id = id;
		this.nome = nome;
		this.tecnico = tecnico;
		this.massagista = massagista;
		this.preparadorFisico = preparadorFisico;
		this.sumula = sumula;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getTecnico() {
		return tecnico;
	}

	public void setTecnico(String tecnico) {
		this.tecnico = tecnico;
	}

	public String getMassagista() {
		return massagista;
	}

	public void setMassagista(String massagista) {
		this.massagista = massagista;
	}

	public String getPreparadorFisico() {
		return preparadorFisico;
	}

	public void setPreparadorFisico(String preparadorFisico) {
		this.preparadorFisico = preparadorFisico;
	}
	
	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	public Sumula getSumula() {
		return sumula;
	}

	public void setSumula(Sumula sumula) {
		this.sumula = sumula;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}