package com.evoluum.controller;

import java.io.OutputStream;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evoluum.model.CidadeReturnApi;
import com.evoluum.service.ListaCidadesService;

@RestController
@RequestMapping(value=ListaCidadesController.URL)

public class ListaCidadesController {

	@Value("${url.municipios}")
	String url2;
	
	@Autowired
	private ListaCidadesService service;
	
	public static final String URL = "v1/cidades";
	
	@RequestMapping(value = "/json", method=RequestMethod.GET)
	public ResponseEntity<?> geraJsonTodosMunicípios() {
		List<CidadeReturnApi> cidades = service.listaTodasAsCidadesDoPais();
		HttpStatus status = cidades.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
	
		return new ResponseEntity<>(cidades, status);
	}
	
	@RequestMapping(value = "/json/", method=RequestMethod.GET)
	@Cacheable(value="nome")
	public ResponseEntity<?> geraJsonMunicípio(@RequestParam String nomeCidade) {
		Integer cidadeId= service.encontraCidade(nomeCidade);
		HttpStatus status = cidadeId != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
	
		return new ResponseEntity<>(cidadeId != null ? cidadeId : "Cidade não encontrada", status);
	}
	
	@RequestMapping(value = "/csv", method=RequestMethod.GET)
	public ResponseEntity<?> geraCsvMunicípio() {
	
		return new ResponseEntity<>(service.geraCsv(), HttpStatus.OK);
	}
}
