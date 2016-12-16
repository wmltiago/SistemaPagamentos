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
	
	public void salvarFatura(Fatura fatura) {

		try {
			String sql = "INSERT INTO fatura (codigoFatura,nomeCliente, valorFatura, dtVencimento, qtBoletos) VALUES (?,?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);
			
			stmt.setInt(1, fatura.getCodFatura());
			stmt.setString(2,fatura.getNomeCliente());
			stmt.setDouble(3, fatura.getValorTotal());
			stmt.setDate(4, new java.sql.Date(fatura.getDataVencimento().getTime()));
			stmt.setInt(5, fatura.getQtBoletos());
			
			

			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
}
