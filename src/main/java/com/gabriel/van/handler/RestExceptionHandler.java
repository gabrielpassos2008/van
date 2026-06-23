package com.gabriel.van.handler;

import com.gabriel.van.exceptions.EmailJaExistenteExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(EmailJaExistenteExceptions.class)
    public ResponseEntity<String> emailJaExistente (EmailJaExistenteExceptions excecao){
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(excecao.getMessage());
    }

}
