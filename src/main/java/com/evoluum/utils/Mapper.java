package com.evoluum.utils;

import java.util.ArrayList;
import java.util.List;

import com.evoluum.model.Cidade;
import com.evoluum.model.CidadeReturnApi;
import com.evoluum.model.NomeFormatado;

public class Mapper {

	public static List<CidadeReturnApi> toCidadeReturnApi(List<Cidade> cidades) {

		List<CidadeReturnApi> cidadesReturn = new ArrayList<>();
 		cidades.forEach(cidade ->{
 			CidadeReturnApi cidadeReturn = new CidadeReturnApiBuilder()
 					.withId(cidade.getId())
 					.withIdEstado(cidade.getIdEstado())
					.withNomeCidade(cidade.getNome())
					.withNomeFormatado(new NomeFormatado(cidade.getUF(), cidade))
					.withNomeMesorregiao(cidade.getNomeMesorregiao())
					.withRegiaoNome(cidade.getNomeMicroRregiao())
					.withSiglaEstado(cidade.getSiglaUf())
					.build();
			cidadesReturn.add(cidadeReturn);
 		});
		return cidadesReturn;
	}
}
