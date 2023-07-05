package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    private static final String DRIVER_CLASS = "org.postgresql.Driver";

    private static final String URL = "jdbc:postgresql://localhost:5432/banco_administrativo";
    private static final String USUARIO = "postgres";
    private static final String SENHA = "root";


    public static Connection getConnection() {
        try {
            Class.forName(DRIVER_CLASS);
            Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
            conexao.setAutoCommit(false);
            return conexao;
        } catch (ClassNotFoundException | SQLException ex) {
            throw new RuntimeException();
        }
    }
}
