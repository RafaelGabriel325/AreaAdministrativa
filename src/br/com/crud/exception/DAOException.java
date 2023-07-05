package br.com.crud.exception;

public class DAOException extends Exception{
    public DAOException(String mensagem) {
        super("Erro no DAO no local: " + mensagem);
    }
}
