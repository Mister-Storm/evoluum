package com.evoluum.controller.impl;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

import com.evoluum.controller.ListaCidadesController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.evoluum.model.CidadeReturnApi;
import com.evoluum.service.ListaCidadesService;
import com.evoluum.utils.CriaCsv;

@RestController
@RequestMapping(value=ListaCidadesControllerImpl.URL)
public class ListaCidadesControllerImpl implements ListaCidadesController {

    @Value("${url.municipios}")
    String url2;


    private static Logger logger = LoggerFactory.getLogger(CriaCsv.class);

    @Autowired
    private ListaCidadesService service;

    public static final String URL = "v1/cidades";

    @RequestMapping(value = "/json", method= RequestMethod.GET)
    public ResponseEntity<?> geraJsonTodosMunicípios() {
        logger.info("Realizada Consulta na lista de municípios em: " + LocalDateTime.now());
        List<CidadeReturnApi> cidades = service.listaTodasAsCidadesDoPais();
        HttpStatus status = cidades.isEmpty() ? HttpStatus.NOT_FOUND : HttpStatus.OK;
        if(status == HttpStatus.NOT_FOUND) {
            logger.error("Relação de cidades não encontrada!");
        }

        return new ResponseEntity<>(cidades, status);
    }

    @RequestMapping(value = "/json/", method=RequestMethod.GET)
    @Cacheable(value="nome")
    public ResponseEntity<?> geraJsonMunicípio(@RequestParam String nomeCidade) {
        logger.info("Realizada Consulta para o município: " + nomeCidade + " em: " + LocalDateTime.now());
        Integer cidadeId= service.encontraCidade(nomeCidade);
        HttpStatus status = cidadeId != null ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        if(status == HttpStatus.NOT_FOUND) {
            logger.error("Cidade "+ nomeCidade +" não encontrada!");
        }

        return new ResponseEntity<>(cidadeId != null ? cidadeId : "Cidade não encontrada", status);
    }

    @RequestMapping(value = "/csv", method=RequestMethod.GET, produces = "application/octet-stream")
    public ResponseEntity<?> geraCsvMunicípio() throws IOException {
        logger.info("Realizada consulta no endpoint csv em: " + LocalDateTime.now());
        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=targetFile.csv");
        headers.add(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_OCTET_STREAM_VALUE);
        return ResponseEntity.ok().headers(headers).body(service.geraCsv());
    }

}
