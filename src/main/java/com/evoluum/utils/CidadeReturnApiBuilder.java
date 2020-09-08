package com.evoluum.utils;

import com.evoluum.model.CidadeReturnApi;
import com.evoluum.model.NomeFormatado;

public class CidadeReturnApiBuilder {
	
	CidadeReturnApi cidade;
	
	public CidadeReturnApiBuilder() {
		cidade = new CidadeReturnApi();
	}
	
	public CidadeReturnApiBuilder withId(Integer id) {
		cidade.setIdEstado(id);
		return this;
	}
	
	public CidadeReturnApiBuilder withIdEstado(Integer idEstado) {
		cidade.setIdEstado(idEstado);
		return this;
	}
	
	public CidadeReturnApiBuilder withNomeCidade(String nomeCidade) {
		cidade.setNomeCidade(nomeCidade);
		return this;
	}
	
	public CidadeReturnApiBuilder withNomeFormatado(NomeFormatado nomeFormatado) {
		cidade.setNomeFormatado(nomeFormatado.toString());
		return this;
	}
	
	public CidadeReturnApiBuilder withNomeMesorregiao(String nomeMesorregiao) {
		cidade.setNomeMesorregiao(nomeMesorregiao);
		return this;
	}
	
	public CidadeReturnApiBuilder withRegiaoNome(String regiaoNome) {
		cidade.setRegiaoNome(regiaoNome);
		return this;
	}
	
	public CidadeReturnApiBuilder withSiglaEstado(String siglaEstado) {
		cidade.setSiglaEstado(siglaEstado);
		return this;
	}
	
	public CidadeReturnApi build() {
		return cidade;
	}

}
