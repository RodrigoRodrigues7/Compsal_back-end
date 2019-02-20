package com.devmoney.compsal.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Jogador implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nome;
	private String numeroCamisa;
	private Integer qtdGols;
	private Integer numeroFaltas;
	private Integer qtdCartaoAmarelo;
	private Integer qtdCartaoVermelho;
	
	public Jogador() {
	}	

	public Jogador(Integer id, String numeroCamisa, Integer qtdGols, Integer numeroFaltas, Integer qtdCartaoAmarelo, Integer qtdCartaoVermelho) {
		super();
		this.id = id;
		this.numeroCamisa = numeroCamisa;
		this.qtdGols = qtdGols;
		this.numeroFaltas = numeroFaltas;
		this.qtdCartaoAmarelo = qtdCartaoAmarelo;
		this.qtdCartaoVermelho = qtdCartaoVermelho;
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

	public String getNumeroCamisa() {
		return numeroCamisa;
	}

	public void setNumeroCamisa(String numeroCamisa) {
		this.numeroCamisa = numeroCamisa;
	}

	public Integer getQtdGols() {
		return qtdGols;
	}

	public void setQtdGols(Integer qtdGols) {
		this.qtdGols = qtdGols;
	}

	public Integer getNumeroFaltas() {
		return numeroFaltas;
	}

	public void setNumeroFaltas(Integer numeroFaltas) {
		this.numeroFaltas = numeroFaltas;
	}

	public Integer getQtdCartaoAmarelo() {
		return qtdCartaoAmarelo;
	}

	public void setQtdCartaoAmarelo(Integer qtdCartaoAmarelo) {
		this.qtdCartaoAmarelo = qtdCartaoAmarelo;
	}

	public Integer getQtdCartaoVermelho() {
		return qtdCartaoVermelho;
	}

	public void setQtdCartaoVermelho(Integer qtdCartaoVermelho) {
		this.qtdCartaoVermelho = qtdCartaoVermelho;
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
		Jogador other = (Jogador) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
