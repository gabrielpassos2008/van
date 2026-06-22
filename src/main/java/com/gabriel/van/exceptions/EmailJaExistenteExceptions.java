package com.gabriel.van.exceptions;

public class EmailJaExistenteExceptions extends RuntimeException  {

    public EmailJaExistenteExceptions(){
        super("email ja cadastrador");
    };

    public EmailJaExistenteExceptions(String mensagem){
        super(mensagem);
    }
    
}
