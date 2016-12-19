package entidades;
import java.util.Date;

public class Boleto {

	private int iDBoletos;
	private int codBoleto;
	private Date DataPagamento;
	private double valorPago;
	
	
	public int getiDBoletos() {
		return iDBoletos;
	}
	public void setiDBoletos(int iDBoletos) {
		this.iDBoletos = iDBoletos;
	}
	
	
	public int getCodBoleto() {
		return codBoleto;
	}
	public void setCodBoleto(int cod_boleto) {
		this.codBoleto = cod_boleto;
	}
	public Date getDataPagamento() {
		return DataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		DataPagamento = dataPagamento;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valorPago) {
		this.valorPago = valorPago;
	}
	
	
}
