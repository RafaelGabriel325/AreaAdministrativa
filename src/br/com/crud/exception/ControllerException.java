package br.com.crud.exception;

public class ControllerException extends Exception{
    public ControllerException(String mensagem) {
        super("Erro no Controller no local: " + mensagem);
    }
}