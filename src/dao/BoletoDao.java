package dao;

import java.sql.Connection;
import java.sql.SQLException;

import conecxao.ConnectionFactory;

public class BoletoDao {
	
	
		private Connection connection;

		public BoletoDao() {

			try {
				this.connection = new ConnectionFactory().getConnection();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
}


