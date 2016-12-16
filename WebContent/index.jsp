<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="entidades.Fatura" %>

   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Sistema de Pagamentos</title>
</head>
<body><form method="POST" action="boletos.jsp">
	Cod. Fatura:<input type="text" name="CodFatura"></input> <br>
	DT. Vencimento:<input type="text" name="DtVencimento"></input><br>
	 Valor:<input type="text" name="ValorFatura"></input><br>
	  Nome Cliente:<input type="text" name="NomeCliente"></input><br>
	   Quantidade Boletos:<input type="number" name="qtBoletos"></input><br>
	   <input type="submit" value="enviar"></input>
	   </form>
</body>


</html>
