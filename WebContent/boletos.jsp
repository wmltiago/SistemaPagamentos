<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="entidades.Fatura" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%   
 
Fatura F = new Fatura();
 
int CodFatura = Integer.parseInt(request.getParameter("CodFatura"));
String DtVencimento = request.getParameter("DtVencimento");
double ValorFatura = Double.parseDouble(request.getParameter("ValorFatura"));
String NomeCliente = request.getParameter("NomeCliente");
int qtBoletos = Integer.parseInt(request.getParameter("qtBoletos"));

F.setQtBoletos(qtBoletos);
F.setCodFatura(CodFatura);
F.setNomeCliente(NomeCliente);
F.setValorTotal(ValorFatura);
%>

<%=F.getCodFatura() %><br>
<%=F.getNomeCliente() %><br>
<%=F.getQtBoletos() %><br>
<%=F.getValorTotal() %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

	<form action="Teste.jsp">
		<%
		
			
			

			for (int i = 1; i <= qtBoletos; i++) {
		%>

		Boleto
		<%=i%>
		<br> Dt. Pagamento : <input type="text"></input><br> Valor :
		<input type="text"></input><br>
		-----------------------------------------------------<br>


		<%
			}
		%>
		<input type="submit" value="Enviar"></input>
	</form>


</body>
</html>