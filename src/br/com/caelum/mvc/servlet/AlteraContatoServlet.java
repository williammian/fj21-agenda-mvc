package br.com.caelum.mvc.servlet;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.dao.ContatoDao;
import br.com.caelum.modelo.Contato;

@WebServlet("/alteraContato")
public class AlteraContatoServlet extends HttpServlet{
	
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Long id = Long.parseLong(request.getParameter("id"));
		String nome = request.getParameter("nome");
		String email = request.getParameter("email");
		String endereco = request.getParameter("endereco");
		String datanascimento = request.getParameter("datanascimento");
		
		Date dtNasc = null;
		try{
			dtNasc = new SimpleDateFormat("dd/MM/yyyy").parse(datanascimento);
		}catch(ParseException err){
			err.printStackTrace();
			return;
		}
		
		Contato contato = new Contato();
		contato.setId(id);
		contato.setNome(nome);
		contato.setEmail(email);
		contato.setEndereco(endereco);
		contato.setDatanascimento(dtNasc);
		
		ContatoDao dao = new ContatoDao();
		dao.altera(contato);
		
		request.setAttribute("nome", nome);
		
		RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/jsp/contato-alterado.jsp");
		rd.forward(request, response);
	}

}
