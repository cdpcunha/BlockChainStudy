package com.blockchain.resource.exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.blockchain.services.exceptions.ObjectNotFound;

@ControllerAdvice
public class ReourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFound.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFound e, HttpServletRequest request){
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(),status.value(), "Não Encontrado", e.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
	}

}
