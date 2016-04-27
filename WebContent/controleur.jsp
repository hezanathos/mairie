<%@ page import="dao.*,dto.*,java.util.*" %>
<%

String action=request.getParameter("action");
String pageSuivante="erreur.jsp";

try{

//BONJOUR

if("AfficherMessages".equals(action)) {
	
	List<Message> liste=MessageDAO.getInstance().getListeMessages();
	request.setAttribute("liste",liste);
	pageSuivante="listeMessages.jsp";
}
	
else if("VoirUnMessage".equals(action)){
	
	int idMessage=Integer.parseInt(request.getParameter("id"));
	Message m=MessageDAO.getInstance().getMessage(idMessage);
	request.setAttribute("message",m);
	pageSuivante="unMessage.jsp";
}


}catch(Exception e){
	e.printStackTrace();
}

%>

<jsp:forward page="<%=pageSuivante %>" />

