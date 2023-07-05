package br.com.crud.model;

import br.com.crud.exception.PermissaoNaoSuportadaException;
import br.com.crud.shared.IPermissao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UsuarioAvancado extends Usuario implements Serializable {
    private List<Integer> permissoes;

    public UsuarioAvancado(){
    }

    public UsuarioAvancado(String nome, String email, String senha, Integer permissao) {
        super(nome, email, senha, permissao);
        this.permissoes = new ArrayList<>();
    }

    public UsuarioAvancado(Integer id, String nome, String email, String senha, Integer permissao) {
        super(id, nome, email, senha, permissao);
        this.permissoes = new ArrayList<>();
    }

    @Override
    public void adicionarPermissao(Integer permissao) throws PermissaoNaoSuportadaException {
        if (permissao == IPermissao.ADMIN || permissao == IPermissao.USUARIO_AVANCADO || permissao == IPermissao.USUARIO_COMUM) {
            if (!permissoes.contains(permissao)) {
                permissoes.add(permissao);
            }
        } else {
            throw new PermissaoNaoSuportadaException("Permissão não suportada - Model");
        }
    }

    @Override
    public void removerPermissao(Integer permissao) throws PermissaoNaoSuportadaException {
        if (permissao == IPermissao.ADMIN || permissao == IPermissao.USUARIO_AVANCADO || permissao == IPermissao.USUARIO_COMUM) {
            permissoes.remove(Integer.valueOf(permissao));
        } else {
            throw new PermissaoNaoSuportadaException("Permissão não suportada - Model");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        UsuarioAvancado that = (UsuarioAvancado) o;
        return Objects.equals(permissoes, that.permissoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), permissoes);
    }

}