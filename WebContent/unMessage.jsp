<%@page import="org.apache.commons.lang.StringEscapeUtils"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="dto.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>un message</title>
</head>
<body>
<%
//recuperation du message qui se trouve dans l'objet request
Message m=(Message)request.getAttribute("message");

if(m==null){%>
	<div>Pas de message correspondant</div>

<%}else{ %>

	<%--affichage du message --%>
	<%= m.getId() %>
	<%=StringEscapeUtils.escapeHtml( m.getMessage()) %>
<%} %>

</body>
</html>