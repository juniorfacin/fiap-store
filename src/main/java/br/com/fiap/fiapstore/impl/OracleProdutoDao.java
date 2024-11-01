package br.com.fiap.fiapstore.impl;

import br.com.fiap.fiapstore.dao.ConnectionManager;
import br.com.fiap.fiapstore.dao.ProdutoDao;
import br.com.fiap.fiapstore.exception.DBException;
import br.com.fiap.fiapstore.model.Produto;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class OracleProdutoDao implements ProdutoDao {

    @Override
    public void cadastrar(Produto produto) throws DBException {

        PreparedStatement stmt = null;

        Connection conexao = ConnectionManager.getInstance().getConnection();

        String sql = "INSERT INTO TB_PRODUTO " +
                "(COD_PRODUTO, NOME_PRODUTO, QTDE_PRODUTO, " +
                "VALOR_PRODUTO, DATA_FABRICACAO) " +
                "VALUES (SQ_TB_PRODUTO.NEXTVAL, ?, ?, ?, ?)";

        try {
            stmt = conexao.prepareStatement(sql);
            stmt.setString( 1, produto.getNome());
            stmt.setInt( 2, produto.getQuantidade());
            stmt.setDouble(3, produto.getValor());
            stmt.setDate(4, Date.valueOf(produto.getDataFabricacao()));
            stmt.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                stmt.close();
                conexao.close();
            } catch (SQLException e) {
            }
        }
    }

    @Override
    public void atualizar(Produto produto) throws DBException {

    }

    @Override
    public void remover(Produto produto) throws DBException {

    }

    @Override
    public Produto buscar(int id) {
        return null;
    }

    @Override
    public List<Produto> listar() {
        return List.of();
    }
}
