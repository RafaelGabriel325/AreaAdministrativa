package br.com.crud.model;

import br.com.crud.exception.PermissaoNaoSuportadaException;

import java.io.Serializable;

public class UsuarioComum extends Usuario implements Serializable {

    public UsuarioComum(){
    }

    public UsuarioComum(String nome, String email, String senha, Integer permissao) {
        super(nome, email, senha, permissao);
    }

    public UsuarioComum(Integer id, String nome, String email, String senha, Integer permissao) {
        super(id, nome, email, senha, permissao);
    }

    @Override
    public void adicionarPermissao(Integer permissao) throws PermissaoNaoSuportadaException {
        throw new PermissaoNaoSuportadaException("Usuário comum não suporta permissões - Model");
    }

    @Override
    public void removerPermissao(Integer permissao) throws PermissaoNaoSuportadaException {
        throw new PermissaoNaoSuportadaException("Usuário comum não suporta permissões - Model");
    }
}