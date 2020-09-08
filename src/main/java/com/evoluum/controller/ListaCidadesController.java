package com.evoluum.controller;

import com.evoluum.utils.ResponseMessages;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

@Api(tags = "Appointment controller")
public interface ListaCidadesController {

	@ApiOperation(value = "Retorna um Json com todos os municípios do Brasil.")
	@ApiResponses(value = {
			@ApiResponse(code = 200,
					message = ResponseMessages.OK_200),
			@ApiResponse(code = 400,
					message = ResponseMessages.BAD_REQUEST_400),
			@ApiResponse(code = 404, message = ResponseMessages.NOT_FOUND_404)
	})
	ResponseEntity<?> geraJsonTodosMunicípios();

	@ApiOperation(value = "Retorna o id correspondente ao município.")
	@ApiResponses(value = {
			@ApiResponse(code = 200,
					message = ResponseMessages.OK_200),
			@ApiResponse(code = 400,
					message = ResponseMessages.BAD_REQUEST_400),
			@ApiResponse(code = 404, message = ResponseMessages.NOT_FOUND_404)
	})
	ResponseEntity<?> geraJsonMunicípio(@RequestParam String nomeCidade);

	@ApiOperation(value = "Retorna um Json com todos os municípios do Brasil.")
	@ApiResponses(value = {
			@ApiResponse(code = 200,
					message = ResponseMessages.OK_200),
			@ApiResponse(code = 400,
					message = ResponseMessages.BAD_REQUEST_400),
			@ApiResponse(code = 404, message = ResponseMessages.NOT_FOUND_404)
	})
	ResponseEntity<?> geraCsvMunicípio() throws IOException;

}
