package entidades;
import java.util.Date;

public class Credito {

	private int codCredito;
	private double valorCredito;
	private String nomeCliente;
	private Date dataEmissao;
	public int getCodCredito() {
		return codCredito;
	}
	public void setCodCredito(int cod_credito) {
		this.codCredito = cod_credito;
	}
	public double getValorCredito() {
		return valorCredito;
	}
	public void setValorCredito(double valor_credito) {
		this.valorCredito = valor_credito;
	}
	public String getNomeCliente() {
		return nomeCliente;
	}
	public void setNomeCliente(String nome_cliente) {
		this.nomeCliente = nome_cliente;
	}
	public Date getDataEmissao() {
		return dataEmissao;
	}
	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}
	
}
