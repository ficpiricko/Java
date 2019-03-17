<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="projekcije.beans.Film"%> 
<%@page import="projekcije.beans.Projekcija"%> 
<%@page import="java.util.ArrayList"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%ArrayList<Projekcija> projekcije = (ArrayList<Projekcija>)getServletContext().getAttribute("projekcije"); %>

<table border="1">
	<tr>
		<th>Film</th>
		<th>Vreme</th>
		<th>Cena</th>
		<th>Duzina</th>
		<th>Sala</th>
		<th>Tip</th>
		
	</tr>
	<%for (Projekcija p : projekcije) { %>
		<%if (p.getTip().equals("3D")) {  %>
		<tr>
		<td><%= p.getFilm().getNaziv() %></td>
		<td><%=p.getVreme() %></td>
		<td><%=p.getCena()%></td>
		<td><%=p.getDuzina() %></td>
		<td><%=p.getBrojSale() %></td>
		<td><%=p.getTip() %></td>
		
		</tr>
		<% } %>
		<% } %>

</table>
</body>
</html>