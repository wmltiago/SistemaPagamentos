package dao;

import java.sql.Connection;
import java.sql.SQLException;

import conecxao.ConnectionFactory;

public class CreditoDao {

	private Connection connection;

	public CreditoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
