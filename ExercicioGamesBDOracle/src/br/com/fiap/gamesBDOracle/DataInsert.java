package br.com.fiap.gamesBDOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataInsert {
	
	public void doInsert(String cnpj, String nome, String esporte, int vendas, String sistema) {	
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"RM84546", "221202");
			
			System.out.println("Conectou!");

			PreparedStatement pstmt = conexao.prepareStatement(
					"INSERT INTO games (cnpj, nome, esporte, vendas, sistema)"
					+ "VALUES(?, ?, ?, ?, ?)");
								
			pstmt.setString(1, cnpj);
			pstmt.setString(2, nome);
			pstmt.setString(3, esporte);
			pstmt.setInt(4, vendas);
			pstmt.setString(5, sistema);
			
			pstmt.executeUpdate();
			
			System.out.println("Insert realizado com sucesso!");
			
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
