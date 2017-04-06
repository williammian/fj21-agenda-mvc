package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

@WebServlet("/formAlteraContato")
public class FormAlteraContatoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Long id = Long.parseLong(request.getParameter("id"));
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = dao.get(id);
		
		request.setAttribute("contato", contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/altera-contato.jsp");
		rd.forward(request, response);
	}

}
