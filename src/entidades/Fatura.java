package entidades;
import java.util.Date;

public class Fatura {
	
private int codFatura;
private Date DataVencimento;
private double valorTotal;
private String nomeCliente;


public int getCodFatura() {	return codFatura;
}
public void setCodFatura(int codFatura) {
	this.codFatura = codFatura;
}
public Date getDataVencimento() {
	return DataVencimento;
}
public void setDataVencimento(Date dataVencimento) {
	DataVencimento = dataVencimento;
}
public double getValorTotal() {
	return valorTotal;
}
public void setValorTotal(double valorTotal) {
	this.valorTotal = valorTotal;
}
public String getNomeCliente() {
	return nomeCliente;
}
public void setNomeCliente(String nomeCliente) {
	this.nomeCliente = nomeCliente;
}




}
