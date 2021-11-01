package br.com.fiap.testeBDOracle;

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
			
			Statement stmt = conexao.createStatement();
			
			/*
			stmt.executeUpdate(
					"INSERT INTO produto (codigo, nome, data_validade, valor)"
					+ "VALUES(SEQ_PRODUTO.NEXTVAL,"
					+ "'meia listrada', to_date('19/08/2021', 'dd/mm/yyyy'), 14.55)");
			*/
			
			String sqlUpdate = "UPDATE produto SET valor = 15.82 WHERE codigo = 23";
			stmt.executeUpdate(sqlUpdate);
			
			String sqlDelete = "DELETE FROM produto WHERE codigo = 42";
			stmt.executeUpdate(sqlDelete);
			
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
