package br.com.crud.exception;

public class PermissaoNaoSuportadaException extends Exception {
    public PermissaoNaoSuportadaException(String mensagem) {
        super(mensagem);
    }
}
