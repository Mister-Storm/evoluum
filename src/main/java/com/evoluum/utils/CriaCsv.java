package com.evoluum.utils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.evoluum.model.CidadeReturnApi;
import com.opencsv.CSVWriter;

public class CriaCsv {
	
	 private static Logger logger = LoggerFactory.getLogger(CriaCsv.class);

	public static File criarCsv(List<CidadeReturnApi> cidades) {
	File file = new File("src/main/resources/targetFile.csv"); 
    try { 
        FileWriter outputfile = new FileWriter(file); 
  

        CSVWriter writer = new CSVWriter(outputfile); 
        String[] header = { "idEstado", "siglaEstado", "regiaoNome", "nomeCidade", "nomeMesorregiao", "nomeFormatado" }; 
        writer.writeNext(header); 
  
        for(CidadeReturnApi cidade : cidades) {
			String linha[] = {cidade.getIdEstado().toString(), cidade.getSiglaEstado(), cidade.getRegiaoNome(),
					cidade.getNomeCidade(), cidade.getNomeMesorregiao(), cidade.getNomeFormatado()
			};	
			writer.writeNext(linha);
		} 
        
        writer.close(); 
    } 
    catch (IOException e) { 
    	logger.error(e.getMessage());
    }
    return file;
	}
}
