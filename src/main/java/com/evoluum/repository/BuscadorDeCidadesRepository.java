package com.evoluum.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.evoluum.model.Cidade;
import com.evoluum.model.Uf;

@Repository
public interface BuscadorDeCidadesRepository {

	List<Cidade> getAllCities(Uf uf);
	
}
