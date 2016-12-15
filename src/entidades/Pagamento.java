package entidades;
import java.util.Date;

public class Pagamento {

	private int codPagamento;
	private double valorPago;
	private Date DataPagamento;
	private String tipoPagamento;
	
	public int getCodPagamento() {
		return codPagamento;
	}
	public void setCodPagamento(int cod_pagamento) {
		this.codPagamento = cod_pagamento;
	}
	public double getValorPago() {
		return valorPago;
	}
	public void setValorPago(double valor_pago) {
		this.valorPago = valor_pago;
	}
	public Date getDataPagamento() {
		return DataPagamento;
	}
	public void setDataPagamento(Date dataPagamento) {
		DataPagamento = dataPagamento;
	}
	public String getTipoPagamento() {
		return tipoPagamento;
	}
	public void setTipoPagamento(String tipo_pagamento) {
		this.tipoPagamento = tipo_pagamento;
	}
	
}
