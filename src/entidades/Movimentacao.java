package entidades;
import java.util.Date;

public class Movimentacao {

	private int codMovimentacao;
	private Date dataAtual;
	private int numeroDeBoletos;
	private double totalPago;
	public int getCodMovimentacao() {
		return codMovimentacao;
	}
	public void setCodMovimentacao(int codMovimentacao) {
		this.codMovimentacao = codMovimentacao;
	}
	public Date getDataAtual() {
		return dataAtual;
	}
	public void setDataAtual(Date dataAtual) {
		this.dataAtual = dataAtual;
	}
	public int getNumeroDeBoletos() {
		return numeroDeBoletos;
	}
	public void setNumeroDeBoletos(int numeroDeBoletos) {
		this.numeroDeBoletos = numeroDeBoletos;
	}
	public double getTotalPago() {
		return totalPago;
	}
	public void setTotalPago(double totalPago) {
		this.totalPago = totalPago;
	}
}
