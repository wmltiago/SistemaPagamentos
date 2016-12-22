<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="entidades.Fatura"%>
<%@ page import="java.util.Date"%>
<%@ page import="entidades.Boleto"%>
<%@ page import="dao.BoletoDao"%>
<%@ page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%  
Boleto B = new Boleto();
int qtBoletos = Integer.parseInt(request.getParameter("qtBoletos"));
double ValorFatura = Double.parseDouble(request.getParameter("ValorFatura"));

double vBoleto=0;
int numBoleto=0;



for(int i=1;i <=qtBoletos;i++ ){
	 String DtPagamento = request.getParameter("DtPagamento"+i);
	 
	 Date dataConvertida = null;

	 dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(DtPagamento);
	 double Valor = Double.parseDouble(request.getParameter("Valor"+i));
	 
	 B.setDataPagamento(dataConvertida);
	 B.setValorPago(Valor);
	 BoletoDao Bd = new BoletoDao();
	 
	 Bd.salvarBoleto(B);
	 
	 vBoleto = vBoleto + Valor;
	 numBoleto = numBoleto + i;
	 
 }

Fatura F = new Fatura();
 out.print(F.CondicaoDaFatura(ValorFatura, vBoleto));



%>

</body>
</html>