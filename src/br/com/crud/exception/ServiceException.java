package br.com.crud.exception;

public class ServiceException extends Exception{
    public ServiceException(String mensagem) {
        super("Erro no Service no local: " + mensagem);
    }
}
