package br.com.fiap.mercado.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.fiap.mercado.jdbc.ConnectionManager;
import br.com.fiap.mercado.entity.Produto;

public class ProdutoDAOImpl implements ProdutoDAO {
	private Connection conexao;
	
	PreparedStatement pstmt = null;
		
	@Override
	public void gravar(Produto produto) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement(
					"INSERT INTO produto (codigo, nome, data_validade, valor)"
					+ "VALUES(SEQ_PRODUTO.NEXTVAL,"
					+ "?, ?, ?)");
								
			
			pstmt.setString(1, produto.getNome());
			pstmt.setDate(2, new java.sql.Date(produto.getDataValidade().getTimeInMillis()));
			pstmt.setDouble(3, produto.getValor());

			pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void atualizar(Produto produto) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement(
					"UPDATE produto SET nome = ?, data_validade = ?, valor = ? WHERE codigo = ?");								
			
			pstmt.setString(1, produto.getNome());
			pstmt.setDate(2, new java.sql.Date(produto.getDataValidade().getTimeInMillis()));
			pstmt.setDouble(3, produto.getValor());
			pstmt.setInt(4, produto.getCodigo());

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public void remover(int codigo) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement("DELETE FROM produto WHERE codigo = ?");								

			pstmt.setInt(1, codigo);

			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	@Override
	public Produto buscarTodosPorCodigo(int codigo) {
		ResultSet rs = null;
		
		Produto produto = new Produto();

		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement("SELECT * FROM produto WHERE codigo = ?");								

			pstmt.setInt(1, codigo);
						
			rs = pstmt.executeQuery();
			
			rs.next();
			
			java.sql.Date data = rs.getDate("data_validade");
			Calendar dataValidade = Calendar.getInstance();
			dataValidade.setTimeInMillis(data.getTime());
			
			produto.setCodigo(rs.getInt("codigo"));
			produto.setNome(rs.getString("nome"));
			produto.setDataValidade(dataValidade);
			produto.setValor(rs.getDouble("valor"));

		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return produto;
	}
	
	@Override
	public List<Produto> buscarTodos() {
		List<Produto> produtos = new ArrayList<Produto>();
		ResultSet rs = null;
		
		try {
			conexao = ConnectionManager.getInstance().getConnection();
			
			pstmt = conexao.prepareStatement("SELECT * FROM produto");								
						
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				java.sql.Date data = rs.getDate("data_validade");
				Calendar dataValidade = Calendar.getInstance();
				dataValidade.setTimeInMillis(data.getTime());
				
				// Cria um objeto Produto com as informações encontradas
				Produto produto = new Produto(rs.getInt("codigo"), rs.getString("nome"), rs.getDouble("valor"), dataValidade);
		
				// Adiciona o produto na lista
				produtos.add(produto);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} finally {
			try {
				pstmt.close();
				conexao.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		return produtos;
	}
}
