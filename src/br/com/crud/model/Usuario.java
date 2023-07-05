package br.com.crud.model;

import br.com.crud.exception.PermissaoNaoSuportadaException;

import java.io.Serializable;
import java.util.Objects;

public abstract class Usuario implements Serializable {
    private Integer id;
    private String nome;
    private String email;
    private String senha;
    private Integer permissao;

    public Usuario() {
    }

    public Usuario(String nome, String email, String senha, Integer permissao) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
    }

    public Usuario(Integer id, String nome, String email, String senha, Integer permissao) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.permissao = permissao;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setPermissao(Integer permissao) {
        this.permissao = permissao;
    }

    public Integer getId() {
        return this.id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public Integer getPermissao() {
        return permissao;
    }

    public abstract void adicionarPermissao(Integer permissao) throws PermissaoNaoSuportadaException;

    public abstract void removerPermissao(Integer permissao) throws PermissaoNaoSuportadaException;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(id, usuario.id) &&
                Objects.equals(nome, usuario.nome) &&
                Objects.equals(email, usuario.email) &&
                Objects.equals(senha, usuario.senha) &&
                Objects.equals(permissao, usuario.permissao);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, email, senha, permissao);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", senha='" + senha + '\'' +
                ", permissao=" + permissao +
                '}';
    }
}