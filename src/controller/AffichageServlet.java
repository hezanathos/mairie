package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import dao.*;
import dto.*;



@WebServlet("/AffichageServlet")
public class AffichageServlet extends HttpServlet{
	private static final long serialVersionUID = -8724195532620288137L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//String L =System.getProperty("line.separator");
		PrintWriter out = resp.getWriter();
		String search = req.getParameter("userInput");
		try{
			//get INSEE
		Mairie mairie = MairieDAO.getMairieFromINSEE(search);
		req.setAttribute("userInput", mairie);
		this.getServletContext().getRequestDispatcher("/affichageMairie.jsp").forward(req,resp);
		}finally {
			out.println("");
		}
		//this.getServletContext().getRequestDispatcher("/affichageMairie.jsp").forward(req,resp);
	}
	
	
	
}