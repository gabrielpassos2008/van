package com.gabriel.van.exceptions;

public class ClienteNaoEncontradoException extends RuntimeException{

    public ClienteNaoEncontradoException(){
        super("Cliente não Encontrado");
    }
    public ClienteNaoEncontradoException(String mensagem){
        super(mensagem);
    }
}
