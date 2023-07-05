package br.com.crud.exception;

public class MainException extends Exception{
    public MainException(String mensagem) {
        super("Erro no Main na hora de rodar: " + mensagem);
    }
}