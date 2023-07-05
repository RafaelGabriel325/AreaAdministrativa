package br.com.crud;

import br.com.crud.controller.UsuarioController;
import br.com.crud.exception.MainException;
import br.com.crud.model.Usuario;
import br.com.crud.model.UsuarioAdministrativo;
import br.com.crud.model.UsuarioAvancado;
import br.com.crud.model.UsuarioComum;
import br.com.crud.shared.IPermissao;

import java.util.List;

public class Main {
    public static void main(String[] args) throws MainException {

        UsuarioController usuarioController = new UsuarioController();

        // Adicionar usuários
        Usuario usuario1 = new UsuarioAdministrativo("Admin", "admin@example.com", "admin123", IPermissao.USUARIO_COMUM);
        Usuario usuario2 = new UsuarioAvancado("Avançado", "admin@example.com", "admin123", IPermissao.USUARIO_AVANCADO);
        Usuario usuario3 = new UsuarioComum("Usuário Comum", "user@example.com", "user123", IPermissao.ADMIN);

        try {
            usuarioController.adicionarUsuario(usuario1);
            usuarioController.adicionarUsuario(usuario2);
            usuarioController.adicionarUsuario(usuario3);
        } catch (Exception exception) {
            throw new MainException("adicionarUsuario");
        }

        // Listar usuários
        try {
            List<Usuario> usuarios = usuarioController.listarUsuarios();
            System.out.println("Lista de Usuários:");
            for (Usuario usuario : usuarios) {
                System.out.print("ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", E-mail: " + usuario.getEmail() + ", Permissão: ");
                if (usuario.getPermissao().equals(IPermissao.ADMIN)) {
                    System.out.println("Usuario Administrador");
                } else if (usuario.getPermissao().equals(IPermissao.USUARIO_AVANCADO)) {
                    System.out.println("Usuario Avançado");
                } else if (usuario.getPermissao().equals(IPermissao.USUARIO_COMUM)) {
                    System.out.println("Usuario Comum");
                } else {
                    System.out.println("Usuario sem permissão");
                }
            }
        } catch (Exception exception) {
            throw new MainException("listarUsuarios");
        }

        // Atualizar usuário
        try {
            Usuario usuarioEncontrado = usuarioController.buscarUsuarioPorId(1);
            usuarioEncontrado.setNome("aaaaa");
            usuarioEncontrado.setEmail("bbb");
            usuarioEncontrado.setSenha("aaacccaa");
            usuarioController.atualizarUsuario(usuarioEncontrado);
        } catch (Exception exception) {
            throw new MainException("atualizarUsuario");
        }

        // Buscar usuário por ID
        try {
            Usuario usuarioEncontrado = usuarioController.buscarUsuarioPorId(1);
            System.out.print("ID: " + usuarioEncontrado.getId() + ", Nome: " + usuarioEncontrado.getNome() + ", E-mail: " + usuarioEncontrado.getEmail() + ", Permissão: ");
            if (usuarioEncontrado.getPermissao().equals(IPermissao.ADMIN)) {
                System.out.println("Usuario Administrador");
            } else if (usuarioEncontrado.getPermissao().equals(IPermissao.USUARIO_AVANCADO)) {
                System.out.println("Usuario Avançado");
            } else if (usuarioEncontrado.getPermissao().equals(IPermissao.USUARIO_COMUM)) {
                System.out.println("Usuario Comum");
            } else {
                System.out.println("Usuario sem permissão");
            }
        } catch (Exception exception) {
            throw new MainException("buscarUsuarioPorId");
        }

        // Remover permissão do usuário
        try {
            usuarioController.removerPermissaoDoUsuario(2);
        } catch (Exception exception) {
            throw new MainException("removerPermissaoDoUsuario");
        }

        // Buscar usuário por ID
        try {
            Usuario usuarioEncontrado = usuarioController.buscarUsuarioPorId(2);
            System.out.print("ID: " + usuarioEncontrado.getId() + ", Nome: " + usuarioEncontrado.getNome() + ", E-mail: " + usuarioEncontrado.getEmail() + ", Permissão: ");
            if (usuarioEncontrado.getPermissao().equals(IPermissao.ADMIN)) {
                System.out.println("Usuario Administrador");
            } else if (usuarioEncontrado.getPermissao().equals(IPermissao.USUARIO_AVANCADO)) {
                System.out.println("Usuario Avançado");
            } else if (usuarioEncontrado.getPermissao().equals(IPermissao.USUARIO_COMUM)) {
                System.out.println("Usuario Comum");
            } else {
                System.out.println("Usuario sem permissão");
            }
        } catch (Exception exception) {
            throw new MainException("buscarUsuarioPorId");
        }

        // Deletar usuário
        try {
            usuarioController.deletarUsuario(3);
        } catch (Exception exception) {
            throw new MainException("deletarUsuario");
        }

        // Listar usuários
        try {
            List<Usuario> usuarios = usuarioController.listarUsuarios();
            System.out.println("Lista de Usuários:");
            for (Usuario usuario : usuarios) {
                System.out.print("ID: " + usuario.getId() + ", Nome: " + usuario.getNome() + ", E-mail: " + usuario.getEmail() + ", Permissão: ");
                if (usuario.getPermissao().equals(IPermissao.ADMIN)) {
                    System.out.println("Usuario Administrador");
                } else if (usuario.getPermissao().equals(IPermissao.USUARIO_AVANCADO)) {
                    System.out.println("Usuario Avançado");
                } else if (usuario.getPermissao().equals(IPermissao.USUARIO_COMUM)) {
                    System.out.println("Usuario Comum");
                } else {
                    System.out.println("Usuario sem permissão");
                }
            }
        } catch (Exception exception) {
            throw new MainException("listarUsuarios");
        }

        //Atualizar permissão do usuario
        try {
            usuarioController.atualizarPermissaoDoUsuario(1, 2);
        } catch (Exception exception) {
            throw new MainException("atualizarPermissaoDoUsuario");
        }

        // Buscar usuário por ID
        try {
            Usuario usuarioEncontrado = usuarioController.buscarUsuarioPorId(2);
            System.out.print("ID: " + usuarioEncontrado.getId() + ", Nome: " + usuarioEncontrado.getNome() + ", E-mail: " + usuarioEncontrado.getEmail() + ", Permissão: ");
            if (usuarioEncontrado.getPermissao().equals(IPermissao.ADMIN)) {
                System.out.println("Usuario Administrador");
            } else if (usuarioEncontrado.getPermissao().equals(IPermissao.USUARIO_AVANCADO)) {
                System.out.println("Usuario Avançado");
            } else if (usuarioEncontrado.getPermissao().equals(IPermissao.USUARIO_COMUM)) {
                System.out.println("Usuario Comum");
            } else {
                System.out.println("Usuario sem permissão");
            }
        } catch (Exception exception) {
            throw new MainException("buscarUsuarioPorId");
        }
    }
}