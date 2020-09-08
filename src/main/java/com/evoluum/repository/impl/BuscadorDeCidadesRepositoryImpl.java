package com.evoluum.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.evoluum.model.Cidade;
import com.evoluum.model.Uf;
import com.evoluum.repository.BuscadorDeCidadesRepository;

@Repository
public class BuscadorDeCidadesRepositoryImpl implements BuscadorDeCidadesRepository{
	
	@Value("${url.municipios}")
	String url;
	
	@Override
	public List<Cidade> getAllCities(Uf uf) {
		RestTemplate rt = new RestTemplate();
		List<Cidade> cidades = Arrays.asList(rt.getForEntity(url, Cidade[].class , uf.getSigla()).getBody());
		cidades.forEach(cidade -> {
			cidade.setUf(uf);
		});
		return cidades;
	}

}
