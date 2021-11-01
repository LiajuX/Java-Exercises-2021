package br.com.fiap.testeBDOracleCallableStatement;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ConexaoOracle {

	public static void main(String[] args) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conexao = DriverManager.getConnection(
					"jdbc:oracle:thin:@oracle.fiap.com.br:1521:ORCL",
					"RM84546", "221202");
			
			System.out.println("Conectou!");
			
			CallableStatement cs = conexao.prepareCall("{call SP_INSERT_PRODUTO(?, ?, ?)}");
			cs.setString(1, "Calça");
			java.sql.Date data = new java.sql.Date(new java.util.Date().getTime());
			cs.setDate(2, data);
			cs.setDouble(3, 120.99);
			cs.executeUpdate();

			cs.executeUpdate();
						
			Statement stmt = conexao.createStatement();
			
			ResultSet result = stmt.executeQuery("SELECT * FROM produto");
			
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
