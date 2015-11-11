<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Resultado</title>
</head>
<body>

	<%
		String valorA = request.getParameter("valorA");
		String valorB = request.getParameter("valorB");
		String opcao = request.getParameter("opcao");

		double dValorA = Double.parseDouble(valorA);
		double dValorB = Double.parseDouble(valorB);
		double resultado = 0;

		if (opcao.equals("+")) {
			resultado = dValorA + dValorB;
		} else if (opcao.equals("-")) {
			resultado = dValorA - dValorB;
		} else if (opcao.equals("*")) {
			resultado = dValorA * dValorB;
		} else if (opcao.equals("/")) {
			resultado = dValorA / dValorB;
		}
		
		out.print("Resultado : " + resultado);
		
	%>
	
	<br /><a href="CalcJSP.html">Voltar - Fazer Novo Calculo</a>

</body>
</html>