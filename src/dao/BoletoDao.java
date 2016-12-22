package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.SQLException;


import conecxao.ConnectionFactory;
import entidades.Boleto;

public class BoletoDao {
	
	//FALTA IMPLEMENTAR OS OUTROS METODOS
		private Connection connection;

		public BoletoDao() {

			try {
				this.connection = new ConnectionFactory().getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
			
		
		
		//OK
		
		public void salvarBoleto(Boleto boleto) {

			try {
				String sql = "INSERT INTO Boletos (DataPagamento,ValorPago) VALUES (?,?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
		
				stmt.setDate(1, new java.sql.Date(boleto.getDataPagamento().getTime()));
				stmt.setDouble(2, boleto.getValorPago());
				
				

				stmt.execute();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		
		
		
		
}


