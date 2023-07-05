package br.com.crud.shared;

public interface Queries {

    String SQL_ADICIONAR_USUARIO =
            "INSERT INTO usuarios " +
            "(nome, email, senha) " +
            "VALUES(?, ?, ?) returning id;";

    String SQL_LISTAR_USUARIOS =
            "SELECT * FROM usuarios u JOIN " +
            "usuarios_permissoes up ON " +
            "u.id = up.id_usuario;";

    String SQL_DELETE_USUARIO =
            "DELETE FROM usuarios WHERE id = ?;";

    String SQL_ATUALIZAR_USUARIO =
            "UPDATE usuarios SET nome = ?, email = ?, senha = ? WHERE id = ?;";

    String SQL_BUSCAR_USUARIO_POR_ID =
            "SELECT * FROM usuarios u JOIN " +
            "usuarios_permissoes up ON " +
            "u.id = up.id_usuario " +
            "WHERE " +
            "u.id = ?;";

    String SQL_LISTAR_PERMISSOES_USUARIO =
            "SELECT permissao FROM usuarios_permissoes WHERE id_usuario = ?;";

    String SQL_ADICIONAR_PERMISSAO_USUARIO =
            "INSERT INTO usuarios_permissoes (id_usuario, permissao) VALUES (?, ?);";

    String SQL_REMOVER_PERMISSAO_USUARIO =
            "UPDATE usuarios_permissoes SET permissao = NULL WHERE id_usuario = ?;";

    String SQL_EXCLUIR_PERMISSAO_USUARIO =
            "DELETE FROM usuarios_permissoes WHERE id_usuario = ?;";

    String SQL_ATUALIZARR_PERMISSAO_USUARIO =
            "UPDATE usuarios_permissoes SET permissao = ? WHERE id_usuario = ?;";
}
