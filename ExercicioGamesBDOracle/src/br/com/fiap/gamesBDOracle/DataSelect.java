package br.com.fiap.gamesBDOracle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DataSelect {
	
	public void doSelect(String cnpj) {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			Connection conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"RM84546", "221202");
			
			System.out.println("Conectou!");

			PreparedStatement pstmt = conexao.prepareStatement("SELECT * FROM games WHERE cnpj=?");
			pstmt.setString(1, cnpj);
			
			ResultSet result = pstmt.executeQuery();
			
			while(result.next()) {
				System.out.println(result.getString("cnpj") + " " +
									result.getString("nome") + " " +
									result.getString("esporte") + " " +
									result.getInt("vendas") + " " +
									result.getString("sistema"));
			}   

			System.out.println("Select realizado com sucesso!");
			
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
