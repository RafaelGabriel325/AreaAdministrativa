package br.com.crud.service;

import br.com.crud.dao.UsuarioDAO;
import br.com.crud.exception.ServiceException;
import br.com.crud.model.Usuario;

import java.util.List;

public class UsuarioService {

    private UsuarioDAO usuarioDAO;

    public UsuarioService() {
        this.usuarioDAO = new UsuarioDAO();
    }

    public void adicionarUsuario(Usuario usuario) throws ServiceException {
        try {
            usuarioDAO.adicionarUsuario(usuario);
        } catch (Exception exception) {
            throw new ServiceException("adicionarUsuario");
        }

    }

    public List<Usuario> listarUsuarios() throws ServiceException {
        try {
            return usuarioDAO.listarUsuarios();
        } catch (Exception exception) {
            throw new ServiceException("listarUsuarios");
        }
    }

    public void deletarUsuario(int idUsuario) throws ServiceException {
        try {
            usuarioDAO.deletarUsuarioPermissao(idUsuario);
        } catch (Exception exception) {
            throw new ServiceException("deletarUsuario");
        }
    }

    public void atualizarUsuario(Usuario usuario) throws ServiceException {
        try {
            usuarioDAO.atualizarUsuario(usuario);
        } catch (Exception exception) {
            throw new ServiceException("atualizarUsuario");
        }
    }

    public Usuario buscarUsuarioPorId(int id) throws ServiceException {
        try {
            return usuarioDAO.buscarUsuarioPorId(id);
        } catch (Exception exception) {
            throw new ServiceException("buscarUsuarioPorId");
        }
    }

    public void removerPermissaoDoUsuario(int idUsuario) throws ServiceException {
        try {
            usuarioDAO.removerPermissaoDoUsuario(idUsuario);
        } catch (Exception exception) {
            throw new ServiceException("removerPermissaoDoUsuario");
        }
    }

    public void atualizarPermissaoDoUsuario(int permissao, int idUsuario) throws ServiceException {
        try {
            usuarioDAO.atualizarPermissaoDoUsuario(permissao, idUsuario);
        } catch (Exception exception) {
            throw new ServiceException("atualizarPermissaoDoUsuario");
        }
    }
}