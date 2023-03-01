package com.example.genpessosapi.resources.exceptions;

import com.example.genpessosapi.services.exceptions.PessoaNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class PessoaExceptionHandler {

    @ExceptionHandler(PessoaNotFoundException.class)
    public ResponseEntity<StandarError> resourceNotFound(PessoaNotFoundException e, HttpServletRequest request){
        String error ="Resource not found";
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandarError err = new StandarError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());
        return ResponseEntity.status(status).body(err);
    }
}
