package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	
	//ALTERAR OS CAMPOS DA SQL 
	public void alterar(Fatura fatura) {

		try {

			String sql = "UPDATE Fatura SET nome=?, endereco=?, email=?, data_nascimento=? WHERE id=?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setString(1, fatura.getNomeCliente());
			stmt.setInt(2, fatura.getCodFatura());
			stmt.setDate(4, new java.sql.Date(fatura.getDataVencimento().getTime()));
			stmt.setInt(5, fatura.getQtBoletos());
			stmt.setDouble(5, fatura.getValorTotal());

			stmt.execute();
			connection.close();

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	//MEXER NOS IF PARA SO PROCURAR PELO ID OU COD FATURA
	
	public void remover(int IDfatura ) {

		try {
			String sql = "DELETE FROM Fatura WHERE IDfatura  = ?";
			PreparedStatement stmt = connection.prepareStatement(sql);
			stmt.setInt(1, IDfatura );
			stmt.execute();
			connection.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	//ALTERAR AS CONDIÇÕES PARA O COD DA FATURA 
	public List<Fatura> listar(int codFatura) {

		try {
			List<Fatura> listaFatura = new ArrayList<Fatura>();

			String sql;
			PreparedStatement stmt = null;
			
			if ((nome != null && !nome.equals("")) && (email == null || email.equals(""))) {
				
				sql = "SELECT * FROM Fatura WHERE nome LIKE ? ORDER BY nome";
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
				listaFatura.add(montarObjeto(rs));
			}

			rs.close();
			stmt.close();
			connection.close();

			return listaFatura;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	
	//ADD UM ID A CLASSE FATURA ?
	public Fatura buscarPorId(int IDfatura ) {

		try {
			Fatura fatura = null;

			String sql = "SELECT * FROM contato WHERE IDfatura = ?";
			PreparedStatement stmt = this.connection.prepareStatement(sql);
			stmt.setInt(1, IDfatura);

			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {

				fatura = new Fatura();
				
				fatura.setCodFatura(rs.getInt("codFatura"));
				fatura.setNomeCliente(rs.getString("nomeCliente"));
				fatura.setQtBoletos(rs.getInt("qtBoletos"));
				fatura.setValorTotal(rs.getDouble("valorTotal"));
				fatura.setDataVencimento(rs.getDate("dataVencimento"));
			}

			rs.close();
			stmt.close();
			connection.close();

			return fatura;

		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}

	private Fatura montarObjeto(ResultSet rs) throws SQLException {

		Fatura fatura = new Fatura();
		fatura.setCodFatura(rs.getInt("codFatura"));
		fatura.setNomeCliente(rs.getString("nomeCliente"));
		fatura.setQtBoletos(rs.getInt("qtBoletos"));
		fatura.setValorTotal(rs.getDouble("valorTotal"));
		fatura.setDataVencimento(rs.getDate("dataVencimento"));
		return fatura;
	}
	
}
