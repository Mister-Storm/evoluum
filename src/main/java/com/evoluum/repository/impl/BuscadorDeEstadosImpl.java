package com.evoluum.repository.impl;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

import com.evoluum.model.Uf;
import com.evoluum.repository.BuscadorDeEstadosRepository;

@Repository
public class BuscadorDeEstadosImpl implements BuscadorDeEstadosRepository{

	@Value("${url.estados}")
	String url;
	
	@Override
	public List<Uf> getAllUfs() {
	
		RestTemplate rt = new RestTemplate();
		
		List<Uf> ufs = Arrays.asList(rt.getForEntity(url, Uf[].class).getBody());

		return ufs;
	}

}
