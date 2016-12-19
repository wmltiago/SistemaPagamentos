package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
				String sql = "INSERT INTO fatura (codigoFatura,nomeCliente, valorFatura, dtVencimento, qtBoletos) VALUES (?,?,?,?,?)";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, boleto.getCodBoleto());
				stmt.setDate(4, new java.sql.Date(boleto.getDataPagamento().getTime()));
				stmt.setDouble(3, boleto.getValorPago());
				
				

				stmt.execute();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		
		//OK
		
		public void alterar(Boleto boleto) {

			try {

				String sql = "UPDATE Boletos SET CodBoleto=?, DataPagamento =?, ValorPago =? WHERE IDboletos=?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				
				stmt.setInt(1, boleto.getCodBoleto());
				stmt.setDate(4, new java.sql.Date(boleto.getDataPagamento().getTime()));
				stmt.setDouble(3, boleto.getValorPago());
				stmt.setInt(5, boleto.getiDBoletos());

				stmt.execute();
				connection.close();

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		public void remover(int idBoletos) {

			try {
				String sql = "DELETE FROM Boletos WHERE IDboletos = ?";
				PreparedStatement stmt = connection.prepareStatement(sql);
				stmt.setInt(1, idBoletos);
				stmt.execute();
				connection.close();
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		
		//MEXER NOS IF PRA DEIXAR SO POR ID 
		
		public List<Boleto> listar(String nome, String email) {

			try {
				List<Boleto> listaBoleto = new ArrayList<Boleto>();

				String sql;
				PreparedStatement stmt = null;
				
				if ((nome != null && !nome.equals("")) && (email == null || email.equals(""))) {
					
					sql = "SELECT * FROM contato WHERE nome LIKE ? ORDER BY nome";
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
					listaBoleto.add(montarObjeto(rs));
				}

				rs.close();
				stmt.close();
				connection.close();

				return listaBoleto;
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}

		
		//OK
		
		public Boleto buscarPorId(int idBoletos) {

			try {
				Boleto boleto = null;

				String sql = "SELECT * FROM contato WHERE IDboletos = ?";
				PreparedStatement stmt = this.connection.prepareStatement(sql);
				stmt.setInt(1, idBoletos);

				ResultSet rs = stmt.executeQuery();

				while (rs.next()) {

					boleto = new Boleto();
					boleto.setiDBoletos(rs.getInt("id"));
					boleto.setDataPagamento(rs.getDate("DataPagamento"));
					boleto.setCodBoleto(rs.getInt("codBoleto"));
					boleto.setValorPago(rs.getDouble("valorPago"));
					
				}

				rs.close();
				stmt.close();
				connection.close();

				return boleto;

			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
		}
		
		//OK
		
		private Boleto montarObjeto(ResultSet rs) throws SQLException {

			Boleto boleto = new Boleto();
			boleto.setiDBoletos(rs.getInt("id"));
			boleto.setDataPagamento(rs.getDate("DataPagamento"));
			boleto.setCodBoleto(rs.getInt("codBoleto"));
			boleto.setValorPago(rs.getDouble("valorPago"));
			return boleto;
		}
		
		
		
}


