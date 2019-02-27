package com.devmoney.compsal.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Anotador extends Usuario {
	private static final long serialVersionUID = 1L;
	
	@JsonIgnore
	@OneToMany(mappedBy="anotador")
	private List<Sumula> sumulas = new ArrayList<>();
	
	public Anotador() {
	}

	public Anotador(Integer id, String nome, String email, String telefone) {
		super(id, nome, email, telefone);
	}

	public List<Sumula> getSumulas() {
		return sumulas;
	}

	public void setSumulas(List<Sumula> sumulas) {
		this.sumulas = sumulas;
	}
	
}
