package dao;

import java.sql.Connection;
import java.sql.SQLException;

import conecxao.ConnectionFactory;

public class MovimentacaoDao {
	private Connection connection;

	public MovimentacaoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
