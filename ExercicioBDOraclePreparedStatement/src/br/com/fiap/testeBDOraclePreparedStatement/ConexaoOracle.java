package br.com.fiap.testeBDOraclePreparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ConexaoOracle {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"RM84546", "221202");
			
			System.out.println("Conectou!");
			
			// INSERT			
			PreparedStatement pstmt = conexao.prepareStatement(
					"INSERT INTO produto (codigo, nome, data_validade, valor)"
					+ "VALUES(SEQ_PRODUTO.NEXTVAL,"
					+ "?, ?, ?)");
								
			
			pstmt.setString(1, "terno");
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			pstmt.setDate(2, data);
			pstmt.setDouble(3, 120.50);
	
			pstmt.executeUpdate();
			
			// UPDATE
			pstmt = conexao.prepareStatement("UPDATE produto SET valor=? WHERE codigo=?");
			pstmt.setDouble(1, 20.50);
			pstmt.setInt(2, 41);
			
			pstmt.executeUpdate();

			// DELETE
			pstmt = conexao.prepareStatement("DELETE FROM produto WHERE codigo=?");
			pstmt.setInt(1, 23);
			
			pstmt.executeUpdate();
			
			// SELECT
			pstmt = conexao.prepareStatement("SELECT * FROM produto");
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getInt("codigo")+ " " +
									result.getString("nome") + " " +
									result.getDate("data_validade") + " " +
									result.getDouble("valor"));
			}
			
			conexao.close();
			
		} catch (SQLException e) {
			System.err.println("Não foi possível conectar no Oracle");
			e.printStackTrace();
		
		} catch (ClassNotFoundException e) {
			System.err.println("O Driver JDBC não foi encontrado");
			e.printStackTrace();
		}
	}

}
