package com.evoluum.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Cidade {
	
	@JsonProperty("id")
	private Integer id;
	
	@JsonProperty("nome")
	private String nome;
	
	@JsonProperty("microrregiao")
	private Microrregiao microrregiao;

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

	public Microrregiao getMicrorregiao() {
		return microrregiao;
	}

	public void setMicrorregiao(Microrregiao microrregiao) {
		this.microrregiao = microrregiao;
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
		Cidade other = (Cidade) obj;
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
		return microrregiao.getIdEstado();
	}

	public Uf getUF() {
		return microrregiao.getUf();
	}

	public String getNomeMesorregiao() {
		return microrregiao.getNomeMesorregiao();
	}

	public String getNomeMicroRregiao() {
		return microrregiao.getNome();
	}

	public String getSiglaUf() {
		return microrregiao.getSiglaUf();
	}

	public void setUf(Uf uf) {
		microrregiao.setUf(uf);
		
	}

}
