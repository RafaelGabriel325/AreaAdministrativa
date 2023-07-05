package br.com.crud.dao;

import br.com.crud.exception.DAOException;
import br.com.crud.exception.UsuarioNaoEncontradoException;
import br.com.crud.factory.ConnectionFactory;
import br.com.crud.model.Usuario;
import br.com.crud.model.UsuarioAdministrativo;
import br.com.crud.model.UsuarioComum;
import br.com.crud.shared.IPermissao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static br.com.crud.shared.Queries.*;

public class UsuarioDAO {

    public void adicionarUsuario(Usuario usuario) throws DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_ADICIONAR_USUARIO)) {
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getEmail());
            statement.setString(3, usuario.getSenha());
            ResultSet resultSet = statement.executeQuery();
            conexao.commit();
            while (resultSet.next()) {
                int idUsuario = resultSet.getInt("id");
                adicionarPermissaoUsuario(idUsuario, usuario.getPermissao());}
            System.out.println("Usuário adicionado com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao adicionar usuário: " + exception.getMessage());
            throw new DAOException("adicionarUsuario");
        }
    }

    public List<Usuario> listarUsuarios() throws DAOException {
        List<Usuario> listaUsuarios = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_LISTAR_USUARIOS);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Integer permissao = resultSet.getInt("permissao");

                List<Integer> permissoes = listarPermissoesUsuario(id);

                Usuario usuario;
                if (permissoes.contains(IPermissao.ADMIN)) {
                    usuario = new UsuarioAdministrativo(id, nome, email, senha, permissao);
                } else if (permissoes.contains(IPermissao.USUARIO_AVANCADO)) {
                    usuario = new UsuarioAdministrativo(id, nome, email, senha, permissao);
                } else {
                    usuario = new UsuarioComum(id, nome, email, senha, permissao);
                }

                listaUsuarios.add(usuario);
            }
        } catch (SQLException exception) {
            System.out.println("Erro ao listar usuários: " + exception.getMessage());
            throw new DAOException("listarUsuarios");
        }

        return listaUsuarios;
    }

    public void deletarUsuario(int id) throws DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_DELETE_USUARIO)) {
            statement.setInt(1, id);
            statement.execute();
            conexao.commit();
            System.out.println("Usuário deletado com sucesso");
        } catch (SQLException exception) {
            System.out.println("Erro ao deletar usuário: " + exception.getMessage());
            throw new DAOException("deletarUsuario");
        }
    }

    public void atualizarUsuario(Usuario usuarioEncontrado) throws DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_ATUALIZAR_USUARIO)) {
            statement.setString(1, usuarioEncontrado.getNome());
            statement.setString(2, usuarioEncontrado.getEmail());
            statement.setString(3, usuarioEncontrado.getSenha());
            statement.setInt(4, usuarioEncontrado.getId());
            statement.execute();
            conexao.commit();

        } catch (SQLException exception) {
            System.out.println("Erro ao atualizar usuário: " + exception.getMessage());
            throw new DAOException("atualizarUsuario");
        }
    }

    public Usuario buscarUsuarioPorId(int id) throws UsuarioNaoEncontradoException, DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_BUSCAR_USUARIO_POR_ID)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String nome = resultSet.getString("nome");
                String email = resultSet.getString("email");
                String senha = resultSet.getString("senha");
                Integer permissao = resultSet.getInt("permissao");

                List<Integer> permissoes = listarPermissoesUsuario(id);

                if (permissoes.contains(IPermissao.ADMIN)) {
                    return new UsuarioAdministrativo(id, nome, email, senha, permissao);
                } else if (permissoes.contains(IPermissao.USUARIO_AVANCADO)) {
                    return new UsuarioAdministrativo(id, nome, email, senha, permissao);
                } else {
                    return new UsuarioComum(id, nome, email, senha, permissao);
                }
            } else {
                throw new UsuarioNaoEncontradoException("Usuário não encontrado");
            }
        } catch (SQLException exception) {
            System.out.println("Erro ao buscar usuário por ID: " + exception.getMessage());
            throw new DAOException("buscarUsuarioPorId");
        }
    }

    private List<Integer> listarPermissoesUsuario(int idUsuario) throws DAOException {
        List<Integer> permissoes = new ArrayList<>();

        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_LISTAR_PERMISSOES_USUARIO)) {
            statement.setInt(1, idUsuario);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                int permissao = resultSet.getInt("permissao");
                permissoes.add(permissao);
            }
        } catch (SQLException exception) {
            System.out.println("Erro ao listar permissões do usuário: " + exception.getMessage());
            throw new DAOException("listarPermissoesUsuario");
        }

        return permissoes;
    }

    private void adicionarPermissaoUsuario(int idUsuario, int permissao) throws DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_ADICIONAR_PERMISSAO_USUARIO)) {
            statement.setInt(1, idUsuario);
            statement.setInt(2, permissao);
            statement.execute();
            conexao.commit();
        } catch (SQLException exception) {
            System.out.println("Erro ao adicionar permissão ao usuário: " + exception.getMessage());
            throw new DAOException("adicionarPermissaoUsuario");
        }
    }

    private void removerPermissaoUsuario(int idUsuario) throws DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_REMOVER_PERMISSAO_USUARIO)) {
            statement.setInt(1, idUsuario);
            statement.execute();
            conexao.commit();
        } catch (SQLException exception) {
            System.out.println("Erro ao remover permissão do usuário: " + exception.getMessage());
            throw new DAOException("removerPermissaoUsuario");
        }
    }

    private void excluirPermissaoUsuario(int idUsuario) throws DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_EXCLUIR_PERMISSAO_USUARIO)) {
            statement.setInt(1, idUsuario);
            statement.execute();
            conexao.commit();
        } catch (SQLException exception) {
            System.out.println("Erro ao remover permissão do usuário: " + exception.getMessage());
            throw new DAOException("excluirPermissaoUsuario");

        }
    }

    private void atualizarPermissaoUsuario(int permissao,int idUsuario) throws DAOException {
        try (Connection conexao = ConnectionFactory.getConnection();
             PreparedStatement statement = conexao.prepareStatement(SQL_ATUALIZARR_PERMISSAO_USUARIO)) {
            statement.setInt(1,permissao);
            statement.setInt(2, idUsuario);
            statement.execute();
            conexao.commit();
        } catch (SQLException exception) {
            System.out.println("Erro ao remover permissão do usuário: " + exception.getMessage());
            throw new DAOException("atualizarPermissaoUsuario");

        }
    }

    public void removerPermissaoDoUsuario(int idUsuario) throws DAOException {
        removerPermissaoUsuario(idUsuario);
        System.out.println("Permissão removida do usuário com sucesso");
    }

    public void atualizarPermissaoDoUsuario(int permissao, int idUsuario) throws DAOException {
        atualizarPermissaoUsuario(permissao , idUsuario);
        System.out.println("Permissão removida do usuário com sucesso");
    }

    public void deletarUsuarioPermissao(int idUsuario) throws DAOException {
        excluirPermissaoUsuario(idUsuario);
        deletarUsuario(idUsuario);
    }
}
