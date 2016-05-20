package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

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
	private CodesDAO codesDAO;
	public AffichageServlet() {
	codesDAO = CodesDAO.getInstance();
	}
	/**
	 * @see HttpServlet(HttpServletRequest req, HttpServletResponse resp)
	 */
	protected void service(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		PrintWriter out = resp.getWriter();
		String search = req.getParameter("villes");
		try{
			
			Possibility poss = codesDAO.getPossFromName(search).get(0);
			Mairie mairie = MairieDAO.getMairieFromINSEE(poss.getINSEE(),getServletContext().getRealPath("/"));
			req.setAttribute("userInput", mairie);
			this.getServletContext().getRequestDispatcher("/affichageMairie.jsp").forward(req,resp);
		}finally {
			out.println("");
		}
	}
	
	
	
}