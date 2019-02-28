package com.devmoney.compsal.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Sumula implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String nomeCompeticao;
	private String jogoNumero;
	private String equipeA;
	private String equipeB;
	
	private String categoria;
	private String ginasio;
	private String cidade;
	
	@JsonFormat(pattern="dd/MM/yyyy HH:mm")
	private Date data;
	
	@JsonIgnore
	@ManyToMany
	@JoinTable(name="SUMULA_ARBITRO",
				joinColumns = @JoinColumn(name="PK_Id_Sumula"),
				inverseJoinColumns = @JoinColumn(name="FK_Id_Arbitro"))
	private List<Arbitro> arbitros = new ArrayList<>();
	
	@ManyToOne
	@JoinColumn(name="FK_Id_Anotador")
	private Anotador anotador;
	
	public Sumula() {
	}

	public Sumula(Integer id, String nomeCompeticao, String jogoNumero, String equipeA, String equipeB, String categoria, 
			String ginasio, String cidade, Date data, Anotador anotador) {
		super();
		this.id = id;
		this.nomeCompeticao = nomeCompeticao;
		this.jogoNumero = jogoNumero;
		this.equipeA = equipeA;
		this.equipeB = equipeB;
		this.categoria = categoria;
		this.ginasio = ginasio;
		this.cidade = cidade;
		this.data = data;
		this.anotador = anotador;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCompeticao() {
		return nomeCompeticao;
	}

	public void setNomeCompeticao(String nomeCompeticao) {
		this.nomeCompeticao = nomeCompeticao;
	}

	public String getJogoNumero() {
		return jogoNumero;
	}

	public void setJogoNumero(String jogoNumero) {
		this.jogoNumero = jogoNumero;
	}

	public String getEquipeA() {
		return equipeA;
	}

	public void setEquipeA(String equipeA) {
		this.equipeA = equipeA;
	}

	public String getEquipeB() {
		return equipeB;
	}

	public void setEquipeB(String equipeB) {
		this.equipeB = equipeB;
	}	
	
	public Anotador getAnotador() {
		return anotador;
	}

	public void setAnotador(Anotador anotador) {
		this.anotador = anotador;
	}
	
	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getGinasio() {
		return ginasio;
	}

	public void setGinasio(String ginasio) {
		this.ginasio = ginasio;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public List<Arbitro> getArbitros() {
		return arbitros;
	}

	public void setArbitros(List<Arbitro> arbitros) {
		this.arbitros = arbitros;
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
		Sumula other = (Sumula) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
}
