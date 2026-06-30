package com.gabriel.van.exceptions;

public class EmailJaExistenteExceptions extends RuntimeException  {

    public EmailJaExistenteExceptions(){
        super("email ja cadastrado");
    };

    public EmailJaExistenteExceptions(String mensagem){
        super(mensagem);
    }
}
