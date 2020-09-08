package com.evoluum.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class CidadeReturnApi {
	
	@JsonIgnore(value = true)
	private Integer id;
	private Integer idEstado; 
	private String siglaEstado, regiaoNome, nomeCidade, nomeMesorregiao, nomeFormatado;
			
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getSiglaEstado() {
		return siglaEstado;
	}
	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}
	public String getRegiaoNome() {
		return regiaoNome;
	}
	public void setRegiaoNome(String regiaoNome) {
		this.regiaoNome = regiaoNome;
	}
	public String getNomeCidade() {
		return nomeCidade;
	}
	public void setNomeCidade(String nomeCidade) {
		this.nomeCidade = nomeCidade;
	}
	public String getNomeMesorregiao() {
		return nomeMesorregiao;
	}
	public void setNomeMesorregiao(String nomeMesorregiao) {
		this.nomeMesorregiao = nomeMesorregiao;
	}
	public String getNomeFormatado() {
		return nomeFormatado;
	}
	public void setNomeFormatado(String nomeFormatado) {
		this.nomeFormatado = nomeFormatado;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idEstado == null) ? 0 : idEstado.hashCode());
		result = prime * result + ((nomeCidade == null) ? 0 : nomeCidade.hashCode());
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
		CidadeReturnApi other = (CidadeReturnApi) obj;
		if (idEstado == null) {
			if (other.idEstado != null)
				return false;
		} else if (!idEstado.equals(other.idEstado))
			return false;
		if (nomeCidade == null) {
			if (other.nomeCidade != null)
				return false;
		} else if (!nomeCidade.equals(other.nomeCidade))
			return false;
		return true;
	}
	
	

}
