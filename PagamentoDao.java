package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import conecxao.ConnectionFactory;
import entidades.Boleto;
import entidades.Fatura;
import entidades.Pagamento;

public class PagamentoDao {

	private Connection connection;

	public PagamentoDao() {

		try {
			this.connection = new ConnectionFactory().getConnection();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}


	public void salvarPagamento (Pagamento pagamento){

		try {
			String sql = "INSERT INTO pagamento (codigoPagamento, valorPagamento, dataPagamento, tipoPagamento) VALUES (?,?,?,?)";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setInt(1, pagamento.getCodPagamento());
			stmt.setDate(4, new java.sql.Date(pagamento.getDataPagamento().getTime()));
			stmt.setDouble(3, pagamento.getValorPago());


			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	public void alterar(Pagamento pagamento) {

		try {

			String sql = "UPDATE Pagamentos SET DataPagamento =?, ValorPago =?";
			PreparedStatement stmt = connection.prepareStatement(sql);

			stmt.setDate(4, new java.sql.Date(pagamento.getDataPagamento().getTime()));
			stmt.setDouble(3, pagamento.getValorPago());


			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);

		}
	}

	public List<Pagamento> listar(int codPagamento) {

		try {
			List<Pagamento> listaPagamento = new ArrayList<Pagamento>();

			String sql;
			PreparedStatement stmt = null;

			if ((nome != null && !nome.equals("")) && (email == null || email.equals(""))) {

				sql = "SELECT * FROM Pagamento WHERE nome LIKE ? ORDER BY nome";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%"+nome+"%");

			} else if ((nome == null || nome.equals("")) && (email != null && !email.equals(""))) {

				sql = "SELECT * FROM contato WHERE email LIKE ? ORDER BY nome";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%"+email+"%");

			} else if ((nome != null && !nome.equals("")) && (email != null && !email.equals(""))) {

				sql = "SELECT * FROM contato WHERE email LIKE ? and nome LIKE ? ORDER BY nome";
				stmt = this.connection.prepareStatement(sql);
				stmt.setString(1, "%"+email+"%");
				stmt.setString(2, "%"+nome+"%");

			} else {

				sql = "SELECT * FROM contato ORDER BY nome";
				stmt = this.connection.prepareStatement(sql);
			}

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				listaPagamento.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaPagamento;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	  }
		
	
	public Pagamento buscarPorId(int idPagamento) {

		try {
			Pagamento pagamento = null;

			String sql = "SELECT * FROM contato WHERE IDboletos = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, idPagamento);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				pagamento = new Pagamento();
				pagamento.setDataPagamento(rs.getDate("DataPagamento"));
				pagamento.setValorPago(rs.getDouble("valorPago"));

			}

			rs.close();
			stmt.close();
			connection.close();

			return pagamento;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	private Pagamento montarObjeto(ResultSet rs) throws SQLException {

		Pagamento pagamento = new Pagamento();
		pagamento.setDataPagamento(rs.getDate("DataPagamento"));
		pagamento.setValorPago(rs.getDouble("valorPago"));
		return pagamento;
	}
	
  }

	//metodos a serem implementados




