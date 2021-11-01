package br.com.fiap.gamesBDOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DataDelete {

	public void doDelete(String cnpj) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"RM84546", "221202");
			
			System.out.println("Conectou!");

			PreparedStatement pstmt = conexao.prepareStatement("DELETE FROM games WHERE cnpj=?");
			pstmt.setString(1, cnpj);
			
			pstmt.executeUpdate();

			System.out.println("Delete realizado com sucesso!");
			
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
}
