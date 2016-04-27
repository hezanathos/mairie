<%@ page language="java" import="java.util.*,dto.*,org.apache.commons.lang.*" 
 contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Liste Messages</title>
</head>
<body>
<%
List<Message> liste=(List<Message>)request.getAttribute("liste");
%>
<table>
<%
for(Message m:liste){
%>
<tr>
<td><%=m.getId() %></td>
<td><%=StringEscapeUtils.escapeHtml(m.getExpediteur()) %></td>
<td><%=StringEscapeUtils.escapeHtml(m.getMessage()) %></td>

<%}%>
</table>
</body>
</html>