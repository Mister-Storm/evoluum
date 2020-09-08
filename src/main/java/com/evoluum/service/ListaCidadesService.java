package com.evoluum.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.evoluum.model.Cidade;
import com.evoluum.model.CidadeReturnApi;
import com.evoluum.model.Uf;
import com.evoluum.repository.BuscadorDeCidadesRepository;
import com.evoluum.repository.BuscadorDeEstadosRepository;
import com.evoluum.utils.Mapper;

@Service
@CacheConfig(cacheNames = { "cidades" })
public class ListaCidadesService {

	@Autowired
	private BuscadorDeCidadesRepository cidadesRepository;
	@Autowired
	private BuscadorDeEstadosRepository estadosRepository;

	public List<CidadeReturnApi> listaTodasAsCidadesDoPais() {

		List<CidadeReturnApi> cidadesApi = new ArrayList<>();
		List<Cidade> cidades = getFullCities();
		cidadesApi.addAll(Mapper.toCidadeReturnApi(cidades));
		return cidadesApi;
	}

	private List<Cidade> getFullCities() {
		List<Cidade> cidades = new ArrayList<>();
		List<Uf> ufs = estadosRepository.getAllUfs();
		for (Uf uf : ufs) {
			List<Cidade> cidadesUf = cidadesRepository.getAllCities(uf);
			cidades.addAll(cidadesUf);
		}
		return cidades;
	}

	@Cacheable
	public Integer encontraCidade(String nomeCidade) {
		List<Cidade> cidades = this.getFullCities();

		Optional<Cidade> cidadeReturn = cidades.stream().filter(cidade -> cidade.getNome().equals(nomeCidade))
				.findFirst();
		return cidadeReturn.isPresent() ? cidadeReturn.get().getId() : null;
	}

	public OutputStream geraCsv() {
		List<CidadeReturnApi> cidades = listaTodasAsCidadesDoPais();
		File targetFile = new File("src/main/resources/targetFile.tmp");
		OutputStream outStream = null;
		try {
			outStream = new FileOutputStream(targetFile);
			outStream.write("idEstado, siglaEstado, regiaoNome, nomeCidade, nomeMesorregiao, nomeFormatado".getBytes());

			for(CidadeReturnApi cidade : cidades) {
				String line = cidade.getIdEstado().toString() + ", " + cidade.getSiglaEstado() + ", "
						+ cidade.getRegiaoNome() + ", " + cidade.getNomeCidade() + ", " + cidade.getNomeMesorregiao()
						+ ", " + cidade.getNomeFormatado();
				try {
					outStream.write(line.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return outStream;
	}
}
