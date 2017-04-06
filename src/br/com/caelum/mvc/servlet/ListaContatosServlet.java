package br.com.caelum.mvc.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

@WebServlet(name="listaContatos", urlPatterns = {"/listaContatos", "/index", "/inicio"})
public class ListaContatosServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ContatoDao dao = new ContatoDao();
		List<Contato> contatos = dao.getLista();
		
		request.setAttribute("contatos", contatos);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/lista-contatos.jsp");
		rd.forward(request, response);
	}

}