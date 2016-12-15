package dao;

import java.sql.Connection;
import java.sql.SQLException;

import conecxao.ConnectionFactory;

public class PagamentoDao {
	
		private Connection connection;

		public PagamentoDao() {

			try {
				this.connection = new ConnectionFactory().getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		
		
		//metodos a serem implementados
		
		
}
	
