package br.com.crud.controller;

import br.com.crud.exception.ControllerException;
import br.com.crud.model.Usuario;
import br.com.crud.service.UsuarioService;

import java.io.Serializable;
import java.util.List;

public class UsuarioController implements Serializable {

    private UsuarioService usuarioService;

    public UsuarioController() {
        this.usuarioService = new UsuarioService();
    }

    public void adicionarUsuario(Usuario usuario) throws ControllerException {
        try{
            usuarioService.adicionarUsuario(usuario);
        } catch (Exception exception) {
            throw new ControllerException("adicionarUsuario");
        }
    }

    public List<Usuario> listarUsuarios() throws ControllerException {
        try{
            return usuarioService.listarUsuarios();
        } catch (Exception exception) {
            throw new ControllerException("listarUsuarios");
        }
    }

    public void deletarUsuario(int idUsuario) throws ControllerException {
        try {
            usuarioService.deletarUsuario(idUsuario);
        } catch (Exception exception) {
            throw new ControllerException("deletarUsuario");
        }
    }

    public void atualizarUsuario(Usuario usuario) throws ControllerException {
        try{
            usuarioService.atualizarUsuario(usuario);
        } catch (Exception exception) {
            throw new ControllerException("atualizarUsuario");
        }
    }

    public Usuario buscarUsuarioPorId(int id) throws ControllerException {
        try {
            return usuarioService.buscarUsuarioPorId(id);
        } catch (Exception exception) {
            throw new ControllerException("buscarUsuarioPorId");
        }
    }

    public void removerPermissaoDoUsuario(int idUsuario) throws ControllerException {
        try {
            usuarioService.removerPermissaoDoUsuario(idUsuario);
        } catch (Exception exception) {
            throw new ControllerException("removerPermissaoDoUsuario");
        }
    }

    public void atualizarPermissaoDoUsuario(int permissao, int idUsuario) throws ControllerException {
        try {
            usuarioService.atualizarPermissaoDoUsuario(permissao, idUsuario);
        } catch (Exception exception) {
            throw new ControllerException("atualizarPermissaoDoUsuario");
        }
    }
}