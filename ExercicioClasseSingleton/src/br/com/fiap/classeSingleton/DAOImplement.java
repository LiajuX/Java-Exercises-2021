package br.com.fiap.classeSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOImplement {
	private Connection conexao;
	PreparedStatement pstmt = null;
	
	public void gravar(Produto produto) {
		try {
			conexao = ConnectionManager.getInstance().getConnection();
	
			pstmt = conexao.prepareStatement(
					"INSERT INTO produto (codigo, nome, data_validade, valor)"
					+ "VALUES(SEQ_PRODUTO.NEXTVAL,"
					+ "?, ?, ?)");
								
			
			pstmt.setString(1, produto.getNome());
			pstmt.setDate(2, produto.getDataValidade());
			pstmt.setDouble(3, produto.getValor());

			pstmt.executeUpdate();
			
			Statement stmt = conexao.createStatement();
			
			ResultSet result = stmt.executeQuery("SELECT * FROM produto");
			
			while(result.next()) {
				System.out.println(result.getInt("codigo")+" "+
									result.getString("nome")+" "+
									result.getDate("data_validade")+" "+
									result.getDouble("valor"));
			}
			
			stmt.close();
			
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
	
}
