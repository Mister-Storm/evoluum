package com.evoluum.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Microrregiao {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("mesorregiao")
	private Mesorregiao mesorregiao;

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

	public Mesorregiao getMesorregiao() {
		return mesorregiao;
	}

	public void setMesorregiao(Mesorregiao mesorregiao) {
		this.mesorregiao = mesorregiao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Microrregiao other = (Microrregiao) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}
	
	public Integer getIdEstado() {
		return mesorregiao.getIdEstado();
	}

	public Uf getUf() {
		return mesorregiao.getUf();
	}

	public String getNomeMesorregiao() {
		return mesorregiao.getNome();
	}

	public String getSiglaUf() {
		return mesorregiao.getSiglaUf();
	}

	public void setUf(Uf uf) {
		mesorregiao.setUf(uf);
		
	}

}
