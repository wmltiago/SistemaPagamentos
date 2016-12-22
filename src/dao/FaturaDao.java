package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conecxao.ConnectionFactory;
import entidades.Fatura;

public class FaturaDao {
	private Connection connection;

	public FaturaDao() {

		
		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	
	//OK
	
	public void salvarFatura(Fatura fatura) {

		try {
			String sql = "INSERT INTO Fatura (nomeCliente, valorFatura, dtVencimento) VALUES (?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			

			stmt.setString(1,fatura.getNomeCliente());
			stmt.setDouble(2, fatura.getValorTotal());
			stmt.setDate(3, new java.sql.Date(fatura.getDataVencimento().getTime()));
			
			
			

			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	



	
	

	
	

	
	
}
