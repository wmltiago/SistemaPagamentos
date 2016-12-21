<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Fatura" %>
<%@ page import="java.util.Date" %>
<%@ page import="dao.FaturaDao" %>
<%@ page import="entidades.Boleto" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%   
 
Fatura F = new Fatura();
 

String DtVencimento = request.getParameter("DtVencimento");
Date dataConvertida = null;

dataConvertida = new SimpleDateFormat("dd/MM/yyyy").parse(DtVencimento);


double ValorFatura = Double.parseDouble(request.getParameter("ValorFatura"));
String NomeCliente = request.getParameter("NomeCliente");
int qtBoletos = Integer.parseInt(request.getParameter("qtBoletos"));

F.setDataVencimento(dataConvertida);
F.setNomeCliente(NomeCliente);
F.setValorTotal(ValorFatura);
FaturaDao fat = new FaturaDao();
fat.salvarFatura(F);


%>


<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
Cod Fatura : <%=F.getCodFatura() %><br>
Nome cliente : <%=F.getNomeCliente() %><br>

Data Vencimento :<%=F.getDataVencimento() %><br>
Valor total a Ser Pago: <%=F.getValorTotal() %><br>
----------------------------------------------------

	<form action="MostrarBoleto.jsp" method="POST">
		<%
		 Boleto B = new Boleto();
			
			

			for (int i = 1; i <= qtBoletos; i++) {
		%>

		Boleto
		<%=i%>
		<br> Dt. Pagamento : <input type="text" name="DtPagamento<%=i%>" ></input><br> 
		Valor :<input type="text" name="Valor<%=i%>"></input><br>
		-----------------------------------------------------<br>


		<%
		 
		
			}
		%>
		<input type="hidden"  name="qtBoletos" value="<%=qtBoletos%>"></input>
		<input type="hidden"  name="ValorFatura" value="<%=ValorFatura%>"></input>
		<input type="submit" value="Enviar"></input>
		
	</form>


</body>
</html>