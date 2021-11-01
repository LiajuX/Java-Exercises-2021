package br.com.fiap.gamesBDOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataUpdate {
	
	public void doUpdate(int vendas, String cnpj) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"RM84546", "221202");
			
			System.out.println("Conectou!");

			PreparedStatement pstmt = conexao.prepareStatement("UPDATE games SET vendas=? WHERE cnpj=?");
			pstmt.setInt(1, vendas);
			pstmt.setString(2, cnpj);
			
			pstmt.executeUpdate();

			System.out.println("Update realizado com sucesso!");
			
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
