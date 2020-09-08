package com.evoluum.model;

public class NomeFormatado {
	
	private Uf uf;
	private Cidade cidade;
	
	public NomeFormatado(Uf uf, Cidade cidade) {
		this.cidade = cidade;
		this.uf = uf;
	}
	
	@Override
	public String toString() {
		return cidade.getNome()+"/"+uf.getNome();
	}
	
}
