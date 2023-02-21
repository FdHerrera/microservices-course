package com.fdherrera.controller;

import java.util.logging.Logger;

import com.fdherrera.model.HttpClientExceptionDTO;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.HttpClientErrorException;

@ControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = Logger.getLogger(GlobalExceptionHandler.class.getName());

	@ExceptionHandler( HttpClientErrorException.class )
	public ResponseEntity<HttpClientExceptionDTO> handleClientErrorException(HttpClientErrorException hcee) {
		log.severe("Exception thrown trying to connect with a resource: " + hcee.getMessage());
		return new ResponseEntity<HttpClientExceptionDTO>(new HttpClientExceptionDTO(hcee.getResponseBodyAsString()), hcee.getStatusCode());
	}

}
