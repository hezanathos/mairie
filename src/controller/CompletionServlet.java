package controller;

import java.util.List;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CodesDAO;
import dto.Possibility;

/**
 * Servlet implementation class CompletionServlet
 */
@WebServlet("/complete")
public class CompletionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CodesDAO codesDAO;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CompletionServlet() {
		super();
		codesDAO = CodesDAO.getInstance();

	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Possibility> poss = codesDAO.getPossFromName(request.getParameter("tocomplete"));
		poss.addAll(codesDAO.getPossFromPostal(request.getParameter("tocomplete")));
		/*
		 * PrintWriter out = response.getWriter(); for(Possibility p : poss){
		 * out.append(p.toString()+"|"); }
		 */
		//request.setAttribute("Poss", poss);
		response.getWriter().println(poss);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
