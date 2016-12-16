<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="entidades.Fatura" %>
<%@ page import="java.util.Date" %>
    <%@ page import="entidades.Boleto" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%  
Fatura F = new Fatura();
int qtBoletos = Integer.parseInt(request.getParameter("qtBolentos"));
for(int i = 1; i<=qtBoletos;i++){
String Dtpagamento = request.getParameter("DtPagamento"+i);
String Valor = request.getParameter("Valor"+i);
out.print(Valor);%><br><%
out.print(Dtpagamento);%><br><%


}





%>
</body>
</html>